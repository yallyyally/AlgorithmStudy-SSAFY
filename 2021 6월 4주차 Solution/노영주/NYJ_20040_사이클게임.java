package day0617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사이클게임 {
	static int N,M;
	static int p[],rank[];
	static int ans;
	static int stage;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		p = new int[N];
		rank = new int[N];
		ans=0;
		stage=0;
		
		for(int i=0;i<N;i++) {
			p[i]=i;
			rank[i]=1; //트리 높이 저장. 처음엔 다 1.
		}
		
		for(int i=0;i<M;i++) {
			++stage;
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if(!Union(A,B)) {
				ans=stage;
				break;
			}
			
		}
		
		System.out.println(ans);
		
	}
	static boolean Union(int a,int b) {
		a = Find(a);
		b = Find(b);
		
		if(a==b)
			return false;
		
		if(rank[a]<rank[b]) //b 트리의 높이가 더 높다면 root가 된다.
			p[a]=b; //높이가 작은 쪽을 b밑으로 통합.
		else {
			p[b]=a; //b를 a로 통합시킴.
			
			if(rank[a]==rank[b]) {
				//두 트리의 높이가 동일했다면
				//현재 b를 a로 통합시켰으니 a트리의 높이를 1 높여주어야함.
				rank[a]++;
			}
		}
		
		return true;
		
	}
	
	static int Find(int x) {
		if(p[x]==x)
			return x;
		else
			return p[x]=Find(p[x]); //경로 압축.
	}

}
