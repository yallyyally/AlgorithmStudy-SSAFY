import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 백준_21610_마법사상어와비바라기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] dx = {0, 0, -1, -1, -1, 0, 1, 1, 1};
		int[] dy = {0, -1, -1, 0, 1, 1, 1, 0, -1};

		int[][] map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0;j<N;j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {N-1, 0});
		q.add(new int[] {N-1, 1});
		q.add(new int[] {N-2, 0});
		q.add(new int[] {N-2, 1});
		
		while(M-->0) {
			st = new StringTokenizer(bf.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				int[] point = q.poll();
				int newX = (N + (point[0] + dx[d] * s) % N) % N;
				int newY = (N + (point[1] + dy[d] * s) % N) % N;
				point[0] = newX; point[1] = newY;
				q.add(point);
			}

			boolean[][] visit = new boolean[N][N];
			
			for(int i=0;i<size;i++) {
				int[] point = q.poll();
				visit[point[0]][point[1]] = true;
				map[point[0]][point[1]]++;
				q.add(point);
			}

			for(int i=0;i<size;i++) {
				int[] point = q.poll();
				int cnt = 0;
				
				for(int j=2;j<9;j=j+2) {
					int newX = point[0] + dx[j];
					int newY = point[1] + dy[j];
					
					if(newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
					if(map[newX][newY] > 0) cnt++;
				}
				
				map[point[0]][point[1]] += cnt;
			}

			for(int i=0;i<N;i++)
				for(int j=0;j<N;j++) {
					if(!visit[i][j] && map[i][j] >= 2) {
						q.add(new int[] {i, j});
						map[i][j] -= 2;
					}
				}
		}
		
		int ans = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<N;j++)
				ans += map[i][j];
		
		System.out.println(ans);
	}

}
