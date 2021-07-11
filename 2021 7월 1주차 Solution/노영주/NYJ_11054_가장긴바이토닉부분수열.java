package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NYJ_11054_가장긴바이토닉부분수열 {
	static int N;
	static int[] arr;
	static int[][] dp;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[2][N]; //[0][idx] : 증가저장, [1][idx] : 감소저장
		
		
		for(int i=0;i<N;i++) {
			Up(i); //dp[0][..]
			Down(i); //dp[1][..]
		}
		
		ans=0;
		
		for(int i=0;i<N;i++) {
			ans = Math.max(dp[0][i]+dp[1][i], ans);
		}
		
		System.out.println(ans-1); //중복부분 제거 
	}
	static int Up(int idx) {
		if(dp[0][idx]==0) { //dp처음 기록
			dp[0][idx]=1; //수열 최소길이 1
			
			for(int i=idx-1;i>=0;i--) {
				if(arr[i]<arr[idx]) { //거꾸로 가며 자신보다 작은것 발견. dp갱신가능.
					dp[0][idx]=Math.max(dp[0][idx], Up(i)+1);
				}
			}
		}
		return dp[0][idx]; //기록된 거 리턴
	}
	static int Down(int idx) {
		if(dp[1][idx]==0) {
			dp[1][idx]=1;
			
			for(int i=idx+1;i<N;i++) {
				if(arr[i]<arr[idx]) { 
					dp[1][idx]=Math.max(dp[1][idx], Down(i)+1);
				}
			}
		}
		return dp[1][idx];
	}
}
