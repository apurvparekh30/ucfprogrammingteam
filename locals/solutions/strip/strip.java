import java.util.*;

public class strip {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
			
			char[] st = in.next().toCharArray();
			int n = st.length;
			/*
			 	I concatenate the original input with with itself both reversed and inverted
			 	for example ++-+-+- becomes ++-+-+-$+-+-+--
			 	
			 	The concatenation needs to be reversed since folding the strip reverses the side that is folded over.
			 	The concatenation needs to be inverted since you match positives to negatives, and I'm using
			 	suffix arrays to find the match with longest common prefix which will match positives to positives
			 	and negatives to negatives.
			 	
			 	I switch out the characters with numbers, although this is not necessary.
			 	+ becomes 1, - becomes 0 and $ becomes 2. The example above turns into 
			 	the array {1,1,0,1,0,1,0,2,1,0,1,0,1,0,0}	 	
			 */
			int[] concatedAndconverted = new int[n*2+1];
			concatedAndconverted[n] = 2;
			for(int i =0; i < n; i++){
				int num = st[i] == '+' ? 1 : 0;
				concatedAndconverted[i] = num;
				concatedAndconverted[2*n-i] = 1-num;
			}
			
			SuffixArray sa = new SuffixArray(concatedAndconverted);
			//sa = suffix array
				//index to suffix array sorted index
			int[] indexToSaSortedIndex = sa.P[sa.P.length-1];
			
			IndexPair[] indices = new IndexPair[concatedAndconverted.length];
			
			for(int i =0; i < indexToSaSortedIndex.length; i++){
				indices[i] = new IndexPair(i, indexToSaSortedIndex[i]);
			}
			
		
			//these are the indices I can take without fear of the resulting answer overlapping
			TreeSet<IndexPair> tsAvailabe = new TreeSet<>();
			
			int best = 0;
			//Looping over the second half of concatedAndconverted
			for(int j = n+1; j <concatedAndconverted.length; j++){
				IndexPair at = indices[j];
				IndexPair lower = tsAvailabe.lower(at);
				
				//TreeSet higher and lower will  contain the longest matches among all the indices I've added so far
				if(lower != null){
					best = Math.max(best, sa.lcp(at.originalIndex, lower.originalIndex));
				}
				
				IndexPair higher =tsAvailabe.higher(at);
				if(higher != null){
					best = Math.max(best, sa.lcp(at.originalIndex, higher.originalIndex));
				}
				
				//Make the corresponding index in  the first half of concatedAndconverted available
				//It might seem that I'm missing possible answers, but try to make a break case.
				//For any match between substrings A and B, this algorithm will find it
				// with either A in the second half of concatedAndconverted or
				// B in the second half of concatedAndconverted.
				tsAvailabe.add(indices[2*n-j]);
			}
			
			System.out.println(best);

		
		
		
		in.close();
	}
	
	static class IndexPair implements Comparable<IndexPair>{
		int originalIndex;
		int suffixArrayIndex;
		public IndexPair(int originalIndex, int suffixArrayIndex) {
			this.originalIndex = originalIndex;
			this.suffixArrayIndex = suffixArrayIndex;
		}
		
		/*
		 	I sort by suffix array index because I only need to consider
		 	 the closest suffix array indices around to find the longest
		 	 possible common prefix.
		 */
		
		@Override
		public int compareTo(IndexPair o) {
			return suffixArrayIndex - o.suffixArrayIndex;
		}
	}
	
	static class SuffixArray {
		//P[k][i] is the position of the 2^k size substring starting at i among the sorted list of 2^k size substrings
		//if two substrings are the same, their P[k][i] will be equal
		//largest k of P is the suffix array of the string
		int[][] P; 
		static int oo = 987654321;
		
		public SuffixArray(int[] array){
			int loglen = 1;
			int pow2 = 1;
			while(pow2 < array.length){
				pow2 <<= 1;
				loglen++;
			}
			
			P = new int[loglen][array.length];
			for (int i = 0; i < array.length; i++) {
				P[0][i] = array[i];
			}
			
			pow2 = 1;
			for(int k =1; k < loglen; k++,pow2<<=1){
				entry[] subs = new entry[array.length];
				
				for(int i =0; i < array.length; i++){
					subs[i] = new entry(P[k-1][i],
					i +pow2 < array.length ? P[k-1][i+pow2] : -oo,
					i);
				}
				Arrays.sort(subs);
				for (int i = 0; i < subs.length; i++) {
					if(i >0 && subs[i-1].compareTo(subs[i]) == 0)
						P[k][subs[i].dex] = P[k][subs[i-1].dex];
					else 
						P[k][subs[i].dex] = i;
				}
				
			}
					
		}
		//LongestCommon prefix of substrings starting from index x and y
		public int lcp(int x, int y) 
		{ 
			int k, ret = 0; 
			if (x == y) 
				return P[0].length - x;
			for (k = P.length-1; k >= 0 && x < P[0].length && y < P[0].length; k--){
				if (P[k][x] == P[k][y]){
					x += (1 << k);
					y += (1 << k);
					ret += 1 << k;
				}
			}
			return ret;
		} 
		
		static class entry implements Comparable<entry>{
			int p1,p2,dex;
			public entry(int one,int two, int index){
				p1 = one;
				p2 = two;
				dex = index;
			}
			
			@Override
			public int compareTo(entry o) {
				if(p1 != o.p1)
					return p1 - o.p1;
				return p2 - o.p2;
			}
			
		}

	}


}
