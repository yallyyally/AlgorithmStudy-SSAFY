import java.util.*;

public class 백준_1918_후위표기식 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String calc = sc.next();
		String change = ""; // 답
		Stack<Character> oper = new Stack<>();
		
		// 연산자 우선순위
		HashMap<Character, Integer> priority = new HashMap<>();
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
		
		for(int i=0;i<calc.length();i++) {
			char tmp = calc.charAt(i);
			
			if('A' <= tmp && tmp <= 'Z') {
				change += tmp;
			} else {
				if(tmp == '(') {
					oper.push(tmp);
				} else if(tmp == ')') {
					while(!oper.isEmpty() && oper.peek() != '(') {
						change += oper.pop();
					}
					if(!oper.isEmpty() && oper.peek() == '(')
						oper.pop();
				} else {
					while(!oper.isEmpty() && priority.get(oper.peek()) >= priority.get(tmp)) {
						change += oper.pop();
					}
					oper.push(tmp);
				}
			}

		}
		
		while(!oper.isEmpty()) {
			change += oper.pop();
		}
			
		System.out.println(change);
	}

}
