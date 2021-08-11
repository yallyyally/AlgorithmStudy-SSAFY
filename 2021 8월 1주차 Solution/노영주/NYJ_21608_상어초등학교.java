import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static ArrayList<ArrayList<Integer>> classroom;
	static int[][] map;
	static int di[] = {-1,0,1,0};
	static int dj[] = {0,-1,0,1};
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		classroom = new ArrayList<ArrayList<Integer>>();
		map = new int[N][N];
		
		for(int i=0;i<N*N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> temp= new ArrayList<Integer>();
			for(int j=0;j<5;j++) {
				temp.add(Integer.parseInt(st.nextToken()));
			}
			classroom.add(temp);
		}
		
		for(int s=0;s<N*N;s++) {
			ArrayList<Integer> current = classroom.get(s);
			int [] people = new int[N*N+1];
			int student = current.get(0);
//			boolean flag=false;
			people[current.get(1)]++;
			people[current.get(2)]++;
			people[current.get(3)]++;
			people[current.get(4)]++;
			int minI=Integer.MAX_VALUE,minJ=Integer.MAX_VALUE; //주의...초기값을 0으로 했었다...
			int maxLove=0,maxEmpty=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]!=0)
						continue;
					int loveCount=0;
					int emptyCount=0;
					for(int d=0;d<4;d++) {
						int mi = i+di[d];
						int mj = j+dj[d];
						if(mi<0 || mi>=N || mj<0 || mj>=N)
							continue;
						if(map[mi][mj]==0)
							emptyCount++;
						else {
							if(people[map[mi][mj]]>=1) {
								loveCount++;
							}
						}
					}
					
//					if(loveCount==4) {
//						map[i][j]=student;
//						flag=true;
//					}
//					
//					if(flag)
//						break;
					
					if(maxLove<loveCount) {
						maxLove=loveCount;
						minI=i;
						minJ=j;
						maxEmpty =emptyCount;
						continue;
					}
					
					if(maxLove == loveCount) {
						if(maxEmpty<emptyCount){
							maxEmpty = emptyCount;
								minI=i;
								minJ=j;								
							continue;
						}
						
						if(maxEmpty==emptyCount) {
							if(minI>i ||(minI==i && minJ>j)) {
								minI=i;
								minJ=j;
							}
						}
					}
					
				}
//				if(flag)
//					break;
			}
//			if(flag)
//				continue;
			map[minI][minJ]=student;
		}
		
		
		ans=0;
		loveSum();
		System.out.println(ans);
		
	}
	static void loveSum() {
		for(int s=0;s<N*N;s++) {
			int count=0;
			ArrayList<Integer> current = classroom.get(s);
			int [] people = new int[N*N+1];
			int student = current.get(0);
			people[current.get(1)]++;
			people[current.get(2)]++;
			people[current.get(3)]++;
			people[current.get(4)]++;
			
			boolean check = false;
			
			for(int i=0;i<N;i++) {
				if(check)
					continue;
				for(int j=0;j<N;j++) {
					
					if(map[i][j]!=student)
						continue;
					
					for(int d=0;d<4;d++) {
						int mi = i+di[d];
						int mj = j+dj[d];
						if(mi<0 || mi>=N || mj<0 || mj>=N)
							continue;
						
						if(people[map[mi][mj]]>=1)
							count++;
					}
					
					switch (count) {
					case 0:
						break;
					case 1:
						ans+=1;
						break;
					case 2:
						ans+=10;
						break;
					case 3:
						ans+=100;
						break;
					case 4:
						ans+=1000;
						break;
					}
					
					check=true;
				}
			}
		}
	}

}