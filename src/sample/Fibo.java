package sample;

import java.util.*;
/*
 * 피보나치 푸는 방법 + 메모이제이션
 * 
 * 0 1 2 3 4 5 6  7  8  9
 * 0 1 1 2 3 5 8 13 21 34
*/
public class Fibo {			
	static int a = 0;
	static int[] arr;		// 재귀
	static int[] arr2;		// 메모이제이션
	static int[] arr3;		// 반복문1
	static int[] arr4;		// 반복문2(응용)
	
	public static void main(String[] args) {
		input();

		// 1. recursive : top-down
		resultFibonacci(a);
		System.out.println();
		
		// memoization
		resultFibonacci2(a);
		System.out.println();
		
		// 2. repetitive : bottom-up
		for(int i=2; i<=a; i++) {
			arr3[i] = arr3[i-1] + arr3[i-2];
		}
		System.out.println("반복문 : " + arr2[a]);
		
		// 2. 점화식 변형
		arr4[1] = 1;
		for(int i=0; i<a; i++) {
			arr4[i+2] += arr4[i];
			arr4[i+1] += arr4[i];
		}
		System.out.println("응용 : " + arr4[a]);
	}
	
	public static int fibonacci(int n) {
		arr[n]++;
		
		if(n == 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
		}
	}
	
	public static int fibonacci2(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		if(arr2[n] != -1) {
			return arr2[n];
		}
		
		arr2[n] = fibonacci2(n-1) + fibonacci2(n-2);
		
		return arr2[n];
	}
	
	public static void resultFibonacci(int a) {
		System.out.println("재귀 : " + fibonacci(a));
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("F(" + i + ") : " + arr[i] + "회 호출");
		}
	}
	
	public static void resultFibonacci2(int a) {
		System.out.println("메모이제이션 : " + fibonacci2(a));
		
		for(int i=0; i<arr.length; i++) {
			System.out.println("F(" + i + ") : " + arr2[i]);
		}
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		arr = new int[a+1];
		
		arr2 = new int[a+1];
		Arrays.fill(arr2, -1);		// 초기화

		arr3 = new int[a+1];
		arr4 = new int[a+3];
		
		sc.close();
	}
}
