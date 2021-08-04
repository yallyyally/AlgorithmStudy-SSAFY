import java.util.*;
import java.io.*;

public class 백준_14391_종이조각 {
	
	static int N, M, ans;
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String tmp = sc.next();
			map[i] = tmp.toCharArray();
		}
		
		ans = 0;
		boolean[][] visited = new boolean[N][M];
		sum(0, 0, 0, visited, 0);
		System.out.println(ans);
	}
	
	public static void sum(int r, int c, int nowSum, boolean[][] visit, int cnt) {
		System.out.println("r = " + r + " c = " + c + " nowSum = " + nowSum + " cnt = " + cnt);
		if(r == N-1 && c == M-1) {
			System.out.println("nowSum = " + nowSum);
			ans = Math.max(ans, nowSum);
			return;
		}
		
		for(int i=1;i<N;i++) { // 세로
			String tmp = "";
			
			if(r+i < N) {
				boolean flag = true;
				
				for(int j=0;j<=i;j++) {
					if(visit[r+j][c]) {
						flag = false;
						break;
					}
					tmp += map[r+j][c];
					visit[r+j][c] = true;
				}
				
				if(flag) {
					
				}
				System.out.println("세로 tmp = " + tmp);
				sum(r+i, c, nowSum + Integer.parseInt(tmp), visit, cnt+i);
				
				// 방문 해제
				for(int j=0;j<=i;j++) {
					visit[r+j][c] = false;
				}
			}
		}
		
		for(int i=1;i<M;i++) { // 가로
			String tmp = "";
			
			if(c+i < M) {
				for(int j=0;j<=i;j++) {
					tmp += map[r][c+j];
					visit[r][c+j] = true;
				}
				
				System.out.println("가로 tmp = " + tmp);
				sum(r, c+i, nowSum + Integer.parseInt(tmp), visit, cnt+i);
				
				// 방문 해제
				for(int j=0;j<=i;j++) {
					visit[r][c+j] = false;
				}
			}
		}
	}
}
