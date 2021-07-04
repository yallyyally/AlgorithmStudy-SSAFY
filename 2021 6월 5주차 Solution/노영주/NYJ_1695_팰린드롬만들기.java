package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NYJ_1695_팰린드롬만들기 {
	static int N;
	static int[] num;
	static int[][] dp;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N]; //수열의 수
		dp = new int[N][N]; //최솟값 저장, dp[1][3] = 수열의 수 인덱스 1부터 3까지 펠린드롬 최소삽입수.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i]= Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				dp[i][j]=-1; //-1로 초기화. 최솟값이 0인 경우와의 비교를 위함.
			}
		}
		
	
		ans=0;
		
		for(int i=N-1;i>=0;i--) {
			for(int j=0;j<N;j++) {
				palindrome(i,j);
			}
		}
		
		System.out.println(dp[0][N-1]); //0인덱스부터 N-1인덱스까지의 팰린드롬 최소 삽입수.
	}
	static int palindrome(int i,int j) {
		if(dp[i][j]!=-1) return dp[i][j]; //이미 팰린드롬 최소 수를 알고 있다.
		if(i>=j) { //만약 dp[4][0](성립되지 않음)이나 dp[4][4](자기자신과의비교: 무조건 팰린드롬.)는 0으로 해준다.
			dp[i][j]=0; //검사하긴 했으므로 -1을 0으로 바꿔주어야 한다.
			return dp[i][j];
		}
		
		if(num[i]==num[j]) {
			// 2 3 4 2 이고, i는 0 j는 3이라면 2==2. 3 4 를 검사해야하므로
			// i는 인덱스 한칸 뒤로, j는 인덱스 한칸 앞으로 가서 팰린드롬 최소 수 재검사.
			dp[i][j] = palindrome(i+1,j-1);
		}else {
			//2 3 4 2 이고, i는 1 j는 2라면 3!=4. 
			//앞에 수를 삽입할지, 뒤에 수를 삽입할지 최소수를 골라야한다.
			dp[i][j]=Math.min(palindrome(i+1,j), palindrome(i,j-1))+1; //현재 숫자가 다르므로 삽입 숫자는 무조건 하나 늘려야 한다. 
		}
		return dp[i][j];
	}
}
