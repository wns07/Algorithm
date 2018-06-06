package boj;

import java.util.*;

public class Q2455 {		// 지능형 기차(시뮬레이션)
	static int[][] a;
	static int result = 0;

	public static void main(String[] args) {
		input();
		simulation();
		System.out.println(result);
	}

	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		a = new int[4][2];
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				a[i][j] = sc.nextInt();		// 내린사람, 타는사람
			}
		}
		
		sc.close();
	}
	
	public static void simulation() {
		int temp = 0;
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				if(j == 0) {		// 내릴 때
					temp -= a[i][j];
				} else {			// 탈 때
					temp += a[i][j];
				}
				
				if(temp > result) {
					result = temp;
				}
			}
		}
		
	}
	
	public static void testPrint() {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
