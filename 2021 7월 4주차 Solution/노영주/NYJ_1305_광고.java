package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
//문제설명이 이해가 안가서 오래걸렸다.
//최대한 작은 광고판에 문자열의 반복 패턴을 찾아
//효율적인 광고를 하고 싶은 문제이다.
public class NYJ_1305_광고 {
	static int L;
	static String billboard;
	static int[] pi;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		L = Integer.parseInt(br.readLine());
		billboard = br.readLine();
		
		pi = new int[L];
		
		ans=Integer.MAX_VALUE;
		
		getPi();
		
		System.out.println(L-pi[L-1]);
		
	}
	static void getPi() {
		int j=0;
		for(int i=1;i<L;i++) {
			while(j>0 && billboard.charAt(i)!=billboard.charAt(j)) {
				j = pi[j-1];
			}
			if(billboard.charAt(i)==billboard.charAt(j)) {
				j++;
			}
			pi[i]=j;
		}
	}
}
