import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 백준_2565_전깃줄 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int originLineCnt = sc.nextInt();
		int[][] line = new int[originLineCnt][2];
		
		for(int i=0;i<originLineCnt;i++) {
			line[i][0] = sc.nextInt();
			line[i][1] = sc.nextInt();
		}
		
		Arrays.sort(line, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
			
		});
		int[] dp = new int[originLineCnt]; // 전깃줄 설치 가능 갯수
		
		for(int i=0;i<originLineCnt;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(line[i][1] > line[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		Arrays.sort(dp);
		System.out.println(originLineCnt - dp[originLineCnt - 1]);
	}

}
