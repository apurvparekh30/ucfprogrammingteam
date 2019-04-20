import java.util.*;

public class wordclouds
{
    public static int[] vals, hs, ws;
    public static int oo = 987654321;
    public static void main(String[] Args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        w = sc.nextInt();
        vals = new int[n + 1];
        hs = new int[n];
        ws = new int[n];
        for (int i = 0; i < n; i++)
        {
            ws[i] = sc.nextInt();
            hs[i] = sc.nextInt();
        }
        
        Arrays.fill(vals, -1);
        vals[n] = 0;
        
        System.out.println(rec(0));
    }
    public static int n;
    public static int w;
    
    public static int rec(int pos)
    {
        if (vals[pos] != -1)
            return vals[pos];
        vals[pos] = oo;
        int cW = 0;
        int cH = 0;
        for (int i = pos; i < n; i++)
        {
            cW += ws[i];
            if (cH < hs[i])
                cH = hs[i];
            if (cW <= w)
            {
                int tans = cH + rec(i + 1); 
                if (tans < vals[pos])
                    vals[pos] = tans;
            }
            else
            {
                break;
            }
        }
        return vals[pos];
    }
}