import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] wine = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1;i<=n;i++)
			wine[i] = Integer.parseInt(bf.readLine());
		
		dp[1] = wine[1];
		if(n >= 2)
			dp[2] = dp[1] + wine[2];
		for(int i=3;i<=n;i++) {
			int tmp1 = Integer.MIN_VALUE, tmp2 = Integer.MIN_VALUE, tmp3 = Integer.MIN_VALUE;
			tmp1 = dp[i-1];
			tmp2 = dp[i-2] + wine[i];
			tmp3 = dp[i-3] + wine[i-1] + wine[i];
			dp[i] = Math.max(tmp1, Math.max(tmp2, tmp3));
		}
		
		int max = dp[0];
		for(int i=1;i<=n;i++)
			max = Math.max(max, dp[i]);
		
		System.out.println(max);
	}

}
