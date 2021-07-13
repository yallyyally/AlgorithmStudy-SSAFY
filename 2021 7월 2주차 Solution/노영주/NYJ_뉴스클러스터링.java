import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        ArrayList<Cluster> A = new ArrayList<Cluster>();
        ArrayList<Cluster> B = new ArrayList<Cluster>();

        int str1Len=str1.length();
        for(int i=0;i<str1Len-1;i++){
            String temp = str1.substring(i,i+2);

            if(isDigit(temp)){ //정규표현식 함수 isDigit을 충족하면
                int size=A.size();
                boolean flag= false;                                           
                for(int s=0;s<size;s++){
                    Cluster now = A.get(s);

                    if(temp.equals(now.word)){
                        flag=true;
                        A.set(s,new Cluster(temp,now.count+1));
                    }
                }
               if(size==0 || !flag)
                    A.add(new Cluster(temp,1));

            }
        }
        int str2Len=str2.length();
        for(int i=0;i<str2Len-1;i++){
            String temp = str2.substring(i,i+2);
            if(isDigit(temp)){
                int size=B.size();
                boolean flag= false;                                           
                for(int s=0;s<size;s++){
                    Cluster now = B.get(s);
                    if(temp.equals(now.word)){
                        flag=true;
                        B.set(s,new Cluster(temp,now.count+1));
                    }
                }
               if(size==0 || !flag)
                    B.add(new Cluster(temp,1));       
            }

        }

        int min=0;
        int max=0;

        int sizeA = A.size();
        int sizeB = B.size();

        for(int s1=0;s1<sizeA;s1++){
            Cluster now = A.get(s1);
            boolean flag= false;
            for(int s2=0;s2<sizeB;s2++){
                Cluster temp = B.get(s2);

                if(now.word.equals(temp.word)){
                    min+=Math.min(now.count,temp.count);
                    max+=Math.max(now.count,temp.count);
                    flag=true;        
                }         
            }           
            if(!flag){ //A기준 중복원소가 없는 원소를 합집합에 포함
                 max+=now.count;
            }                                 
        }

        for(int s2=0;s2<sizeB;s2++){
            Cluster now = B.get(s2);
            boolean flag=false;
            for(int s1=0;s1<sizeA;s1++){
                Cluster temp = A.get(s1);

                if(now.word.equals(temp.word)){
                    flag=true;
                }         
            }           
            if(!flag){ //B기준 중복원소가 없는 원소를 합집합에 포함
                 max+=now.count;
            }                                 
        }

        double result=0.;

        if(min!=0 && max!=0){
            result = ((double)min/(double)max);
            result*=65536;
        }else if(max==0){ //?/0은 1로 문제에서 정의
            result=65536;
        }else if(min==0){ // 0/2는 0
            result=0.;
        }

        return (int)result;
    }
    public boolean isDigit(String word){
    return word.matches("[a-z][a-z]");
    }
}
class Cluster{
    String word;
    int count;

    Cluster(String word, int count){
        this.word = word;
        this.count=count;
    }
}