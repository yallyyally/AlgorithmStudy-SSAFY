import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int N = citations.length;
        
        Arrays.sort(citations);
        
       for(int i=0;i<N;i++){
          int h = i+1;
           int max=0;
           int j=0;
           while(j<N){     
               if(citations[j]>=h){
                   max=j;
                   break;
               }else{
                   j++;
               }
           }
           if(max==0 && j==N){
               answer=citations[N-1];
               break;
           }
           
           if(i==0 && j==N){
               answer=0;
                break;
           }
           
           if(N-max<h){
               continue;
           }
           else{
               if(answer<h)
                   answer=h;
           }
           
       }
        
        return answer;
    }
}