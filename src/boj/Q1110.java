package boj;

import java.util.*;

public class Q1110 {		// 더하기 사이클
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		System.out.println(solve(n));
	}
	
	public static int solve(int num) {		// 26
		int temp = num;
		int cnt = 0;
		
		do {
			int a = temp / 10;			// 2	/ 6
			int b = temp % 10;			// 6	/ 8
			temp = (b*10) + ((a + b) % 10);	// 60+8	/ 80+14
			cnt++;
		} while(temp != num);
		
		return cnt;
	}
}
