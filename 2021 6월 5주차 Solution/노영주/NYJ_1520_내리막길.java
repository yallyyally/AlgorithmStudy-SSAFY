package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NYJ_1520_내리막길 {
	static int M, N;
	static int[][] map;
	static int[][] dp;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1; //들어갔던 곳과 안들어간 곳 모두 0이라면 구별이 안된다.
			}
		} // end input

		System.out.println(go(0,0));
	}

	static int go(int i, int j) {

		dp[i][j] = 0; //들어왔다.

		for (int d = 0; d < 4; d++) {
			int mi = i + di[d];
			int mj = j + dj[d];

			if (mi < 0 || mi >= M || mj < 0 || mj >= N)
				continue;

			if (map[i][j] > map[mi][mj]) { //내리막길만 이동가능

				if (mi == M - 1 && mj == N - 1) {
					// 경로 발견
					dp[i][j] += 1; // 현재 좌표에 경로 수 +1
				}

				if (dp[mi][mj] < 0) { //내리막길인데 가본적 없는 곳 (-1)
					dp[i][j]+=go(mi, mj); //가본다. 리턴값을 현재 좌표에 적용.
				} else { //내리막길인데 가본적 있는 곳을 마주치면 이미 경로가 dp에 써져있음.
					dp[i][j] += dp[mi][mj]; //현재 좌표 경로수에 이미 경로가 적혀진 가본곳 경로를 적용시킴.
				}
			}
		}
		return dp[i][j];
	}
}
