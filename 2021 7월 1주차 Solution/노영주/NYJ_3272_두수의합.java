package day0627;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NYJ_3272_두수의합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int i=0,j=n-1;
		int ans=0;
		
		while(i<j) {
			if(arr[i]+arr[j]==x) {
				ans++;
				j--;
			}else if(arr[i]+arr[j]>x) {
				j--;
			}else if(arr[i]+arr[j]<x) {
				i++;
				j=n-1;
			}
		}
		
		System.out.println(ans);
	}
}
