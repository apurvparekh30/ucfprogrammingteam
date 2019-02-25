import java.util.Scanner;
import java.util.Stack;

public class numbers {

	static String out;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for (int i = 0; i < cases; i++) {
			Stack<Integer> john = new Stack<>();
			
			String in = sc.next();
			
			out = "";
			
			for (int j =0; j < in.length(); j++) {
				int cur = in.charAt(j)-'0';


				
				simp(john,cur);
				out += cur;
			}
			
			System.out.println("john while loop starting" + john);
			while (john.size() > 1) {
//	8qe1			System.out.println("john peek"  + john.peek());
				int peek = john.peek();
				if (peek >= 16) {
					peek = 8;
				}
				simp(john,peek);
				out += peek;
			}
			
//			System.out.println("final stack = " + john);
			
			System.out.println(out);
		}
	}
	
	public static void simp(Stack<Integer> john, int cur) {				
//		System.out.println("adding " + cur + " " + john);
		if (john.isEmpty()) {
			john.push(cur);
		}else if (john.peek() > cur) {
			john.push(cur);
		}else if (john.peek() == cur) {
			john.pop();
			cur *= 2;
			simp(john,cur);
		}else if (john.peek() < cur) {
//			System.out.println("less");
			out += john.peek();
			int pop = john.pop();
			pop *= 2;
			simp(john,pop);
			simp(john,cur);
		}
	}

}

/*

3
222
8224
42424

1
8428242
INCORRECT OUTPUT = 84228224224816
*/