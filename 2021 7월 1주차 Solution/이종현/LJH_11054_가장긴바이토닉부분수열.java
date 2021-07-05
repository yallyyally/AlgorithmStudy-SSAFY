package day0705;

import java.util.Scanner;

public class boj_11054_가장긴바이토닉부분수열 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] numbers = new int[N];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}
		
//		for (int i = 0; i < numbers.length; i++) {
//			System.out.print(numbers[i]+" ");
//		}
		
		int[] leftMax = new int[N];
		int[] rightMax = new int[N];
		int[] sumMax = new int[N];
		
		for (int i = 0; i < N; i++) {
			for (int j = i; j >= 0 ; j--) {
				if(numbers[i]>numbers[j]) {
					leftMax[i] = Math.max(leftMax[i],leftMax[j]+1);
				}
			}
		}
		
//		for (int i = 0; i < sumMax.length; i++) {
//			System.out.print(leftMax[i]+" ");
//		}
//		System.out.println();
		
		
		for (int i = N-1; i >= 0; i--) {
			for (int j = i; j < N; j++) {
				if(numbers[i] > numbers[j]) {
					rightMax[i] = Math.max(rightMax[i],rightMax[j]+1);
				}
			}
		}
		
//		for (int i = 0; i < sumMax.length; i++) {
//			System.out.print(rightMax[i]+" ");
//		}
		int ans = 0;
		for (int i = 0; i < sumMax.length; i++) {
			sumMax[i] = leftMax[i] + rightMax[i] + 1;
			ans = Math.max(sumMax[i], ans);
		}
		
		System.out.println(ans);
	}

}
