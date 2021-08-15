import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	static int N;
	static int[][] dp;
	static int[] W;
	static ArrayList<Integer>[] tree;
	static boolean[] visited;
	
	public static void dfs(int cur) {
		
		if(visited[cur])
			return;
		
		visited[cur] = true;
		dp[cur][0] = 0; //우수마을이 아닐 땐 일단 0
		dp[cur][1] = W[cur];
		
		ArrayList<Integer> children = tree[cur];
		
		for(int child : children) {
//			방문햇으면 패쓰
			if(visited[child])
				continue;
			
//			타고 드감
			dfs(child);
			
//			우수마을 아님 -> 옆에 우수든가 말든가 더 큰거
			dp[cur][0]  = dp[cur][0] + Math.max(dp[child][0], dp[child][1]);
//			우수마을임 -> 이웃한 마을은 우수 X
			dp[cur][1] += dp[child][0];
		}
	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		W = new int[N+1];
		dp = new int[N+1][2];
		visited = new boolean[N+1];
		tree = new ArrayList[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			W[i] = Integer.parseInt(st.nextToken());
			tree[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<N-1; i++) { 
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree[a].add(b);
			tree[b].add(a);
		}
//		루트는 1번
		dfs(1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		
	}
}