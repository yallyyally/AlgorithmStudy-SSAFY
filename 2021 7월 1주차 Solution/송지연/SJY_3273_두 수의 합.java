import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_3273_두수의합 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0;i<n;i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		int x = Integer.parseInt(bf.readLine());
		
		Arrays.sort(nums);
		int start = 0, end = n-1, cnt = 0;
		while(start < end) {
			int tmp = nums[start] + nums[end];
			
			if(tmp == x) {
				cnt++;
				start++;
				end--;
			}else if(tmp > x){
				end--;
			}else {
				start++;
			}
		}
		
		System.out.println(cnt);
	}

}
