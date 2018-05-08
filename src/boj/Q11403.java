package boj;

import java.util.*;

public class Q11403 {			// 경로찾기
	static int[][] a;
	static int[][] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 정점의 갯수
		
		a = new int[n+1][n+1];
		visited = new boolean[n+1];
		result = new int[n+1][n+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<n+1; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		for(int i=1; i<=n; i++) {		// i=1,2,3,4,5,6,7
			dfs(i);
			
			for(int j=1; j<visited.length; j++) {
				if(visited[j]) {
					result[i][j] = 1;
				}
			}
			
			visited = new boolean[n+1];
		}

//		testPrint();
		resultPrint();
	}
	
	public static void dfs(int v) {
		for(int i=1; i<a.length; i++) {		// i=1,2,3,4,5,6,7
			if(a[v][i]==1 && !visited[i]) {
				visited[i] = true;
				
				dfs(i);
			}
		}
	}
	
	public static void testPrint() {
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i=1; i<visited.length; i++) {
			System.out.print(visited[i] + " ");
		}
	}
	
	public static void resultPrint() {
		for(int i=1; i<result.length; i++) {
			for(int j=1; j<result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
