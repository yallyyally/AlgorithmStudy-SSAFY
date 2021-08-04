import java.util.*;

public class 프로그래머스_수식최대화 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		System.out.println(s.solution("100-200*300-500+20"));
	}

	static class Solution {
	    int[][] rank = {{0, 1, 2},
	                           {0, 2, 1},
	                           {1, 0, 2},
	                           {1, 2, 0},
	                           {2, 0, 1},
	                           {2, 1, 0}};
	    
	    HashMap<String, Integer> op;
	    
	    public long solution(String expression) {
	        long answer = 0;
	    
	        String[] nums = expression.split("[^0-9]");
	        String[] operation = expression.split("[0-9]+");
	        op = new HashMap<>();
	        op.put("+", 0);
	        op.put("-", 1);
	        op.put("*", 2);
	        
	        ArrayList<Long> number = new ArrayList<>();
	         for(String n: nums){
	             number.add(Long.parseLong(n));
	         }
	        
//	         for(String o: operation) {
//	        	 System.out.print(o);
//	         }
	        for(int i=0;i<6;i++){
	            ArrayList<Long> num = number;
	            ArrayList<String> oper = new ArrayList<>(Arrays.asList(operation));
	            oper.remove(0);
	            
	            for(int j=0;j<3;j++){
	            	int size = oper.size();
	                for(int k=0;k<size;k++){
	        
	                    if(rank[i][j] == op.get(oper.get(k))){
	                       Long tmp1 = num.get(k), tmp2 = num.get(k+1);
	                       
	                        if(rank[i][j] == 0)
	                            num.set(k, tmp1+tmp2);
	                        else if(rank[i][j] == 1)
	                        	num.set(k, tmp1-tmp2);
	                        else
	                        	num.set(k, tmp1*tmp2);
	                        num.remove(k+1);
	                        oper.remove(k);
	                    }
	                }
	            }
	            
	            answer = Math.max(answer, Math.abs(num.get(0)));
	        }
	        
	        
	        return answer;
	    }
	}
}
