class Solution {
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        
        for(int i=0;i<n;i++){
            if(!visit[i]){
                answer++;
                check(computers,visit,i,n);
            }
        }
        return answer;
    }
    
    static void check(int[][] computers, boolean[] visit, int index,int n){
        visit[index]=true;
        
        for(int i=0;i<n;i++){
            if(!visit[i] && computers[index][i]==1){
                check(computers,visit,i,n);
            }
        }
        
        
    }
}