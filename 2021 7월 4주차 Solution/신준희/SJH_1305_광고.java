import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main{
	static int[] pi;
	static int strLen;
	
	public static void makePi(String str) {
		strLen = str.length();
		pi = new int[strLen];
		char[] strToChar = str.toCharArray();
		int j = 0;
		
		for(int i=1; i<strLen; i++) {
			while(j > 0 && strToChar[j] != strToChar[i]) {
				j = pi[j-1];
			}
			if(strToChar[j] == strToChar[i]) {
				pi[i] = ++j;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
//		문자열 최소 -> 전체 문자열 - 반복되는 시작점(접미사)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		String str = br.readLine();
		makePi(str);
		
		System.out.println(N - pi[strLen-1]);
	}
}