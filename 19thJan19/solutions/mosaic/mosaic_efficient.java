/*  ACM Mid-Central Programming competition 2015 Problem G: Mosaic
    solution by Andy Harrington

recursive solution with pruning of white angles other than 180 or interior 90
by looking at the center of 2x2 tiles patterns centered at each corner
of a proposed next tile.  Legal patterns are precalculated and hashed.
*/

import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class mosaic_efficient {
    public static void main(String[] args) {
      mosaic.go(args);
    }
}

class mosaic {  

   static int W, H, totTri = 0, spots,     
              up, down, left = -1, right = 1, // index change for directions
              UNSET = 0, TRISE = 1, TRISW = 2, TRINW = 3, TRINE = 4,// piece 
              WHITE = 5, BLACK = 6; // codes, tri's indicate black-black corner
   static int[] grid,   // linearized grid, edges of plain black, codes 0-6
                triLeft,// 0-4 tri's left for marked black, negative for others
                nbLeft, // tracked for each black, must be >= triLeft
                boxCode, // neighbor code for pruning, 
                        //    2x2 square centered at NW corner of grid loc
                        // SE piece code + SW << 3 + NW << 6 + NE << 9 
                sideShift,  // index shift for right, down, left, up
                PIECES = new int[] {TRISE, TRISW, TRINW, TRINE, WHITE, BLACK},
                NON_BLACK = new int[] {TRISE, TRISW, TRINW, TRINE, WHITE},
                TRI = new int[] {TRISE, TRISW, TRINW, TRINE};
   static boolean[] legalBoxCode = new boolean[7<<9];
   static int[][] triSides = new int[7][4]; //[piece][direction index to side]
                                            // -> 1 if triange side there
   static int[] origTri;  // debug display

   static void go(String[] args) 
   {
      if (args.length > 0) DEBUG = Integer.parseInt(args[0]); //debug
      Scanner in = new Scanner(System.in);
      W = in.nextInt();
      H = in.nextInt();
      down = W+2;  //border on each side 
      up = -down;
      spots = (down)*(H+2);
      grid = new int[spots];
      boxCode = new int[spots];  // for 2x2 box centered in NW corner of spot
      triLeft = new int[spots];  // tri left for UNSET neighb of tallied BLACK
      sideShift = new int[] {right, down, left, up};  // clockwise around
      Arrays.fill(grid, BLACK); // sets edges, and their 
      Arrays.fill(triLeft, -2); //     tri counts are not tracked
      for (int ig = down+right, r = 1; r <= H; r++, ig+=2 ) {
          char[] line = in.next().toCharArray();
          for (char c: line) { 
              if (c == '.') 
                grid[ig] = UNSET;
              else {
                 grid[ig] = BLACK;
                 if ('0' <= c && c <= '4')
                    triLeft[ig] = c - '0';
              }
              ig++;
          }
      }
      origTri = triLeft.clone();  // debug - remember orig to check
      nbLeft = new int[spots];   // unset neighb for tallied BLACK >= triLeft
      for (int ig = down+right; ig < spots+up; ig++)
         if (triLeft[ig] >= 0) // tallied black
            for (int shift: sideShift)
               if (grid[ig+shift] == UNSET)
                   nbLeft[ig]++;
      // set 2 black sides for each triangle
      for (int piece: TRI)
          triSides[piece][piece-1] = triSides[piece][piece%4] = 1;
      setLegalBoxCodes(); // speed up pruning
      setStartingBoxCodes();
      if (solve(down+right)) // from first official grid position
          System.out.println(totTri);
      else
          System.err.println("Error: no solution");

   }

   static void setStartingBoxCodes() 
   {
       for (int igb = down+right; igb < spots; igb++) {
           int ig = igb+up, bc = 0; 
           for (int i = 6; i > 2; i--) {
              bc = (bc << 3) + grid[ig];
              ig += sideShift[i%4];
           }  
           boxCode[igb] = bc;
       }
   }

   static void setOkFullBoxCodes(int partial, int step, 
                                 List<Integer> fullCodes) {
       if (step == 4) {
          if (okCode(partial))
                fullCodes.add(partial);
       } else 
          for (int piece: PIECES)  //insert next corner piece code
              setOkFullBoxCodes(partial+(piece<<3*step), step+1, fullCodes);
   }

   // central prune:  true if only internal white angles 90, 180 degrees
   static boolean okCode(int bCode)
   {
       String s = ""; // sequence of 45 degree 1-black or 0-white sectors
       for (int i = 2; i < 6; i++) {
          int iDir = i % 4, piece = bCode & 7;
          if (piece == BLACK) s += "11";
          else if (piece == WHITE) s += "00";
          else s+=""+triSides[piece][(iDir+1)%4]+triSides[piece][iDir];
          bCode >>=3;
       }
       s +=s;  // get all seequences in circle
       return !s.contains("1") || //  - all white
              !(s.contains("00000") || s.contains("101") || s.contains("10001"));
   }              //  > 180, not 360                45                   135

