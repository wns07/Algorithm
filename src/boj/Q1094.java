package boj;

import java.util.*;

public class Q1094 {		// 막대기(시뮬레이션)
	static int x = 0;
	static int cnt = 0;
	
	public static void main(String[] args) {
		input();
		simulation();
		System.out.println(cnt);
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		x = sc.nextInt();
		sc.close();
	}
	
	public static void simulation() {
		int[] arr = {64, 32, 16, 8, 4, 2, 1};
		int temp = 0, a = 0;

		while(x != temp) {
			if(x >= arr[a]) {
				x -= arr[a];
				cnt++;
			} else {
				a++;
			}
		}
	}
}
