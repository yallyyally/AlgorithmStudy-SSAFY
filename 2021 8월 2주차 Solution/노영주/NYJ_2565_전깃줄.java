import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Line> list = new ArrayList<Line>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list.add(new Line(A,B));
		}// end input
		
		Collections.sort(list, new Comparator<Line>() {

			public int compare(Line o1, Line o2) {
				if(o1.a < o2.a){
					return -1; 
				}else {
					return 1;
				}
			}
			
		});
		
		int[] sortB = new int[N];
		int[] dp = new int[N]; //최장 문자열 길이 저장
		dp[0] = 1; //최소길이 
		for(int i=0;i<N;i++) {
			Line current = list.get(i);
			sortB[i]=current.b;
		}
		
		int max = 0;
		
		for(int i=1;i<N;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(sortB[i]>sortB[j] && dp[j]+1 > dp[i]) {
					dp[i] = dp[j]+1;
				}
			}
			
			if(max<dp[i])
				max=dp[i];
		}
		
		
		System.out.println(N-max);
		
		
	}
	static class Line{
		int a,b;

		public Line(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
	}
}