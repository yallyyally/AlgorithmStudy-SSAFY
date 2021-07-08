import java.util.Arrays;
import java.util.Scanner;

public class 백준_11054_가장긴바이토닉부분 {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] nums = new int[N];
		
		for(int i=0;i<N;i++)
			nums[i] = sc.nextInt();
		
		int[] dp_asc = new int[N];
		int[] dp_des = new int[N];
		
		Arrays.fill(dp_asc, 1);
		for(int i=0;i<N;i++)
			for(int j=0;j<i;j++)
				if(nums[j] < nums[i] && dp_asc[j] + 1 > dp_asc[i])
					dp_asc[i] = dp_asc[j] + 1;
		
		Arrays.fill(dp_des, 1);
		for(int i=N-1;i>=0;i--)
			for(int j=N-1;j>i;j--)
				if(nums[j] < nums[i] && dp_des[j] + 1 > dp_des[i])
					dp_des[i] = dp_des[j] + 1;
		
		int ans = 0;
		for(int i=0;i<N;i++)
			if(ans < dp_asc[i] + dp_des[i] - 1)
				ans = dp_asc[i] + dp_des[i] - 1;
		
		System.out.println(ans);

	}

}
