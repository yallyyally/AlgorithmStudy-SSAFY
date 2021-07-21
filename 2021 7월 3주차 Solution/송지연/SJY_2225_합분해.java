import java.util.*;
import java.io.*;

public class 백준_2225_합분해 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] dp = new int[201][201];
		for(int i=1;i<=k;i++)
			dp[i][0] = 1;
		
		for(int i=1;i<=k;i++) {
			for(int j=1;j<=n;j++)
				dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % 1000000000;
		}
		
		System.out.println(dp[k][n]);
	}
}
