package boj;

import java.util.*;

public class Q1924 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();		// 월
		int y = sc.nextInt();		// 일
		sc.close();
		
		int sumOfDay = 0;
		String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		
		for(int i=0; i<x; i++) {
			switch(i) {
				case 1 : case 3 : case 5 : case 7 : case 8 : case 10 : case 12 : {
					sumOfDay += 31;
					break;
				}
				case 4 : case 6 : case 9 : case 11 : {
					sumOfDay += 30;
					break;
				}
				case 2 : {
					sumOfDay += 28;
					break;
				}
			}
		}
		
		sumOfDay += y;
		
		System.out.println(day[sumOfDay%7]);
	}
}
