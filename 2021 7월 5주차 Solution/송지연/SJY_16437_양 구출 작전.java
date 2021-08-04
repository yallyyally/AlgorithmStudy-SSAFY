import java.util.*;
import java.io.*;

public class 백준_16437_양구출작전 {
	
	static int N;
	static Island[] nums;
	static ArrayList<Integer>[] graph;
	
	static class Island {
		long sheepCnt;
		long wolfCnt;
		
		public Island(long sheepCnt, long wolfCnt) {
			super();
			this.sheepCnt = sheepCnt;
			this.wolfCnt = wolfCnt;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		nums = new Island[N+1];
		graph = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			nums[i] = new Island(0, 0);
			graph[i] = new ArrayList<>();
		}
		
		for(int i=2;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			String animal = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			int node = Integer.parseInt(st.nextToken());
			
			if(animal.equals("S"))
				nums[i].sheepCnt = cnt;
			else
				nums[i].wolfCnt = cnt;

			graph[node].add(i);
		}
		
		dfs(1, 1);
	}

	private static void dfs(int node, int parent) {
		for(int i=0;i < graph[node].size();i++) {
			dfs(graph[node].get(i), node);
		}
		
		if(node == 1) {
			System.out.println(nums[1].sheepCnt);
			return;
		}

		long cnt = nums[node].sheepCnt - nums[parent].wolfCnt;
		if(cnt >= 0) {
			nums[parent].sheepCnt += cnt;
			nums[parent].wolfCnt = 0;
		}else {
			nums[parent].wolfCnt = Math.abs(cnt);
		}
		
		return;
	}

}
