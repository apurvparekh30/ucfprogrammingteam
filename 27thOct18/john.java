import java.util.*;

class newdeal {

	static int min;
	static int[] box;
	static Boolean[][] memo;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for (int m = 1; m <= t; m++)
		{
			int k = in.nextInt();
			box = new int[k];
			
			int max = 0;
			min = 0;
			for (int i = 0; i < k; i++)
			{
				box[i] = in.nextInt();
				if (box[i] > 0) max += box[i];
				if (box[i] < 0) min -= box[i];
			}
			
			//System.out.println(min);

			memo = new Boolean[k][max+min+1];
			
			int T = in.nextInt();
			boolean can = dp(0, 0, T);
			
			if (can)
				System.out.println("Test case #"+m+": You can hit the target "+T+" and win $10M!");
			else
				System.out.println("Test case #"+m+": You can not hit the target "+T+", sorry!");
		}
		
		in.close();
	}
	
	public static boolean dp(int at, int sum, int tar)
	{
		if (sum == tar) return true;
		if (at == memo.length) return false;
		if (memo[at][sum+min] != null) return memo[at][sum+min];
		boolean res = dp(at+1, sum+box[at], tar) || dp(at+1, sum, tar);
		return memo[at][sum+min] = res;
	}
	
}

/*
2
5 2 3 4 -1 -2 1
6 1 2 3 4 5 6 30
*/
