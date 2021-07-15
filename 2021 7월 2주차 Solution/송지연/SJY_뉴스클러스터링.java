import java.io.*;
import java.util.*;

import java.util.*;
	
public class 프로그래머스_뉴스클러스터링 {
	class Solution {
	    public int solution(String str1, String str2) {
	        int answer = 0;

	        ArrayList<String> str1_tmp = word(str1);
	        ArrayList<String> str2_tmp = word(str2);
	        
	        int str1_len = str1_tmp.size();
	        int str2_len = str2_tmp.size();
	        
	        ArrayList<String> remove_str = new ArrayList<>();
	        if(str1_len < str2_len){
	            for(String tmp: str2_tmp){
	                for(String com: str1_tmp){
	                    if(tmp.equals(com)){
	                        remove_str.add(com);
	                        break;
	                    }
	                       
	                }
	            }
	            System.out.println("remove");
	            for(String r: remove_str) {
	            	System.out.print(r + " ");
	            	str1_tmp.remove(r);
	            }
	        }else {
	            for(String tmp: str1_tmp){
	                for(String com: str2_tmp){
	                    if(tmp.equals(com)){
	                        remove_str.add(com);
	                        break;
	                    }   
	                }
	            }
	            
	            System.out.println("remove");
	            for(String r: remove_str) {
	            	System.out.print(r + " ");
	            	str2_tmp.remove(r);
	            }
	        }
	        System.out.println();
	        int union_cnt = str1_tmp.size() + str2_tmp.size();
	        int cnt = str1_len + str2_len - union_cnt;
	        answer = (int)(((double)cnt/(double)union_cnt) * 65536);
	        if(union_cnt == 0) answer = 65536;
	        
	        System.out.println("u = " + union_cnt + " c = " + cnt + " a = " + answer);
	        return answer;
	    }
	    
	    public ArrayList<String> word(String w){
	        ArrayList<String> tmp = new ArrayList<>();
	        
	        for(int i=0;i<w.length()-1;i++){
	            int a = w.charAt(i);
	            int b = w.charAt(i+1);
	            
	            if(((a>=65 && a<=90) || (a>=97 && a<=122)) && ((b>=65 && b<=90)|| (b>=97 && b<=122))){
	                String W = w.substring(i, i+2);
	                tmp.add(W.toLowerCase());
	                System.out.print(W.toLowerCase() + " ");
	            }
	        }
	        System.out.println();
	        return tmp;
	    }
	}
}
