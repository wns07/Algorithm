package swea;

import java.util.*;

public class Q1974 {		// 스도쿠 검증(D2)
	static int initCnt = 0;
	static int sumCnt = 0;
	static int[][][] tempArr2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		int[][][] arr = new int[t][11][11];
		int[][][] tempArr = new int[t][11][11];
		tempArr2 = new int[t][11][11];
		
		for(int i=0; i<arr.length; i++) {
			for(int j=1; j<arr[i].length-1; j++) {
				for(int k=1; k<arr[i][j].length-1; k++) {
					tempArr[i][k][j] = arr[i][j][k] = sc.nextInt();
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			squareSearch(arr[i], i);
		}
		
		for(int i=0; i<t; i++) {
			for(int j=1; j<arr[i].length-1; j++) {
				rowColumnSquareSearch(arr[i][j], 1);
				initMethod();
				
				rowColumnSquareSearch(tempArr[i][j], 1);
				initMethod();
				
				rowColumnSquareSearch(tempArr2[i][j], 1);
				initMethod();
			}
			
			printAnswer(i+1);
			sumCnt = 0;
		}
	}
	
	public static void printAnswer(int n) {
		System.out.print("#" + n + " ");
		
		if(sumCnt == 27) {
			System.out.println("1");
		} else {
			System.out.println("0");
		}
	}
	
	public static void initMethod() {
		if(initCnt == 9) {
			sumCnt++;
		}
		initCnt = 0;
	}
	
	public static void rowColumnSquareSearch(int[] a, int n) {
		for(int i=1; i<a.length-1; i++) {
			if(a[i] == n) {
				initCnt++;
				
				if(initCnt > 9)
					break;
				
				rowColumnSquareSearch(a, ++n);
				return;
			}
		}
	}
	
	public static void squareSearch(int[][] a, int n) {
		int[] cnt = new int[9];

		for(int i=1; i<4; i++) {
			for(int j=1; j<4; j++) {
				tempArr2[n][1][++cnt[0]] = a[i][j];
			}
			for(int j=4; j<7; j++) {
				tempArr2[n][2][++cnt[1]] = a[i][j];
			}
			for(int j=7; j<10; j++) {
				tempArr2[n][3][++cnt[2]] = a[i][j];
			}
		}
		
		for(int i=4; i<7; i++) {
			for(int j=1; j<4; j++) {
				tempArr2[n][4][++cnt[3]] = a[i][j];
			}
			for(int j=4; j<7; j++) {
				tempArr2[n][5][++cnt[4]] = a[i][j];
			}
			for(int j=7; j<10; j++) {
				tempArr2[n][6][++cnt[5]] = a[i][j];
			}
		}
		
		for(int i=7; i<10; i++) {
			for(int j=1; j<4; j++) {
				tempArr2[n][7][++cnt[6]] = a[i][j];
			}
			for(int j=4; j<7; j++) {
				tempArr2[n][8][++cnt[7]] = a[i][j];
			}
			for(int j=7; j<10; j++) {
				tempArr2[n][9][++cnt[8]] = a[i][j];
			}
		}
	}
}
