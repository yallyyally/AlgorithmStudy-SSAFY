import java.util.*;

public class 프로그래머스_불량사용자 {

	class Solution {
	    
	    static HashSet<String> res;
	    
	    public int solution(String[] user_id, String[] banned_id) {
	        int answer = 0;
	        res = new HashSet<>();
	        boolean[] visit = new boolean[user_id.length];
	        
	        dfs(user_id, banned_id, 0, visit);
	        answer = res.size();
	        
	        return answer;
	    }
	    
	    public static void dfs(String[] user_id, String[] banned_id, int cnt, boolean[] visit){
	        if(cnt == banned_id.length){
	            String tmp = "";
	            
	            for(int i=0;i<user_id.length;i++)
	                if(visit[i])
	                    tmp += Integer.toString(i);
	            res.add(tmp);
	            return;
	        }
	       
	        for(int i=0;i<user_id.length;i++){
	            if(visit[i]) continue;
	            if(user_id[i].length() != banned_id[cnt].length()) continue;
	            
	            boolean flag = true;
	            for(int j=0;j<user_id[i].length();j++){
	                if(banned_id[cnt].charAt(j) == '*') continue;
	                if(user_id[i].charAt(j) != banned_id[cnt].charAt(j)){
	                    flag = false;
	                    break;
	                }
	            }
	            
	            if(flag){
	                visit[i] = true;
	                dfs(user_id, banned_id, cnt+1, visit);
	                visit[i] = false;
	            }
	        }
	    }
	}
}
