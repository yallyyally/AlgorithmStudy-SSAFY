package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NYJ_21610_마법사상어와비바라기 {
	static int N, M;
	static int[][] map;
	static ArrayList<Point> Rain;
	static Queue<Point> Cloud;
	static int[] di = { -1,1,-1,1 }; //4번 대각선 이동 시 사용
	static int[] dj = { -1,1,1,-1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//비바라기 시전
		Cloud = new LinkedList<Point>();
		Cloud.add(new Point(N-1,0));
		Cloud.add(new Point(N-1,1));
		Cloud.add(new Point(N-2,0));
		Cloud.add(new Point(N-2,1));

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()); // 이동방향
			int s = Integer.parseInt(st.nextToken()); // 이동거리
			s%=N; //8번 움직인것은 N이 5일때 결국 3번움직이는 것과 같다. 8%5=3
			letsgo(d,s);
			
		}

		System.out.println(finishMove(map));


	}
	static void letsgo(int d,int s) {
		
		boolean[][] selected = new boolean[N][N]; //구름이 사라진 칸? true -> 예.
		
		//구름이동
		int size = Cloud.size();
		for(int i=0;i<size;i++) {
			Point now = Cloud.poll();
			int movei,movej;
			movei=movej=0;
			
			
			switch (d) {
			case 1: // 왼쪽(0,-1)
				movej=(Math.abs(N-s)+now.j)%N;
				Cloud.add(new Point(now.i,movej));
				break;
			case 2: // 왼쪽 위(-1,-1)
				movei = (Math.abs(N-s)+now.i)%N;
				movej = (Math.abs(N-s)+now.j)%N;
				Cloud.add(new Point(movei,movej));
				break;
			case 3: // 위(-1,0)
				movei = (Math.abs(N-s)+now.i)%N;
				Cloud.add(new Point(movei,now.j));
				break;
			case 4:// 오른쪽 위(-1,1)
				movei =(Math.abs(N-s)+now.i)%N;
				movej = (now.j+s)%N;
				Cloud.add(new Point(movei,movej));
				break;
			case 5: // 오른쪽(0,1)
				movej=(now.j+s)%N;
				Cloud.add(new Point(now.i,movej));
				break;
			case 6: // 오른쪽 아래(1,1)
				movei = (now.i+s)%N;
				movej = (now.j+s)%N;
				Cloud.add(new Point(movei,movej));
				break;
			case 7: // 아래(1,0)
				movei =(now.i+s)%N;
				Cloud.add(new Point(movei,now.j));
				break;
			case 8: //왼쪽 아래(1,-1)
				movei = (now.i+s)%N;
				movej =(Math.abs(N-s)+now.j)%N;
				Cloud.add(new Point(movei,movej));
				break;
			default:
				break;
			}
		}
		
		//바구니 물의 양은 1 증가한다.
		Rain = new ArrayList<Point>();
		size = Cloud.size();
		for(int i=0;i<size;i++) { 
			Point now = Cloud.poll();
			selected[now.i][now.j]=true;
			map[now.i][now.j]++;
			Rain.add(new Point(now.i,now.j));
		}
		
		//물 복사 버그
		size = Rain.size();
		for(int i=0;i<size;i++) {
			Point now =Rain.get(i);
			int sum=0;
			for(int direction=0;direction<4;direction++) {
				int movei = now.i+di[direction];
				int movej = now.j+dj[direction];
				
				if(movei>=0 && movei<N &&movej>=0 && movej<N) { //경계를 벗어나지 않는가?
					if(map[movei][movej]>0) {
						sum+=1;
					}
				}
			}
			map[now.i][now.j]+=sum;
		}
		
		//물 양 2이상 모든 칸에 -2
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>=2) {
					if(!selected[i][j]) { //구름이 사라졌던 칸이 아니라면!
						map[i][j]-=2;
						Cloud.add(new Point(i,j));
					}
				}
			}
		}
		
		
	}

	static int finishMove(int[][] map) { //물의 합
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}

	static class Point {
		int i, j;

		public Point(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}


	}
}
