package day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//BFS
public class 상근이의여행 {
	static int N, M; // 국가의수 N, 비행기의 종류 M
	static boolean[][] adj; // 인접행렬(비행기)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 0; t < TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			adj = new boolean[N + 1][N + 1]; //1~N포함

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				adj[a][b] = adj[b][a] = true; // 양방향.
			} // end input
			
			System.out.println(bfs()); //나라가 3개라면 최소 2개의 비행기는 타야함, 결국 N-1개.
		}
	}
	static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		boolean[] visit = new boolean[N+1];//섬 방문체크
		visit[1]=true;
		int min=0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i=1;i<=N;i++) {
				if(adj[now][i] && !visit[i]) {
					visit[i]=true;
					queue.add(i);
					min++;
				}
			}
		}
		return min;
	}

}
