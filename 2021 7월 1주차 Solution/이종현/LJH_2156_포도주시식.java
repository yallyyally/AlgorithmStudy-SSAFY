package day07022;

import java.io.*;
import java.util.*;

public class boj_2156_포도주시식 {
    static int n;
    static int[] scores;
    static int[][][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scores = new int[n];
        
        for(int i=0; i<n; i++){
            scores[i]=Integer.parseInt(br.readLine());
        }

        dp = new int[n][2][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println(func(0,0,0));

    }
    static int func(int idx, int beforeTwo, int beforeOne){
        if(idx==n) return 0;
        //방문한 적 있으면 값 return
        if(dp[idx][beforeTwo][beforeOne] != -1) return dp[idx][beforeTwo][beforeOne];

        //방문한 적 없으면 값 초기화
        int value=0;
        
        //oo면 무조건 건너뛰어야한다.
        if(beforeTwo == 1 && beforeOne == 1){
            value = Math.max(value, func(idx+1, beforeOne, 0));
        }else{
        	//xo or oo
            value = Math.max(value, func(idx+1, beforeOne, 1)+scores[idx]);
            value = Math.max(value, func(idx+1, beforeOne, 0));
        }
        dp[idx][beforeTwo][beforeOne] = value;
        return dp[idx][beforeTwo][beforeOne];
    }
}