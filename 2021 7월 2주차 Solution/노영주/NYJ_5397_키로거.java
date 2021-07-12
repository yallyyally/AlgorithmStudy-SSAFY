package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class NYJ_5397_키로거 {
	static StringBuilder sb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		sb = new StringBuilder();
		for (int t = 0; t < TC; t++) {
			char[] line = br.readLine().toCharArray();
			Deque<Character> one = new ArrayDeque<Character>();
			Deque<Character> two = new ArrayDeque<Character>();

			for (int i = 0; i < line.length; i++) {
				if (line[i] == '<') {
					if (one.isEmpty())
						continue;

					two.addFirst(one.removeLast());

				} else if (line[i] == '>') {
					
					if(two.isEmpty())
						continue;
					
					one.addLast(two.removeFirst());

				} else if (line[i] == '-') {

					if(one.isEmpty())
						continue;
					
					one.removeLast();
					
				} else {
					one.addLast(line[i]);
				}
			}//end logic
			
			while(!two.isEmpty()) {
				one.addLast(two.removeFirst());
			}
			
			while(!one.isEmpty()) {
				sb.append(one.removeFirst());
			}
			
			sb.append("\n");

		}
		
		System.out.println(sb.toString());
	}
}
