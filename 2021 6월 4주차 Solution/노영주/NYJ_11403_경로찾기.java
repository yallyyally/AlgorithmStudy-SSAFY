package day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 경로찾기 {
	static int N;
	static int adj[][];
	static int ans[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		adj = new int[N][N]; 

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end input
		
		for(int k=0;k<N;k++) { //경유지 정점 : K
			for(int i=0;i<N;i++) { //출발 정점 : I
				for(int j=0;j<N;j++) { //도착 정점 : J
//					if(i==k || j==k || i==j) continue; 해당 문제의 경우 자기자신도 갈수있으면 표시.
					if(adj[i][k]!=0 && adj[k][j]!=0) //경로가 존재한다면
						adj[i][j]=1; //갈 수 있다고 표시
					
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(adj[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
	}

}
