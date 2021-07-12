package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NYJ_3190_뱀 {
	static int N;
	static int[][] map;
	static int[] di= {0,1,0,-1}; // 2 : start direction
	static int[] dj= {-1,0,1,0};
	static Queue<Point> queue;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		int K = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int aX = Integer.parseInt(st.nextToken());
			int aY = Integer.parseInt(st.nextToken());
			map[aX-1][aY-1]=1;
		}
		
		int L = Integer.parseInt(br.readLine());
		int ans=0;
		queue = new LinkedList<Point>();
		
		int go= 2;
		
		int ci=0; //현재좌표X
		int cj=0; //현재좌표Y
		
		
		
		queue.add(new Point(0,0));
		visit[ci][cj]=true;
		boolean flag=true; //벽에 닿았는지, 자기자신에게 닿았는지 검사하는 변수
		
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			char direction = st.nextToken().charAt(0);
			
			if(!flag)
				break;
			
			while(ans<sec) {
				ci+=di[go];
				cj+=dj[go];
				
				
				
				if(ci<0 || ci>=N || cj<0 || cj>=N) {
					flag=false;
					ans+=1;
					break;
				}
				
				if(visit[ci][cj]) {
					flag=false;
					ans+=1;
					break;
				}
				
				if(map[ci][cj]==1) { //사과발견!
					queue.add(new Point(ci,cj));
					map[ci][cj]=0;
					visit[ci][cj]=true;
				}else { //아무것도 없다. 꼬리 움직이며 이동한다.
					queue.add(new Point(ci,cj));
					visit[ci][cj]=true;
					Point remove =queue.poll();
					visit[remove.x][remove.y]=false;
				}
				
				ans++;
				
			}
			if(ans==sec) {
				if(direction=='L') { //왼
					go = (go+5)%4;
				}
				if(direction=='D') { //오
					go = (go+3)%4;
				}
			}
			
			
		}
		
		if(flag) { //반복문은 끝났는데 더 움직일 수 있는 상황들.
			while(true) {
				ci+=di[go];
				cj+=dj[go];
				if(ci<0 || ci>=N || cj<0 || cj>=N) {
					ans++;
					break;
				}
				if(visit[ci][cj]) {
					ans++;
					break;
				}
				ans++;
			}
		}
		
		System.out.println(ans);
		
	}

static class Point {
	int x, y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}}
