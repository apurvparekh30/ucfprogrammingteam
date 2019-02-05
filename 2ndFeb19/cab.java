import java.util.*;
import java.io.*;

class cab{

	static FastReader fs = new FastReader();
	static List<Integer> []adj;
	static char [][]words;
	static char last;
	static int n;
	static int []deg;

	public static void main(String[] args) {
		last = fs.next().charAt(0);
		n = fs.nextInt();
		words = new char[n][];
		adj = new ArrayList[last-'a'+1];
		deg = new int[adj.length];
		for(int i=0;i<adj.length;i++){
			adj[i] = new ArrayList<Integer>();
		}
		for(int i=0;i<n;i++){
			words[i] = fs.next().toCharArray();
		}
		boolean incon = false,incom = false;
		for(int i=0;i<n-1;i++){
			char[] curr = words[i];
			char[] next = words[i+1];
			int length = Math.min(curr.length,next.length);
			int idx = -1;
			for(int j=0;j<length;j++){
				if(curr[j]!=next[j]){
					idx = j;
					break;
				}
			}
			if(idx == -1){
				if(curr.length > next.length){
					incon = true;
				}
				continue;
			}
			adj[curr[idx] - 'a'].add(next[idx] - 'a');
		}
		
		for(int i=0;i<adj.length;i++){
			for(int node:adj[i]){
				deg[node]++;
			}
		}
		Deque<Integer> q = new ArrayDeque<Integer>();
		for(int i=0;i<adj.length;i++)
			if(deg[i]==0)
				q.add(i);

		if(q.size()==0)
			incon = true;
			
		StringBuilder ans = new StringBuilder();
		
		while(!q.isEmpty()){
			if(q.size() > 1){
				incom = true;
			}
			int curr = q.poll();
			ans.append((char)(curr + 'a'));
			for(int node:adj[curr]){
				deg[node]--;
				if(deg[node]==0){
					q.add(node);
				}
			}
		}
		if(ans.length()!=adj.length)  /// for dag like   .____.____.
			incon = true;			  ///					  |_.__|

			
		if(incon)
			System.out.println(1);
		else if(incom)
			System.out.println(0);
		else
			System.out.println(ans);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;
	
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
	
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
	
		int nextInt() {
			return Integer.parseInt(next());
		}
	
		long nextLong() {
			return Long.parseLong(next());
		}
	
		double nextDouble() {
			return Double.parseDouble(next());
		}
	
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}