import java.util.ArrayList;
import java.util.Scanner;

public class 백준_3190_뱀 {
	static int N;
	static int[][] map;
	
	static class Info {
		int time;
		String dir;

		public Info(int time, String dir) {
			super();
			this.time = time;
			this.dir = dir;
		}
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0;i<K;i++) { //사과 입력
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r-1][c-1] = 9;
		}
		
		int L = sc.nextInt();
		ArrayList<Info> info = new ArrayList<>();
		for(int i=0;i<L;i++) {
			int t = sc.nextInt();
			String d = sc.next();
			info.add(new Info(t, d));
		}
		
		int[] dx = {0, -1, 0, 1};
		int[] dy = {-1, 0, 1, 0};
		map[0][0] = 1;
		int preDir = 2, dir = 2, idx = 0, nowTime = 0, x = 0, y = 0, tx = 0, ty = 0;
		
		while(true) {
			
			if(idx < info.size()) {
				Info now = info.get(idx);
				
				if(now.time == nowTime) { // 방향 전환
					preDir = dir;
					if(now.dir == "L") 
						dir -= 1;
					else
						dir += 1;
					if(dir < 0) dir = 3;
					else if(dir > 3) dir = 0;
					idx++;
				}
			}
		
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
			if(map[nx][ny] == 1) break;
			
			if(map[nx][ny] != 9) { // 몸 옮기기
				map[tx][ty] = 0;
				tx += dx[preDir];
				ty += dy[preDir];
			}
			map[nx][ny] = 1;
			x = nx; y = ny;
			nowTime++;
			System.out.println("time = " + nowTime);
			print();
			
		}
		
		System.out.println(nowTime);
	}
	
	
}
