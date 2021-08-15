import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	static int N;
	static int[][] seat;
	static int[] number;
	static ArrayList<Integer>[] like;
	static int[] di = new int[] { -1, 1, 0, 0 };
	static int[] dj = new int[] { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {

		int x;
		int y;
		int likeAround;
		int empty;

		public int getEmpty(int x, int y) {
			
			int res = 0;
			
			for (int d = 0; d < 4; d++) {
				int ni = x + di[d];
				int nj = y + dj[d];
				if (ni >= 0 && ni < N && nj >= 0 && nj < N && seat[ni][nj] == 0) {
					res++;
				}
			}
			
			return res;
		}

		public Point(int x, int y, int child) {
			this.x = x;
			this.y = y;
//			최애 학생 세기
			this.likeAround = getLikeAround(child, x, y);
//			빈 칸 세기
			this.empty = getEmpty(x,y);
		}

		@Override
		public int compareTo(Point o) {
//			1.최애 많은 순
			if (this.likeAround != o.likeAround)
				return o.likeAround - this.likeAround;
//			2. 빈 칸 많은 순 
			if (this.empty != o.empty)
				return o.empty - this.empty;
//			3. 행 앞번호
			if (this.x != o.x) {
				return this.x - o.x;
			}
//			4. 열 앞번호
			return this.y - o.y;
		}
	}

//	child번째 학생이 x, y 에 앉았을 때 근처 최애 학생의 수
	public static int getLikeAround(int child, int x, int y) {
		
		int res = 0;
		
		for (int d = 0; d < 4; d++) {
			int ni = x + di[d];
			int nj = y + dj[d];
			if (ni >= 0 && ni < N && nj >= 0 && nj < N && like[child].contains(seat[ni][nj])) {
				res++;
			}
		}
		
		return res;
	}
	
	static PriorityQueue<Point> candidate;
	static int totalChild;

//	cur번 학생의 자리 찾아주기
	public static Point findSeat(int cur) {
 		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
//				이미 있는 자리 빼고
				if(seat[i][j] != 0)
					continue;
				candidate.add(new Point(i, j, cur));
			}
		}
		return candidate.peek();
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		totalChild = N * N;
		seat = new int[N][N]; // 행,열은 0 ~ N-1
		like = new ArrayList[totalChild + 1] ;// 번호는 1 ~ N
		number = new int[totalChild];
		
		for (int i = 1; i <= totalChild; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int child = Integer.parseInt(st.nextToken());
			number[i-1] = child;
			like[child] = new ArrayList<>();
			for (int j = 0; j < 4; j++) {
				like[child].add(Integer.parseInt(st.nextToken()));
			}
		}

//		모두 자리 찾아주기
		for (int i = 0; i < totalChild; i++) {
			candidate = new PriorityQueue<>();
			Point result = findSeat(number[i]);
			seat[result.x][result.y] = number[i];
		}
		int res = 0;
		
//		만족도 계산하기
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
//				System.out.println("학생 "+seat[i][j]);
				int likeAround = getLikeAround(seat[i][j], i, j);
				switch(likeAround) {
					case 2 : res += 10; break;
					case 3 : res += 100; break;
					case 4 : res += 1000; break;
					default : res += likeAround;
				}
			}
		}
		System.out.println(res);
	}
}