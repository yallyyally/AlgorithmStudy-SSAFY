import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class boj_21610_마법사상어와비바라기 {
	
	static int N, M;
	static int[][] map;
	static boolean[][] visit;
	static int[][] wind;
	static ArrayList<Cloud> clouds;
	static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
	static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
	
	public static void main(String[] args) throws IOException,NumberFormatException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer  st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		wind = new int[M][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
//		showMap();
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			wind[i][0] = Integer.parseInt(st.nextToken());
			wind[i][1] = Integer.parseInt(st.nextToken());
		}
		clouds = new ArrayList<>();
		clouds.add(new Cloud(N-2, 0));
		clouds.add(new Cloud(N-2, 1));
		clouds.add(new Cloud(N-1, 0));
		clouds.add(new Cloud(N-1, 1));
		
		//초기 상태 구현
//		System.out.println("초기상태");
//		showMap();
//		visit = new boolean[N][N];
//		int d = wind[0][0];
//		int s = wind[0][1];
//		Move(d,s);
//		System.out.println("이동");
//		showMap();
//		Add();
//		System.out.println("물 추가");
//		showMap();
//		System.out.println("물 제거 후 구름 생성");
//		Remove();
//		showMap();
//		System.out.println(Sum());
		
		for (int i = 0; i < M; i++) {
			visit = new boolean[N][N];
			int d = wind[i][0];
			int s = wind[i][1];
			Move(d, s);
			Add();
			Remove();
		}
		System.out.println(Sum());
	}
	
	private static void Move(int d, int s) {
		
		for(Cloud cloud : clouds) {
			
			int nextX = (cloud.x + dx[d] * s %N + N) % N;
			int nextY = (cloud.y + dy[d] * s %N + N) % N;
			
			visit[nextX][nextY] = true;
			map[nextX][nextY] += 1;
			
			cloud.x = nextX;
			cloud.y = nextY;
		}
	}
	
	private static void Add() {
		
		for(Cloud cloud : clouds) {
			
			int cnt = 0;
			int nextX, nextY;
			for (int i = 2; i <=8; i+=2) {
				nextX = cloud.x + dx[i];
				nextY = cloud.y + dy[i];
				
				if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[nextX][nextY] > 0 ) {
					cnt++;
				}
//				map[cloud.x][cloud.y] += cnt; : 실수한 점 여기에서 선언해버려서 
			}
			map[cloud.x][cloud.y] += cnt;
		}
		clouds.removeAll(clouds);
	}

	private static void Remove() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>=2 && !visit[i][j]) {
					map[i][j] -= 2;
					clouds.add(new Cloud(i, j));
				}
			}
		}
	}
	
	private static int Sum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	//구간마다 확인하기 위한 함수
	static void showMap() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.printf("%3d ",map[i][j]);
			}
			System.out.println();
		}
		System.out.println("-----------------");
	}
	
	
	static class Cloud{
		int x, y;
		public Cloud(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
