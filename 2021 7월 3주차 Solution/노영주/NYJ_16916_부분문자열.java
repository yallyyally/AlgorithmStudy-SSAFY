package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NYJ_16916_부분문자열 {
		public static String origin,substring;
		public static int pi[];
		public static int originSize,subSize;
		public static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		origin = br.readLine();
		substring = br.readLine();
		
		originSize = origin.length();
		subSize = substring.length();
		
		pi = new int[subSize];
		ans=0;
		
		getPi();
		KMP();
		
		System.out.println(ans);
		
	}
	static void getPi() {
		int j=0;
		for(int i=1;i<subSize;i++) {
			while(j>0 && substring.charAt(j)!=substring.charAt(i)) {
				j = pi[j-1];
			}
			
			if(substring.charAt(i)==substring.charAt(j)) {
				pi[i]= ++j;
			}
		}
	}
	
	static void KMP() {
		int j=0;
		for(int i=0;i<originSize;i++) {
			while(j>0 && origin.charAt(i)!=substring.charAt(j)) {
				j = pi[j-1];
			}
			
			if(origin.charAt(i)==substring.charAt(j)) {
				if(j==subSize-1) {
					ans=1;
					break;
				}else
					++j;
			}
		}
	}
}
