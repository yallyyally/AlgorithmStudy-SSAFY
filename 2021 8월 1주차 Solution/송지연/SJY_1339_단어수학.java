import java.util.*;
import java.io.*;

public class 백준_1339_단어수학 {
	
	static int N, alpCnt;
	static HashMap<Character, Integer> map;
	static boolean[] visit;
	static int[] num;
	static String[] word;
	static Long ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		map = new HashMap<>();
		word = new String[N];	
		
		for(int i=0;i<N;i++) {
			word[i] = bf.readLine(); // 문자 입력 받기

			for(int j=0;j<word[i].length();j++) {
				if(map.containsKey(word[i].charAt(j))) continue; // 해당 알파벳 키 있으면 넘어가고
				
				map.put(word[i].charAt(j), 0); // 아니면 초기화
			}
		}
		
		alpCnt = map.size(); // 알파벳 갯수는 map 사이즈임
		visit = new boolean[11];
		num = new int[alpCnt];
		ans = 0L;
		perm(0); // 숫자 순서 정하기
		
		System.out.println(ans);
	}
	
	public static void perm(int cnt) {
		if(cnt == alpCnt) {
			changeValue();
			sumWord();
			return;
		}
		
		for(int i=9;i>(9-alpCnt);i--) { // 순서 순열로
			if(visit[i]) continue;
			
			visit[i] = true;
			num[cnt] = i;
			perm(cnt + 1);
			visit[i] = false;
		}
	}

	private static void sumWord() {
		Long sum = 0L;
		
		for(String w : word) {
			String tmp = ""; // 해당 문자의 값
			
			for(int j=0;j<w.length();j++) {
				int n = map.get(w.charAt(j)); // 하나씩 값 가져와서 이어붙이기
				tmp += Integer.toString(n);
			}
			
			sum += Long.parseLong(tmp); // 단어 값 더하기
		}
		
		ans = Math.max(ans, sum); // 현재 최대값이랑 비교
	}

	private static void changeValue() {
		int i = 0;
		for(Character key : map.keySet()) { // map에서 키 하나씩 꺼내면서 값 바꾸기
			map.replace(key, num[i++]);	
		}
	}
}
