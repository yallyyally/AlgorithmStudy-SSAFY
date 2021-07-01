import java.util.Scanner;

public class 백준_20040_사이클게임 {
	static int[] uf;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		uf = new int[n];
		
		for(int i=0;i<n;i++)
			uf[i] = i;
		
		boolean cycle = false;
		int ans = 1;
		
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(find(a) == find(b)) {
				cycle = true;
				ans = i+1;
				break;
			}else {
				union(uf[a], uf[b]);
			}
		}
		
		if(cycle)
			System.out.println(ans);
		else
			System.out.println(0);
		
	}

	private static void union(int i, int j) {
		int aa = find(i);
		int bb = find(j);
		if(aa > bb)
			uf[i] = bb;
		else
			uf[j] = aa;
		
	}

	private static int find(int a) {
		if(uf[a] == a)
			return a;
		uf[a] = find(uf[a]);
		return uf[a];
	}
}
