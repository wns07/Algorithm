package boj;

import java.util.*;

public class Q11721 {		// 열 개씩 끊어 출력하기
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		
		String[] a = s.split("");
		int cnt = 0;
		
		for(int i=0; i<a.length; i++) {
			cnt++;
			System.out.print(a[i]);
			if(cnt % 10 == 0) {
				System.out.println();
			}
		}
	}
}
