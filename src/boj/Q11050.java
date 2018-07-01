package boj;

import java.util.*;

public class Q11050 {		// 이항계수1
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 5
		int k = sc.nextInt();		// 2
		sc.close();
		
		int result = 1;
		int temp = 0;
		
		while(temp != k) {
			result *= n--;
			temp++;
		}
		
		for(int i=k; i>0; i--) {
			result /= i;
		}
		
		System.out.println(result);
	}
}
