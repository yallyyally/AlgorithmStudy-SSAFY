import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] paper;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		paper = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String temp = br.readLine();
			for(int j=0;j<M;j++) {
				paper[i][j]=temp.charAt(j)-'0';
			}
		}
		
		ans=0;
		cut();
		
		System.out.println(ans);
	}
	static void cut() {
		for(int i=0;i<(1<<N*M);i++) {
			int sum=0;
			//2(가로,세로)가지 x (NM)크기
			for(int j=0;j<N;j++) {
				int sumR=0;
				for(int k=0;k<M;k++) {
					//가로
					int current = j*M +k;
					if((i & (1<<current))!=0) {
						sumR = sumR*10 +paper[j][k];
					}else {
						sum+=sumR;
						sumR=0;
					}
				}
				sum+=sumR;
			}
			for(int k=0;k<M;k++) {
				int sumC=0;
				for(int j=0;j<N;j++) {
					int current = j*M+k;
					if((i & (1<<current))==0) {
						sumC = sumC*10+paper[j][k];
					}else {
						sum+=sumC;
						sumC=0;
					}
				}
				sum+=sumC;
			}
			ans = Math.max(ans, sum);
		}
	}
}
