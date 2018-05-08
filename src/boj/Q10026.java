package boj;

import java.util.*;

public class Q10026 {		// 적록색약
	static int[] m_x = {0, 0, -1, 1};	// 상, 하, 좌, 우
	static int[] m_y = {1, -1, 0, 0};
	
	static int[][] aArr;		// 적록색약 아님
	static int[][] bArr;		// 적록색약임
	
	static boolean[][] visited1;
	static boolean[][] visited2;
	
	static int aCnt = 0;
	static int bCnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();			// input : 5

		String[] str = new String[n+1];
		char[][] cArr = new char[n+1][n+1];
		aArr = new int[n+1][n+1];
		bArr = new int[n+1][n+1];
		visited1 = new boolean[n+1][n+1];
		visited2 = new boolean[n+1][n+1];
		
		for(int i=1; i<str.length; i++) {
			str[i] = sc.next();
		}
		for(int i=1; i<str.length; i++) {
			for(int j=1; j<=str[i].length(); j++) {
				cArr[i][j] = str[i].charAt(j-1);
			}
		}
		
		for(int i=1; i<aArr.length; i++) {
			for(int j=1; j<aArr[i].length; j++) {
				if(cArr[i][j] == 'R') {
					aArr[i][j] = 1;
					bArr[i][j] = 1;
				} else if(cArr[i][j] == 'G') {
					aArr[i][j] = 2;
					bArr[i][j] = 1;
				} else if(cArr[i][j] == 'B') {
					aArr[i][j] = 3;
					bArr[i][j] = 2;
				}
			}
		}
		
		for(int i=1; i<n+1; i++) {			// i=1,2,3,4,5
			for(int j=1; j<n+1; j++) {		// j=1,2,3,4,5
				if(aArr[i][j]==1 && !visited1[i][j]) {
					dfs(i, j, 1, ++aCnt);					// result : 2
				}
				if(aArr[i][j]==2 && !visited1[i][j]) {
					dfs(i, j, 2, ++aCnt);					// result : 1
				}
				if(aArr[i][j]==3 && !visited1[i][j]) {
					dfs(i, j, 3, ++aCnt);					// result : 1
				}
				if(bArr[i][j]==1 && !visited2[i][j]) {
					dfs2(i, j, 1, ++bCnt);					// result : 2
				}
				if(bArr[i][j]==2 && !visited2[i][j]) {
					dfs2(i, j, 2, ++bCnt);					// result : 1
				}
			}
		}
		
		System.out.println(aCnt + " " + bCnt);
	}
	
	public static void dfs(int a, int b, int color, int cnt) {
		visited1[a][b] = true;
		
		for(int i=0; i<4; i++) {
			int nxt_x = a + m_x[i];
			int nxt_y = b + m_y[i];
			
			if(0<=nxt_x && nxt_x<=aArr[0].length-1 && 0<=nxt_y && nxt_y<=aArr[0].length-1) {
				if(aArr[nxt_x][nxt_y]==color && !visited1[nxt_x][nxt_y]) {
					dfs(nxt_x, nxt_y, color, cnt);
				}
			}
		}
	}
	
	public static void dfs2(int a, int b, int color, int cnt) {
		visited2[a][b] = true;
		
		for(int i=0; i<4; i++) {
			int nxt_x = a + m_x[i];
			int nxt_y = b + m_y[i];
			
			if(0<=nxt_x && nxt_x<=bArr[0].length-1 && 0<=nxt_y && nxt_y<=bArr[0].length-1) {
				if(bArr[nxt_x][nxt_y]==color && !visited2[nxt_x][nxt_y]) {
					dfs2(nxt_x, nxt_y, color, cnt);
				}
			}
		}
	}
}
