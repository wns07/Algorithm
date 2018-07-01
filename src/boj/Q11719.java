package boj;

import java.util.*;
/*
 * hasNextLine 메소드 : 입력버퍼에 다음 입력값의 유무를 자동으로 판별
 */
public class Q11719 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}
		sc.close();
	}
}
