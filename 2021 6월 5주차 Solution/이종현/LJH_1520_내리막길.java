import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1520_내리막길 {
	
	static int M, N;
	static int[][] map;
	static long[][] dp; //경로의 수 (x,y)에서 (m-1,n-1)까지
	static int[] dx = {-1,0,1,0}; // 탐색할 방향  : 상
	static int[] dy = {0,1,0,-1};
	static long result;
	public static void main(String[] args) throws IOException,NumberFormatException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new long[M][N];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("-----------------");
				
		result = dfs(0,0);
		
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dp[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		System.out.println(result);
	}
	private static long dfs(int x, int y) {
		
		if(x==M-1&&y==N-1) {
			return 1;
		}
		
		if(dp[x][y]!=-1) {
			return dp[x][y];
		}
		
		dp[x][y] = 0;
		for (int i = 0; i < dx.length; i++) {
			
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			
			if(nextX<0||nextX>=M||nextY<0||nextY>=N) {
				continue;
			}
			
			if(map[x][y]>map[nextX][nextY]) {
				dp[x][y] += dfs(nextX, nextY);
			}
			
		}
		
		return dp[x][y];
	}
	
	
	
}
