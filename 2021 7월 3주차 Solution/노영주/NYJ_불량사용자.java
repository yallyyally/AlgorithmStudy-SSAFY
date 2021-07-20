import java.util.*;
class Solution {
    static int banSize;
    static int userSize;
    static boolean[] select;
    static HashSet<String> result;
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        banSize= banned_id.length;
        userSize = user_id.length;
        result = new HashSet<>();
        select = new boolean[userSize];
        
        go(user_id,banned_id,0);
        
        answer = result.size();
        
        return answer;
        
    }
    public boolean isOk(String regex, String temp){
        return temp.matches(regex);
    }
    public void go(String[] user_id, String[] banned_id,int idx){
        if(idx==banSize){
            String temp="";
            
            for(int i=0;i<userSize;i++){
                if(select[i]){
                    temp+=i;
                }
            }
            
            if(!result.contains(temp))
                result.add(temp);
              
              
            return;
        }
        
        for(int i=0;i<userSize;i++){
            if(select[i])
                continue;
            
                String ban = banned_id[idx].replace("*",".");
            
                if(isOk(ban,user_id[i])){
                    select[i]=true;
                    go(user_id, banned_id,idx+1);
                    select[i]=false;
                }                
        }
            
    }
}