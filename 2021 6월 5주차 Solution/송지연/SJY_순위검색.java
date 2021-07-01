import java.util.*;

public class 프로그래머스_순위검색 {

	class Solution {
		HashMap<String, Integer> dict = new HashMap<String, Integer>();;
		HashMap<String, List<Integer>> info_arr = new HashMap<String, List<Integer>>();;
		
	    public int[] solution(String[] info, String[] query) {
	        int[] answer = {};
	      
	        dict.put("cpp", 0); dict.put("java", 1); dict.put("python", 2);
	        dict.put("backend", 0); dict.put("frontend", 1);
	        dict.put("junior", 0); dict.put("senior", 1);
	        dict.put("chicken", 0); dict.put("pizza", 1); dict.put("-", 3);
	        
	        for(String i: info) {
	        	String[] tmp = i.split(" ");
	        	String tmp_str = Integer.toString(dict.get(tmp[0])) + Integer.toString(dict.get(tmp[1]))
	        					+ Integer.toString(dict.get(tmp[2])) + Integer.toString(dict.get(tmp[3]));
	        	powerSet(0, tmp_str, "", Integer.parseInt(tmp[4]));
	        }
	        
	        Iterator<String> it= info_arr.keySet().iterator();
	        while(it.hasNext()) {
	        	String key = it.next();
	        	List<Integer> li = info_arr.get(key);
	        	Collections.sort(li);
	        }
	        
	        int n = 0;
	        for(String s: query) {
	        	s = s.replace("and", "");
	        	String[] tmp = s.split(" ");
	        	String tmp_str = Integer.toString(dict.get(tmp[0])) + Integer.toString(dict.get(tmp[1]))
	        					+ Integer.toString(dict.get(tmp[2])) + Integer.toString(dict.get(tmp[3]));
	        	
	        	int cnt = 0;
	        	int min_score = Integer.parseInt(tmp[4]);
	        	
	        	if(info_arr.containsKey(tmp_str)) {
	        		List<Integer> list = info_arr.get(tmp_str);
	        		int start = 0, end = list.size() - 1;
	        		
	        		while(start<=end) {
	        			int mid = (start + end) / 2;
	        			if(list.get(mid) < min_score)
	        				start = mid + 1;
	        			else
	        				end = mid - 1;
	        		}
	        		
	        		cnt = list.size() - start;
	        	}
	        	
	        	answer[n++] = cnt;
	        }
	        
	        return answer;
	    }

		private void powerSet(int target, String origin, String new_origin, int value) {
			if(target == 4) {
				if(!info_arr.containsKey(new_origin)) {
					List<Integer> list = new ArrayList<>();
					list.add(value);
					info_arr.put(new_origin, list);
				}else {
					info_arr.get(new_origin).add(value);
				}
				return;
			}
			
			String tmp = new_origin;
			new_origin += "3";
			powerSet(target+1, origin, new_origin, value);
			
			tmp += origin.charAt(target);
			powerSet(target+1, origin, new_origin, value);
		}
	}
}
