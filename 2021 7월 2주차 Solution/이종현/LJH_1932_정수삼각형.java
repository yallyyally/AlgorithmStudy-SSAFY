import java.io.*;
import java.util.*;

public class boj_1932_정수삼각형 {

    static int[][] arr;
    static int[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new int[n][n];

        // System.out.println(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(arr[i][j] + " ");
        // }
        // System.out.println();
        // }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        int result = dfs(0, 0);

        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(dp[i][j] + " ");
        // }
        // System.out.println();
        // }

        System.out.println(result);
    }

    static int dfs(int height, int idx) {
        if (height == n - 1) {
            return dp[height][idx];
        }

        if (dp[height][idx] == -1) {
            dp[height][idx] = Math.max(dfs(height + 1, idx), dfs(height + 1, idx + 1)) + arr[height][idx];
        }

        return dp[height][idx];
    }

}
