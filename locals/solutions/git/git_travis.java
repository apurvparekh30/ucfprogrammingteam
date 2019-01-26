
import java.util.*;
import java.io.*;

public class git_travis
{
   public static HashMap<String, Integer> last_map;
   public static HashSet<Integer>[] adj;
   public static int[] curDepth;
   public static int[] revPreOrder;
   public static int[] code;
   public static int curOrder;
   public static void main(String[] Args) throws Exception
   {
      BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(sc.readLine());
      if (n < 1 || n > 100000)
      {
         throw new Exception("BAD N");
      }
      last_map = new HashMap<String, Integer>();
      last_map.put("", 0);
      adj = new HashSet[n + 1];
      revPreOrder = new int[n + 1];
      curDepth = new int[n + 1];
      code = new int[n + 1];
      skip = new int[18][n + 1];
      curOrder = 0;
      code[0] = 0;

      for (int i = 0; i < n + 1; i++)
      {
         adj[i] = new HashSet<Integer>();
      }

      // Read in the log
      for (int i = 1; i <= n; i++)
      {
         // Get the type
         String[] line = sc.readLine().split(" ");
         int type = -1;
         if (line[0].equals("new"))
         {
            type = 0;
         }
         else if (line[0].equals("branch"))
         {
            type = 1;
         }
         else if (line[0].equals("commit"))
         {
            type = 2;
         }
         if (type == -1)
         {
            throw new Exception("INVALID TYPE");
         }
         if (line.length != 2 && (type == 0))
         {
            throw new Exception("BAD TOKEN COUNT");
         }
         if (line.length != 3 && (type == 1 || type == 2))
         {
            throw new Exception("BAD TOKEN COUNT");
         }
         String a = "";
         String b = "";

         // New case
         if (type == 0)
         {
            b = line[1];
         }
         else if (type == 1)
         {
            a = line[1];
            b = line[2];
         }

         if (type == 0 || type == 1)
         {
            if (!last_map.containsKey(a))
            {
               throw new Exception("UNKNOWN KEY");
            }
            if (last_map.containsKey(b))
            {
               throw new Exception("DUPE ID");
            }
            if (check(b))
            {
               throw new Exception("BAD ID");
            }
            last_map.put(b, i);
            adj[last_map.get(a)].add(i);
            code[i] = code[last_map.get(a)];
         }
         else
         {
            if (!last_map.containsKey(line[1]))
            {
               throw new Exception("UNKNOWN ID");
            }
            adj[last_map.get(line[1])].add(i);
            code[i] = Integer.parseInt(line[2]) + code[last_map.get(line[1])];
            last_map.put(line[1], i);
         }
      }

      // Perform the dfs to get the depths and pre-orders
      dfs(0,0);

      // Generate the skip list
      int[] stk = new int[n + 2];
      for (int i = 0; i < 18; i++)
         Arrays.fill(skip[i], 0);
      for (int i = 0; i <= n; i++)
      {
         while (stk[0] != 0 && curDepth[stk[stk[0]]] >= curDepth[revPreOrder[i]])
         {
            stk[0]--;
         }

         // Add the current value to the stack
         stk[++stk[0]] = revPreOrder[i];

         // Get power of two skips
         for (int j = 0; 1 <= stk[0] - (1 << j); j++)
         {
            // this is the length of the stack minus a power of 2
            skip[j][revPreOrder[i]] = stk[stk[0] - (1 << j)];
         }
      }

      // Read in the number of queries
      int q = Integer.parseInt(sc.readLine());

      // Read in each query
      for (int i = 0; i < q; i++)
      {
         String[] line = sc.readLine().split(" ");
         if (line.length != 3)
         {
            throw new Exception("BAD TOKEN COUNT");
         }
         int a = Integer.parseInt(line[0]);
         int b = Integer.parseInt(line[1]);
         if (a > b || a < 1 || b < 1 || a > n || b > n)
         {
            throw new Exception("BAD QUERY");
         }
         if (check(line[2]))
         {
            throw new Exception("BAD KEY");
         }
         if (!last_map.containsKey(line[2]))
         {
            System.out.println(0);
            continue;
         }
         int index = last_map.get(line[2]);

         // Not really lca. This uses a skip list to find the bounds of the path
         a = lcaHigh(index, a-1);
         b = lcaLow(index, b);

         // Print the answer
         System.out.println(code[b] - code[a]);
      }
   }

   public static int[][] skip;

   public static int lcaHigh(int a, int time)
   {
      if (a <= time)
         return a;
      int index = 0;
      // Maybe not equal
      while (skip[index + 1][a] > time)
      {
         index++;
      }
      return lcaHigh(skip[index][a], time);

   }

   public static int lcaLow(int a, int time)
   {
      if (a <= time)
         return a;
      int index = 0;

      while (skip[index + 1][a] >= time)
      {
         index++;
      }
      return lcaLow(skip[index][a], time);
   }
   
   public static void dfs(int in, int d)
   {
      curDepth[in] = d;
      revPreOrder[curOrder++] = in;
      for (int i : adj[in])
      {
         dfs(i, d + 1);
      }
   }

   // Checks the version id
   public static boolean check(String s)
   {
      if (s.length() < 0 || s.length() > 10)
      {
         return true;
      }
      for (int i = 0 ; i < s.length(); i++)
      {
         if ((s.charAt(i) < 'a' || s.charAt(i) > 'z') && 
            (s.charAt(i) < 'A' || s.charAt(i) > 'Z') && 
            (s.charAt(i) < '0' || s.charAt(i) > '9'))
         {
            return true;
         }
      }
      return false;
   }
}
