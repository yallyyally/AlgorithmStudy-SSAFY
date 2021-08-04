import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R,C,K;
	static int[][] map;
	static List<Array> Sorting;
	static int[] count;
	static int countR,countC;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[100][100];
		int ans=0;
		countR=countC=3;

		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		
		while(!answer()) {
			ans++;
			if(ans>100) {
				ans=-1;
				break;
			}
			
			
			if(countR>=countC) {
				R(countR,countC);
			}else {
				C(countR,countC);
			}
			
		}
		
		
		System.out.println(ans);
		
	}
	static void R(int r, int c) {
		int indexR=0;
		for(int i=0;i<r;i++) {
			Sorting = new ArrayList<Array>();
			count= new int[101];
			for(int j=0;j<c;j++) {
				count[map[i][j]]++;
				map[i][j]=0;
			}
			for(int j=1;j<101;j++) {
				if(count[j]!=0) {
					Sorting.add(new Array(j,count[j]));				
				}
			}
			int size = Sorting.size();
			if(size>1) {
				sort();				
			}
			if(size*2>countC) {
				countC = size*2;				
			}
			
			int indexC=0;
			for(int s=0;s<size;s++) {
				Array current = Sorting.get(s);
				map[indexR][indexC++]=current.num;
				map[indexR][indexC++]=current.times;
			}
			
			indexR++;
			
		}
		

		
	}
	static void C(int r, int c) {
		int indexC=0;
		for(int i=0;i<c;i++) {
			Sorting = new ArrayList<Array>();
			count= new int[101];
			for(int j=0;j<r;j++) {
				count[map[j][i]]++;
				map[j][i]=0;
			}
			for(int j=1;j<101;j++) {
				if(count[j]!=0) {
					Sorting.add(new Array(j,count[j]));				
				}
			}
			int size = Sorting.size();
			if(size>1) {
				sort();				
			}
			if(size*2>countR) {
				countR = size*2;				
			}
			int indexR=0;
			for(int s=0;s<size;s++) {
				Array current = Sorting.get(s);
				map[indexR++][indexC]=current.num;
				map[indexR++][indexC]=current.times;
			}
			
			indexC++;
			
		}
	}
	static void sort() {
		Collections.sort(Sorting, new Comparator<Array>() {

			@Override
			public int compare(Array o1, Array o2) {
				if(o1.times<o2.times)
					return -1;
				else if(o1.times>o2.times)
					return 1;
				else if(o1.num<o2.num)
					return -1;
				else if(o1.num>o2.num)
					return 1;
				else
					return 0;
			}
			
		});
	}
	static boolean answer() {
		if(map[R-1][C-1]==K)
			return true;
		else 
			return false;
	}
	static class Array{
		int num, times;

		public Array(int num, int times) {
			super();
			this.num = num;
			this.times = times;
		}
		
	}
}