   static void setLegalBoxCodes()  // now can check without all 4 parts set
   { 
      ArrayList<Integer> fullCodes = new ArrayList<Integer>();
      setOkFullBoxCodes(0, 0, fullCodes);
      for (int code: fullCodes) {
         for (int i = 1; i < 16; i++) { // allow any part to be UNSET = 000b
            int mask = 0;  //dup bits 3 times, get 4 fields of 000, 111
            for (int pow = 0; pow < 4; pow++) {
               if ((i & (1<<pow)) > 0) 
                  mask += (7 << 3*pow);
            }
            legalBoxCode[mask&code] = true;
         }
      }
   }

   static boolean okPiece(int ig, int piece){ // check piece again boxCodes
       int shiftedCode = piece, boxI = ig;
       for (int i = 0; i < 4; i++) {
           if (!legalBoxCode[shiftedCode+boxCode[boxI]])
               return false;
           boxI += sideShift[i]; 
           shiftedCode <<= 3; 
           int iShifted = ig +sideShift[i];
           if (triLeft[iShifted] >= 0 &&  // are beside tallied black and
               // no more allowed OR
               (triLeft[iShifted] - triSides[piece][i] < 0 ||
                // tri left after piece not enough for unset spaces after piece
                triLeft[iShifted] - triSides[piece][i] >= nbLeft[iShifted]))
              return false;
       }
       return true;
   }

   static void changesForPiece(int ig, int piece) {
       int shiftedCode = piece, boxI = ig;
       for (int i = 0; i < 4; i++) {
           int iShifted = ig +sideShift[i];
           boxCode[boxI] += shiftedCode;
           boxI += sideShift[i];
           shiftedCode <<= 3; 
           if (triLeft[iShifted] >= 0) {
              triLeft[iShifted] -= triSides[piece][i];
              nbLeft[iShifted]--;
           }
       }
       grid[ig] = piece;
       if (piece != WHITE) totTri++;
   }

   static void resetAfterBadPiece(int ig, int piece) {
       int shiftedCode = piece, boxI = ig;
       for (int i = 0; i < 4; i++) {
           int iShifted = ig +sideShift[i];
           boxCode[boxI] -= shiftedCode;
           boxI += sideShift[i];
           shiftedCode <<= 3; 
           if (triLeft[iShifted] >= 0) {
              triLeft[iShifted] += triSides[piece][i];
              nbLeft[iShifted]++;
           }
       }
       grid[ig] = UNSET;
       if (piece != WHITE) totTri--;
   }

   static boolean solve(int ig) 
   {
      if (DEBUG > 0) showState(ig);
      if (ig == spots+up) {
        if (DEBUG > 0) showGraphic(grid); //debug
        return true;
      }
      if (grid[ig] != UNSET) 
          return solve(ig+1);
      for (int piece: NON_BLACK) {
          if (okPiece(ig, piece)) {
              changesForPiece(ig, piece);
              if (solve(ig+1))
                  return true;
              resetAfterBadPiece(ig, piece);
          }
      }
      return false;
   }

   // DEBUG display from here on
   static int DEBUG = 0;  // level of debug info shown 0: none; 3: most
   static void showGrid(int[] g, int w)
   {
      String f = ((w==1) ? "%d" : "%5o");
      for (int ig = 0; ig < spots; ig++) {
           System.err.format(f, g[ig]);
           if (ig % down == down-1) 
              System.err.println();
      }

   }

   static void showState(int ig)
    { 
      System.err.println("ig:"+ig);
      showGrid(grid,1);
      System.err.println("---");
      showGrid(boxCode,5);
    }
      

   static void showGraphic(int[] g)
   {
      int count = 0;
      String[][] s = {{"???", "  /", "\\  ", "**/", "\\**", "   ", "***"},
                      {"???", " /*", "*\\ ", "*/ ", " \\*", "   ", "***"},
                      {"???", "/**", "**\\", "/  ", "  \\", "   ", "***"} };
      String[] gr = {"", "", ""}, forced = {"000", "111", "222", "333", "444"};
      System.err.println("sol for " + totTri);
      for (int ig = down+right; ig < spots+up; ig++) {
           int piece = g[ig];
           for (int i = 0; i < 3; i++) {
              if (origTri[ig] < 0)
                 gr[i] += s[i][piece];
              else
                 gr[i] += forced[origTri[ig]];

           }
           if (0 < g[ig] && g[ig] < 5) count++;
           if (ig % down == down-2) {
              for (int i = 0; i < 3; i++) {
                 System.err.println(gr[i]);
                 gr[i] = "";
              }
              ig += 2;
            }
      }
      System.err.println("actual totTri " + count);

   }

   static String oct(int n)
   {
      return String.format("%o", n);
   }

   static String doct(int n)
   {
      return String.format("%o[%d]", n, n);
   }

   static void dpr(String s, int d) { // debug print; no newline
     if (DEBUG >= d) System.err.print(s);
   }

   static void dprln(String s, int d) { // debug print with newline
     dpr(s+'\n', d);
   }
}
