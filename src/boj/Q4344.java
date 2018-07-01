package boj;

import java.util.*;

public class Q4344 {		// 평균은 넘겠지
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();		// 테스트케이스 수
		int[][] a = new int[c][];
		double[] avg = new double[c];
		
		for(int i=0; i<c; i++) {
			int stuCnt = sc.nextInt();
			int sum = 0;
			a[i] = new int[stuCnt];
			
			for(int j=0; j<stuCnt; j++) {
				a[i][j] = sc.nextInt();
				sum += a[i][j];
			}
			
			avg[i] = ((double)sum / stuCnt);
		}
		sc.close();
		
		for(int i=0; i<c; i++) {
			int cnt = 0;
			for(int j=0; j<a[i].length; j++) {
				
				if(a[i][j] > avg[i]) {
					cnt++;
				}
			}
			
			avg[i] = ((double)cnt / a[i].length)*100;
		}
		
		for(int i=0; i<avg.length; i++) {
			System.out.println(String.format("%.3f%%", avg[i]));
		}
	}
}
