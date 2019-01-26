
import java.util.*;
import java.io.*;

public class git_font
{
   public static void main(String[] args) throws Exception
   {
      PrintWriter out = new PrintWriter(System.out);
      new git_font(new Scanner(System.in), out);
      out.close();
   }

   int idCounter;
   int[] linesAdded;
   HashMap<String, Integer> nameToId;

   int N, D;
   int[][] par;

   int findFirstBefore(int pos, int time)
   {
      //System.out.printf("Search %d %d%n", pos, time);
      for (int d=D; d>=0; d--)
         if (par[d][pos] > time)
            pos = par[d][pos];
      //System.out.printf("Found %d %d%n", pos, time);
      if (pos <= time)
         return pos;
      return par[0][pos];
   }

   public git_font(Scanner in, PrintWriter out)
   {
      idCounter = 1;
      nameToId = new HashMap<>();
      int numCommands = in.nextInt();       

      N = numCommands+1;
      D = Integer.numberOfTrailingZeros(Integer.highestOneBit(N));
      par = new int[D+1][N];
      linesAdded = new int[N];
      for (int[] dd : par) Arrays.fill(dd, -1);

      for (int i=0; i<numCommands; i++)
      {
         int a, b;
         String versionid, newversion, cmd;
         cmd = in.next();
         versionid = in.next();
         
         switch (cmd)
         {
            case "new":
               par[0][idCounter] = 0;
               nameToId.put(versionid, idCounter);
               idCounter++;
               break;
         
            case "branch":
               newversion = in.next();

               a = nameToId.get(versionid);
               b = idCounter++;

               nameToId.put(newversion, b);
               par[0][b] = a;
               break;
            
            case "commit":
               a = nameToId.get(versionid);
               b = idCounter++;

               linesAdded[b] = in.nextInt();
               nameToId.put(versionid, b);
               par[0][b] = a;
               break;
            
            default:
               out.println("Invalid command.");
               return;
         }
      }

      for (int i=1; i<N; i++)
         if (par[0][i] != -1)
            linesAdded[i] += linesAdded[par[0][i]];

      for (int d=1; d<=D; d++) for (int i=0; i<N; i++) if (par[d-1][i] != -1)
         par[d][i] = par[d-1][par[d-1][i]];

      int Q = in.nextInt();
      while (Q-->0)
      {
         int a = in.nextInt()-1;
         int b = in.nextInt();
         String name = in.next();
         Integer nodeId = nameToId.get(name);

         int res = 0;
         if (nodeId != null)
         {
            int x = findFirstBefore(nodeId, a);
            int y = findFirstBefore(nodeId, b);
            //System.out.printf("xx %d%n", nodeId);
            //System.out.printf("%d %d%n", x, y);
            res = linesAdded[y]-linesAdded[x];
         }
         out.println(res);
      }
   }
}
