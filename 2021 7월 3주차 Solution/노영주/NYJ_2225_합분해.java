package day0627;

import java.util.Scanner;

public class NYJ_2225_합분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long dp[][] = new long[N+1][K+1];
		
		for(int i=0;i<=N;i++) {
			dp[i][1]=1; //1개로 자기자신을 만들 수 있는 건 1가지 뿐. dp[19][1] = 1(19하나).
		}
		//dp[수][개수]=만들수 있는 경우의 수
		for(int i=2;i<=K;i++) {
			for(int j=0;j<=N;j++) {
				for(int k=0;k<=j;k++) {
					//작은 부분 문제는 결국 그 전 경우(개수-1)의
					//0부터 보며 한개씩 추가하는 원리로 경우의 수들을 더해가는 것.
					//dp[2][3]이라면 dp[0][2]+2추가(2개로 0을 만들 수 있는 경우의 수들에 2를 더하면 3개로 2를 만들 수 있는 경우가 된다.)
					//dp[1][2]+1추가, dp[2][2]+0추가도 누적시켜줌.
					dp[j][i]+=dp[j-k][i-1];
					dp[j][i]%=1000000000;
				}
			}
		}
		
		//syso(dp[N][K]%1000000000)안된다...
		//dp[N][K]가 너무너무 커지면 안되서...?
		System.out.println(dp[N][K]);
		
		
	}
}
