import java.util.*;
import java.io.*;

public class 백준_17140_이차원배열과연산 {
	
	static int r, c, k, R, C;
	static int[][] array;
	
	static class Num implements Comparable<Num>{
		int n;
		int cnt = 0;

		public Num(int n, int cnt) {
			super();
			this.n = n;
			this.cnt = cnt;
		}
		
		@Override
		public int compareTo(Num o) {
			if(this.cnt > o.cnt)
				return 1;
			else if(this.cnt == o.cnt) {
				if(this.n >= o.n)
					return 1;
				else
					return -1;
			}else
				return -1;
		}

		@Override
		public String toString() {
			return "Num [n=" + n + ", cnt=" + cnt + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		k = sc.nextInt();
		array = new int[101][101];
		
		for(int i=1;i<=3;i++)
			for(int j=1;j<=3;j++)
				array[i][j] = sc.nextInt();
		time();
	}
	
	public static void time() {
		R = 3; C = 3;
		
		for(int t=0;t<=100;t++) {
			if(array[r][c] == k) {
				System.out.println(t);
				return;
			}
			
			if(R >= C)
				RowOper();
			else
				ColOper();
			
			for(int i=0;i<101;i++) {
				for(int j=0;j<101;j++)
					System.out.print(array[i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println(-1);
		return;
	}
	
	public static void RowOper() {
		int maxR = 0;
		
		for(int i=1;i<=R;i++) {
			Num[] nums = new Num[101];
			
			for(int k=0;k<=100;k++) {
				nums[k] = new Num(k, Integer.MAX_VALUE);
			}
			
			for(int j=1;j<=C;j++) {
				if(array[i][j] == 0) break;
				
				if(nums[array[i][j]].cnt == Integer.MAX_VALUE)
					nums[array[i][j]].cnt = 0;
				nums[array[i][j]].cnt++;
			}
			
			int size = 0;
			Arrays.sort(nums);
			
//			for(Num tmp : nums)
//				System.out.println(tmp.toString());
//			System.out.println();
			
			for(int k=1;k<=100;k++) {
				int key = nums[size].n;
				int value = nums[size++].cnt;
//				System.out.println("key = " + key + " value = " + value + " k = " + k);
				if(value == Integer.MAX_VALUE) break;
				
				array[i][k++] = key;
				if(k == 101) break;
				array[i][k] = value;
			}
//			System.out.println();
			
//			for(int k=1;k<=100;k++)
//				System.out.print(array[i][k] + " ");
//			System.out.println();
//			
			if(size*2 < 101)
				maxR = Math.max(maxR, size*2);
			else
				maxR = 100;
		}
		
		R = Math.max(maxR, R);
	}
	
	public static void ColOper() {
		int maxC = 0;
		
		for(int i=1;i<=R;i++) {
			Num[] nums = new Num[101];
			
			for(int k=0;k<=100;k++) {
				nums[k] = new Num(k, Integer.MAX_VALUE);
			}
			
			for(int j=1;j<=C;j++) {
				if(array[j][i] == 0) break;
				
				if(nums[array[j][i]].cnt == Integer.MAX_VALUE)
					nums[array[j][i]].cnt = 0;
				nums[array[j][i]].cnt++;
			}
			
			int size = 0;
			Arrays.sort(nums);

			for(int k=1;k<=100;k++) {
				int key = nums[size].n;
				int value = nums[size++].cnt;
				if(value == Integer.MAX_VALUE) break;
				
				array[k++][i] = key;
				if(k == 101) break;
				array[k][i] = value;
			}
			
			if(size*2 < 101)
				maxC = Math.max(maxC, size*2);
			else
				maxC = 100;
		}
		
		C = Math.max(C, maxC);
	}

}
