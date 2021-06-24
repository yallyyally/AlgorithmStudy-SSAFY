package day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 맥주마시걸 {
	static int N;
	static ArrayList<Point> list;
	static int adj[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int t=0;t<TC;t++) {
			
			N = Integer.parseInt(br.readLine());
			adj = new int[N+2][N+2];
			list = new ArrayList<Point>();
			
			StringTokenizer st = null;
			
			for(int i=0;i<N+2;i++) {
				for(int j=0;j<N+2;j++) {
					adj[i][j]=Integer.MAX_VALUE;
				}
			}//init adj
			
			
			for(int i=0;i<N+2;i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}// end input
			
			
			for(int i=0;i<N+2;i++) {
				Point base = list.get(i); //한 곳을 뽑음.
				for(int j=0;j<N+2;j++) {
					if(i==j) // 동일한 곳이라면
						continue;
					
					if(adj[j][i]==1) // 이미 연결된 곳이라면
						continue;
					
					Point item = list.get(j); //그 곳에 대한 다른 곳들.
					
					if(getDistance(base, item)<=1000) { //맥주 50m * 20개 = 1,000m 이내의 거리라면
						adj[i][j]=adj[j][i]=1;
					} 
				}
			}// end adj
			
			
			for(int k=0;k<N+2;k++) { // 경유지
				for(int i=0;i<N+2;i++) { // 출발지
					if(i==k)
						continue;
					for(int j=0;j<N+2;j++) { // 도착지
						if(j==k || i==j) 
							continue;
						
						if(adj[i][j]!=Integer.MAX_VALUE)
							continue;
						
						if(adj[i][k]!=Integer.MAX_VALUE && adj[k][j]!=Integer.MAX_VALUE) {
							// 경유지를 통해 갈 수 있는 곳이라면 연결한다. 
							adj[i][j]=1;
						}
					}
				}
			}// end floyd
			
			if(adj[0][N+1]==Integer.MAX_VALUE) { //adj[집][락페스티벌] : 집 -> 락페스티벌
				System.out.println("sad");
			}else {
				System.out.println("happy");
			}
		}
	}
	
	static int getDistance(Point one, Point two) {
		return Math.abs(one.x-two.x)+Math.abs(one.y-two.y);
	}
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
