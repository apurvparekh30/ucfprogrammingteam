import java.util.*;
import java.io.*;

class Sample{

	static int n,s1,s2;
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		n = s.nextInt();
		s1 = s.nextInt();
		s2 = s.nextInt();
		int nx = 0,ny=0;
		int ans = (int) 1e9;
		for(int i=0;i<n;i++){
			if(nx > ny){
				ny+=s2;
				ans = ny;
			}
			else if(ny > nx){
				
				nx+=s1;
				ans = nx;
			}
			else{
				if(s1 > s2){
					
					ny+=s2;
					ans = ny;
				}
				else{
					
					nx+=s1;
					ans = nx;
				}
			}
		}
		System.out.println(ans);
	}

}

