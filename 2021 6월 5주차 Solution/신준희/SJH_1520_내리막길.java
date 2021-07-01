import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {
	static int[][] map;

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object p) {
			Point pp = (Point) p;
			if (pp.x == this.x && pp.y == this.y)
				return true;
			else
				return false;
		}
	}

	static HashSet<Point> success; // 성공한 경로 저장
	static LinkedList<Point> road; // 현재까지 경로 저장
	static int res;
	static int M, N;
	static int[] di, dj;

	public static void dfs(int x, int y) {
//		현재 경로 저장
		road.offer(new Point(x, y));

//		도착점일 경우
		if (x == M - 1 && y == N - 1) {
			res++;

			for (Point p : road) {
				success.add(p);
			}
		} else {

//		사방탐색
			int ni, nj;
			Point p;
			for (int d = 0; d < 4; d++) {
				ni = x + di[d];
				nj = y + dj[d];
//			갈 수 있는 곳
				if (ni >= 0 && ni < M && nj >= 0 && nj < N && map[ni][nj] < map[x][y]) {
					p = new Point(ni, nj);
					if (!success.contains(p)) {
						dfs(ni, nj);
					} else {
						res++;
						success.add(new Point(x, y));
					}
				}
			}

		}
//		현재 길에서 후퇴
		road.pollLast();
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		success = new HashSet<>();
		road = new LinkedList<>();
		di = new int[] { -1, 1, 0, 0 };
		dj = new int[] { 0, 0, -1, 1 };
		dfs(0, 0);
		System.out.println(res);
	}
}