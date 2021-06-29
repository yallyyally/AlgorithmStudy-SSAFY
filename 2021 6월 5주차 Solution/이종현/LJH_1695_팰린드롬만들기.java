import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1695_팰린드롬만들기 {
	
	static int N;
	static int[] arr;
	static int[][] dp;
	
	
	public static void main(String[] args) throws IOException,NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				dp[i][j] = -1;
			}
		}
		
		
		int result = dfs(0,N-1);
		
		System.out.println(result);
	}


	private static int dfs(int start, int end) {
		//기저조건
		if(start >= end) {
			return 0;
		}
		
		//방문한적있으면
		if(dp[start][end]!=-1) {
			return dp[start][end];
		}
		//방문한적없으면
		//앞 뒤가 같으면
		if(arr[start] == arr[end]) {
			dp[start][end] = dfs(start+1,end-1);
		}
		//앞뒤가 다르면
		else {
			dp[start][end] = Math.min(1+dfs(start+1,end), 1+dfs(start,end-1));
		}
//		System.out.println(start + " " + end + " " + dp[start][end]);
		
		return dp[start][end];
	}
	

}
