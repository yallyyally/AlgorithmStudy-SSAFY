package day0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_3273_두수의합 {
	public static void main(String[] args) throws IOException, NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> numbers = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			numbers.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(numbers);
				
		int x = Integer.parseInt(br.readLine());
		
		//list.get(start) + list.get(end)가 
		//작으면 start index 오른쪽으로 한칸, 크면 end index를 왼쪽으로 한칸, 같으면 end--
		
		int ans = 0;
		int start = 0;
		int end = numbers.size()-1;
		
		while(start<end) {
//			int num1 = numbers.get(start);
//			int num2 = numbers.get(end);
			int sum = numbers.get(start) + numbers.get(end);
			
//			System.out.println(num1 + " " + num2 + " " + sum);
			
			if(sum==x) {
				ans++;
			}
			
			if(sum < x) {
				start++;
			}else if(sum >= x) {
				end--;
			}
		}
		
		System.out.println(ans);
	}
}
