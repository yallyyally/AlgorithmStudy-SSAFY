import java.util.*;
import java.io.*;

public class 백준_16916_부분문자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String origin = bf.readLine();
		String com = bf.readLine();
//		
//		if(origin.contains(com))
//			System.out.println(1);
//		else
//			System.out.println(0);
		
		System.out.println(kmp(origin, com));
	}
	
	public static int kmp(String origin, String com) {
		int[] table = makeTable(com);
		int N1 = origin.length();
		int N2 = com.length();
		
		int idx = 0;
		for(int i=0;i<N1;i++) {
			while(idx > 0 && origin.charAt(i) != com.charAt(idx))
				idx = table[idx-1];
			
			if(origin.charAt(i) == com.charAt(idx)) {
				if(idx == N2 - 1) {
					idx = table[idx];
					return 1;
				}else {
					idx += 1;
				}
			}
		}
		
		return 0;
	}

	private static int[] makeTable(String com) {
		int N = com.length();
		int[] table = new int[N];
		
		int idx = 0;
		for(int i=1;i<N;i++) {
			while(idx > 0 && com.charAt(i) != com.charAt(idx))
				idx = table[idx-1];
			if(com.charAt(i) == com.charAt(idx)) {
				idx += 1;
				table[i] = idx;
			}
		}
		
		return table;
	}

}
