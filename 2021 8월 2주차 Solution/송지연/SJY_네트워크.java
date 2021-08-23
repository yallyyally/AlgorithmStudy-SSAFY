
public class SJY_네트워크 {
	class Solution {

	    boolean[] visit;
	    
	    public int solution(int n, int[][] computers) {
	        visit = new boolean[n];
	        int answer = 0;
	        
	        for(int i=0;i<n;i++) { // n개중 몇 개의 네트워크가 있는지 
	            if(!visit[i]) {
	                dfs(i, computers, n);
	                answer++;
	            }
	        }
	    
	        return answer;
	    }
	    
	    public void dfs(int now, int[][] computers, int n) { 
	        for(int i=0;i<n;i++) { // 자기 자신과 연결된 컴퓨터로 이동
	            if(i == now) continue; // 나는 건너뛰기
	            if(computers[now][i] == 1 && !visit[i]) { // 같은 네트워크로 이동
	                visit[i] = true;
	                dfs(i, computers, n);
	            }
	        }
	        
	        return;
	    }
	}
}
