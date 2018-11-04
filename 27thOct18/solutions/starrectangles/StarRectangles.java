import java.io.*;
import java.util.*; 
public class StarRectangles {
	class Star implements Comparable<Star> {
		int x, y;
		public Star(int x, int y) {this.x = x; this.y = y;}
		public int compareTo(Star o) {
			if(this.x == o.x) return this.y - o.y;
			return this.x - o.x;
		}
		public String toString() {
			return "("+x+","+y+")";
		}
	}

	public static void main(String[] args) {
		(new StarRectangles()).run();
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		int maps = in.nextInt();
		for(int map = 1; map <= maps; map++) {
			int num_stars = in.nextInt();
			Star[] stars = new Star[num_stars];
			for(int star = 0; star < num_stars; star++) {
				stars[star] = new Star(in.nextInt(), in.nextInt());
			}
			Arrays.sort(stars);
			int maxRectArea = -1;
			Star[] maxRect = new Star[4];
			for(int a = 0; a < num_stars; a++) {
				for(int b = a+1; b < num_stars; b++) {
					// find two on same y coordinate
					if(stars[a].y == stars[b].y) {
						// two pointers. move both methodically
						// increment lower y value, stop if x changes on either
						int c = a+1;
						int d = b+1;
						while(c < num_stars && d < num_stars && 
								stars[a].x == stars[c].x && stars[b].x == stars[d].x) {
							// we have a rectangle!!!
							if(stars[c].y == stars[d].y) {
								Star[] rect = { stars[a], stars[c], stars[b], stars[d] };
								int area = (rect[2].x - rect[0].x)*(rect[1].y - rect[0].y);
								if(area > maxRectArea) {
									maxRectArea = area;
									maxRect = rect;
								}
								// if same, check which is lexographically best
								else if(area == maxRectArea) {
									for(int i = 0; i < 4; i++) {
										if(rect[i].compareTo(maxRect[i]) > 0) break;
										if(rect[i].compareTo(maxRect[i]) < 0) {
											maxRect = rect;
											break;
										}
									}
								}
								c++; d++;
							}
							else if(stars[c].y < stars[d].y) c++;
							else d++;
						}
					}
				}
			}
			System.out.println(maxRect[0] + " , " + maxRect[1] + " , " + 
					maxRect[2] + " , " + maxRect[3]);
		}
	}
}
