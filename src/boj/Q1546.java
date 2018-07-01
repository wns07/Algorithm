package boj;

import java.util.*;

public class Q1546 {		// 평균
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 과목의 수
		double[] score = new double[n];
		double max = 0;
		double sum = 0;
		
		for(int i=0; i<n; i++) {
			score[i] = sc.nextDouble();
			
			if(score[i] > max) {
				max = score[i];
			}
		}
		sc.close();
		
		for(int i=0; i<n; i++) {
			score[i] = ((double)score[i]/max)*100;
			sum += score[i];
		}
		
//		System.out.println(Math.round((sum/n)*100)/100.0);
		System.out.println(String.format("%.2f", (sum/n)));
	}
}
