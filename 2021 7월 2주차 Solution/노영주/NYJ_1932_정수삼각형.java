package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class NYJ_1932_정수삼각형 {
	static int N;
	static int[][] arr;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr= new int[N][N];
		dp= new int[N][N];
		
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j]=dp[i][j]=-1;
			}
		}
		
		for(int i=0;i<N;i++) {
			int j=0;
			StringTokenizer st =  new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				arr[i][j++]=Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = arr[0][0];
		
		for(int i=1;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]!=-1 && dp[i][j]==-1) {
					dp[i][j]=0;
					if(j==0) {
						dp[i][j]=dp[i-1][j]+arr[i][j];
					}else if(j==i) {
						dp[i][j]=dp[i-1][j-1]+arr[i][j];
					}else {
						dp[i][j]=Math.max(dp[i-1][j]+arr[i][j], dp[i-1][j-1]+arr[i][j]);
					}
				}
			}
		}
		
//		for(int [] a:dp) {
//			System.out.println(Arrays.toString(a));
//		}
		
		int ans=0;
		
		for(int j=0;j<N;j++) {
			ans = Math.max(ans, dp[N-1][j]);
		}
		
		System.out.println(ans);
		
	}
}
