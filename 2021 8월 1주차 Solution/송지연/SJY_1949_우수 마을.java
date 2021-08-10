import java.util.*;
import java.io.*;

public class 백준_1949_우수마을 {
	
	static int N;
	static int[][] dp;
	static boolean[] visit;
	static ArrayList<Integer>[] tree;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		dp = new int[N+1][2]; // 0은 그냥 마을, 1은 우수 마을
		visit = new boolean[N+1];
		tree = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++)
			dp[i][1] = Integer.parseInt(st.nextToken()); // 우수 마을일 때 값에 인원수 넣어주기
		
		for(int i=1;i<=N;i++)
			tree[i] = new ArrayList<>(); // 트리 초기화
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(bf.readLine());
			int A = Integer.parseInt(st.nextToken()); // A 마을
			int B = Integer.parseInt(st.nextToken()); // B 마을
			
			tree[A].add(B); // 양방향이니깐
			tree[B].add(A);
		}
			
		dfs(1);
		System.out.println(Math.max(dp[1][0], dp[1][1]));
	}
	
	public static void dfs(int nowNode) {
		if(visit[nowNode]) return; // 방문했으면 재귀 ㄴㄴ
		
		visit[nowNode] = true; // 방문 처리
		for(int i=0;i<tree[nowNode].size();i++) {
			int nextNode = tree[nowNode].get(i); // 다음 노드
			
			if(visit[nextNode]) continue; // 방문했으면 안가기
			dfs(nextNode); // 리프노드까지 가기
			
			dp[nowNode][0] += Math.max(dp[nextNode][0], dp[nextNode][1]); // 그냥 마을이면 우수랑 그냥 마을 비교해서 큰 값 넣기
			dp[nowNode][1] += dp[nextNode][0]; // 다음 노드가 우수 마을이면 현재 그냥 마을 값 더해주기(인접x니깐)
		}
	}
}
