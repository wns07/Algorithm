package boj;

import java.util.*;

public class Q11720 {		// 숫자의 합
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 숫자의 갯수
		String s = sc.next();	// 숫자 공백없이 입력
		sc.close();
		
		String[] arr = new String[n];
		int sum = 0;
		
		for(int i=0; i<n; i++) {
			arr = s.split("");
			sum += Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum);
	}
}
