import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 백준_5397_키로거 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(bf.readLine());
		
		while(TC-->0) {
			String str = bf.readLine();
			Stack<Character> stack = new Stack<>();
			Stack<Character> stack1 = new Stack<>();
			
			for(int i=0;i<str.length();i++) {
				char now = str.charAt(i);
				
				if(now == '<') {
					if(stack.size() == 0) continue;
					char tmp = stack.pop();
					stack1.add(tmp);
				}else if(now == '>') {
					if(stack1.size() == 0) continue;
					char tmp = stack1.pop();
					stack.add(tmp);
				}else if(now == '-') {
					if(stack.size() == 0) continue;
					stack.pop();
				}else {
					stack.add(now);
				}
			}
			
			StringBuilder sb = new StringBuilder();
			while(!stack.isEmpty())
				sb.append(stack.pop());
			sb.reverse();
	
			while(!stack1.isEmpty())
				sb.append(stack1.pop());
			
			System.out.println(sb.toString());
		}
		
	}

}
