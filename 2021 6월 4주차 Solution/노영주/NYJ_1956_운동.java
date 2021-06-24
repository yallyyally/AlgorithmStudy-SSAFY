package day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 운동 {
	static int V, E;
	static ArrayList<Point> list;
	static int[][] adj;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 마을 개수
		E = Integer.parseInt(st.nextToken()); // 도로 개수

		adj = new int[V][V]; // 인접 행렬

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				adj[i][j] = Integer.MAX_VALUE;
			}
		} // init

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			adj[from - 1][to - 1] = distance;
		} // end input

		for (int k = 0; k < V; k++) {
			for (int i = 0; i < V; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < V; j++) {
					if (j == k || i == j)
						continue;
					if (adj[i][k] == Integer.MAX_VALUE || adj[k][j] == Integer.MAX_VALUE)
						continue; // 경유지를 거쳐 가는 경로가 없음.
					if (adj[i][j] > adj[i][k] + adj[k][j])
						adj[i][j] = adj[i][k] + adj[k][j];
				}
			}
		} // end floyd

		ans = Integer.MAX_VALUE;

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				if (i == j)
					continue;

				if (adj[i][j] == Integer.MAX_VALUE || adj[j][i] == Integer.MAX_VALUE)
					continue;
				
				ans = Math.min(ans, adj[i][j]+adj[j][i]);

			}
		}// 최소의 사이클 찾기
		
		if(ans==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}

	}

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
