import java.util.*;


class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        String str3 = str1.toLowerCase();
        String str4 = str2.toLowerCase();
        
        // HashSet<String> set1 = new HashSet<String>();
        // HashSet<String> set2 = new HashSet<String>();
        
        //틀린 이유 set을 썼음 => 중복허용이네 하....... 문제 꼼꼼히 읽기
        
        ArrayList<String> set1 = new ArrayList<>();
        ArrayList<String> set2 = new ArrayList<>();
        
        
        int a = 'Z';
        int b = 0;
        char c = 'A';        
        char d = 'a';
        //a = 97, z = 122, A=65 Z=90
        String str = "";
        
        for(int i = 0;  i < str3.length()-1; i++){
            a = str3.charAt(i);
            b = str3.charAt(i+1);
            c = (char)a;
            d = (char)b;

            if((a >= 97 && a <= 122 && b >= 97 && b <= 122)){
                str = String.valueOf(c) + String.valueOf(d);
                set1.add(str);
            }
        }
        
        for(int i = 0;  i < str4.length()-1; i++){
            a = str4.charAt(i);
            b = str4.charAt(i+1);
            c = (char)a;
            d = (char)b;

            if(a >= 97 && a <= 122 && b >= 97 && b <= 122){
                str = String.valueOf(c) + String.valueOf(d);
                set2.add(str);
            }
        }
        
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> intersection = new ArrayList<>();
        
        
        for(String s : set1){
            if(set2.remove(s)){
                intersection.add(s);
              }
            union.add(s);
        }
      
        for(String s : set2){
          union.add(s);
        }

        float jakard = 0;

        if(union.size() == 0) {
            answer = 65536;
        } else {
            jakard = (float)intersection.size() / (float)union.size();
            answer = (int)(jakard * 65536);
        }


// System.out.println("union" + union);
// System.out.println("intersection" + intersection);
// System.out.println("answer" + answer);

//          for(String string : set1){
//             System.out.println(string);
//         }
//         System.out.println("----------");

//         for(String string : set2){
//             System.out.println(string);
//         }


      return answer;  
    }
}