package boj;

import java.util.*;
/*
 * 주기공식을 검색하고 품
 * 주기 구하는 메소드 작성해보기
 */
public class Q2749 {		// 피보나치 수3
	static int[] arr;
	static int mod = 1000000;
	static int p = 15 * mod / 10;		// 주기
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		sc.close();
		
		arr = new int[p];
		
		arr[1] = 1;
		for(int i=2; i<p; i++) {
			arr[i] = arr[i-1] + arr[i-2];
			arr[i] %= mod;
		}
		
		System.out.println(arr[(int)(n%p)]);
	}
}
