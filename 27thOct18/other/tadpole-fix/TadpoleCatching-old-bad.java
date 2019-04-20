import java.util.*;
import java.lang.*;
import java.io.*;

public class TadpoleCatching
{
	class Tadpole {
		double x, y;
		public Tadpole (double x, double y) { this.x=x; this.y=y; }
	}

	double r;

	double distance(Tadpole a, Tadpole b) {
		return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
	}

	// Competitive Programming III p. 278
	Tadpole circle2TadRad(Tadpole t1, Tadpole t2) {
		double d2 = Math.pow(t1.x - t2.x, 2) + Math.pow(t1.y - t2.y, 2);
		double det = r * r / d2 - 0.25;
		if (det < 0.0) return null;
			double h = Math.sqrt(det);
			Tadpole c = new Tadpole(0, 0);
			c.x = (t1.x + t2.x) * 0.5 + (t1.y - t2.y) * h;
			c.y = (t1.y + t2.y) * 0.5 + (t2.x - t1.x) * h;
			return c;	// to get the other center, reverse t1 and t2
	}

	public static void main(String[] args)
	{
		(new TadpoleCatching()).run();
	}

	public void run() {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while(n-- > 0) {
			int m = in.nextInt();
			r = in.nextDouble()/2;
			Tadpole[] tpl = new Tadpole[m];
			for(int i = 0; i < m; i++) {
				tpl[i] = new Tadpole(in.nextDouble(), in.nextDouble());
			}
			int max = 0;
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < m; j++) {
					Tadpole c = tpl[i];
					if(i != j) c = circle2TadRad(tpl[i], tpl[j]);
					if(c == null) continue;
					int tmax = 0;
					for(int k = 0; k < m; k++) {
						if(distance(tpl[k], c) <= r) tmax++;
					}
					max = Math.max(max, tmax);
				}
			}
			System.out.println(max);
		}
	}
}
