// Arup Guha
// 5/16/2013
// Solution to 2003 South East Regional Problem J: Treasure Island

import java.util.*;

public class search {
	
	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		int numWords = stdin.nextInt();
		int caseNum = 1;
		
		// Go through each case.
		while (numWords != 0) {
		
			String[] words = new String[numWords];
		
			// Read in search words.
			for (int i=0; i<numWords; i++)
				words[i] = stdin.next();	
					
			// Read in grid.
			int numRows = stdin.nextInt();
			int numCols = stdin.nextInt();
			String[] grid = new String[numRows];
			for (int i=0; i<numRows; i++)
				grid[i] = stdin.next();
			puzzle wordSearch = new puzzle(grid);
				
			boolean allFound = true;
				
			// Go through each word.
			System.out.println("Puzzle number "+caseNum+":");
			for (int i=0; i<numWords; i++) {
				if (!wordSearch.contains(words[i])) {
					System.out.println(words[i]);
					allFound = false;
				}
			}
			
			// Just in case all words were in the puzzle.
			if (allFound)
				System.out.println("ALL WORDS FOUND"); 
			System.out.println();
			
			// Get next case.
			numWords = stdin.nextInt();
			caseNum++;
		}
	}
}

class puzzle {
	
	private char[][] board;
	private int numRows;
	private int numCols;
	
	public puzzle(String[] rows) {
		
		// Set up dimensions.
		numRows = rows.length;
		numCols = rows[0].length();
		board = new char[numRows][numCols];
		
		// Initialize board.
		for (int i=0; i<numRows; i++)
			for (int j=0; j<numCols; j++)
				board[i][j] = rows[i].charAt(j);
	}
	
	public boolean contains(String word) {
		
		// Try each position.
		for (int i=0; i<numRows; i++)
			for (int j=0; j<numCols; j++)
				if (containsAt(word, i, j))
					return true;
					
		// Never found the word.
		return false;
	}
	
	private boolean containsAt(String word, int x, int y) {
		
		// Go through eight directions.
		for (int dx=-1; dx<=1; dx++) {
			for (int dy=-1; dy<=1; dy++) {
				
				if (dx == 0 && dy == 0) continue;
				
				// Loop through each letter.
				int i;
				for (i=0; i<word.length(); i++) 
					if (!validRow(x+dx*i) || !validCol(y+dy*i) || word.charAt(i) != board[x+dx*i][y+dy*i]) break;
				
				// Passed the test.
				if (i == word.length()) return true;
			}
		}
		
		// If we get here, we never found the word.
		return false;
	}
	
	private boolean validRow(int r) {
		return r >= 0 && r < numRows;
	}
	
	private boolean validCol(int c) {
		return c >= 0 && c < numCols;
	}
}