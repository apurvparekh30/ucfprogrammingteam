// Arup Guha
// 7/18/2016
// Solution to CS1 Problem: Maze, written for SI@UCF to illustrate BFS.

import java.util.*;

public class maze {

	public static int r;
	public static int c;
	public static char[][] grid;
	
	// Possible directions of movement.
	final public static int[] DX = {-1,0,0,1};
	final public static int[] DY = {0,-1,1,0};
	
	public static void main(String[] args) {
		
		Scanner stdin = new Scanner(System.in);
		int numCases = stdin.nextInt();
		
		// Process each case.
		for (int loop=0; loop<numCases; loop++) {
			
			// Read in dimensions and grid.
			r = stdin.nextInt();
			c = stdin.nextInt();
			grid = new char[r][];
			for (int i=0; i<r; i++)
				grid[i] = stdin.next().toCharArray();
			
			// Find the starting point and run our bfs.
			int start = find('S');
			System.out.println(bfs(start));
		}	
	}
	
	public static int find(char ch) {
		
		// Look for the first occurrence of ch and return its position.
		for (int i=0; i<r; i++)
			for (int j=0; j<c; j++)
				if (grid[i][j] == ch)
					return c*i+j;
				
		// Never found ch.	
		return -1;
	}	
		
	public static int bfs(int loc) {
		
		int sX = loc/c;
		int sY = loc%c;
		
		// Set up distance array.
		int[][] dist = new int[r][c];
		for (int i=0; i<r; i++)
			Arrays.fill(dist[i], -1);
			
		// This we know...
		dist[sX][sY] = 0;
		
		// Set up queue.
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(loc);
		
		// Run usual BFS.
		while (q.size() > 0) {
			
			// Get next item.
			int next = q.poll();
			int nextR = next/c;
			int nextC = next%c;
			
			// If we made it to the exit, we are free!!!
			if (nextR == 0 || nextR == r-1 || nextC == 0 || nextC == c-1)
				return dist[nextR][nextC];
				
			for (int i=0; i<DX.length; i++) {
				int x = nextR + DX[i];
				int y = nextC + DY[i];
				
				// Not a new valid square to go to, so skip it.
				if (!inbounds(x,y) || dist[x][y] != -1 || grid[x][y] == 'X') continue;
				
				// Add to queue and mark distance.
				q.offer(x*c+y);
				dist[x][y] = dist[nextR][nextC] + 1;
			}
		}
		
		// If we get here, we never got out.
		return -1;
	}
	
	public static boolean inbounds(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}
}