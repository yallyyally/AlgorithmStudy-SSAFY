import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int wildcardCnt = 0;
        ArrayList<Integer> confirmed = new ArrayList<Integer>();
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i]!=0){
                confirmed.add(lottos[i]);
            }else{
                wildcardCnt++;
            }
        }
             
        int min = 0;
        int max = 0;
        
        for(int i = 0; i < confirmed.size() ; i++){
            for(int j = 0; j < win_nums.length ; j++){
                if(confirmed.get(i)==win_nums[j]){
                    min++;
                }
            }
        }
        
        max = min + wildcardCnt;
                
        int[] rank = {6,6,5,4,3,2,1};
        answer[0] = rank[max];
        answer[1] = rank[min];
        
        return answer;
    }
}