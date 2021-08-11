import java.util.*;

class Solution {

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] cnt = new int[m+1][n+1];
        int[] dx = {0, -1}, dy = {-1, 0};
        
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                cnt[i][j] = 0;
            }
        }

        for(int i=0;i<puddles.length;i++) {
            int x = puddles[i][0], y = puddles[i][1];
            cnt[x][y] = -1;
        }
        
        cnt[1][1] = 1;
        for(int i=1;i<=m;i++) {
            for(int j=1;j<=n;j++) {
                if(cnt[i][j] == -1) continue;
                
                
                for(int d=0;d<2;d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    
                    if(nx < 1 || ny < 1) continue;
                    if(cnt[nx][ny] == -1) continue;
                    cnt[i][j] += (cnt[nx][ny] % 1000000007);
                }
                
            }
        }
        answer = cnt[m][n] % 1000000007;
        return answer;
    }

}