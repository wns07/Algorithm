package swea;

import java.util.*;

public class Q1204 {			// 최빈수 구하기(D2)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[11][101];
		int[] result = new int[11];
		
		for(int i=1; i<=10; i++) {
			int testCase = sc.nextInt();		// 테스트케이스 번호(총 갯수가 아님)

			int compNum = 0;			// 비교값
			int stuCnt = 1000;
			int max = 0;
			
			while(stuCnt > 0) {
				int score = sc.nextInt();
				arr[testCase][score] += 1;
				
				stuCnt--;
			}
			
			for(int j=0; j<arr[testCase].length; j++) {
				if(compNum <= arr[testCase][j]) {
					compNum = arr[testCase][j];
					max = j;
				}
			}
			result[testCase] = max;
		}
		
		for(int i=1; i<=10; i++) {
			System.out.println("#" + i + " " + result[i]);
		}
	}
}
