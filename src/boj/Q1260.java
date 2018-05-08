package boj;

import java.util.*;

public class Q1260 {		// DFS와 BFS
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 정점의 수
		int m = sc.nextInt();		// 간선의 수
		int v = sc.nextInt();		// 탐색을 시작할 정점의 번호
		
		int[][] a = new int[n+1][n+1];
		boolean[] visited1 = new boolean[n+1];
		boolean[] visited2 = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			int v1 = sc.nextInt();
			int v2 = sc.nextInt();
			
			a[v1][v2] = a[v2][v1] = 1;
		}
		sc.close();
		
		/*
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		*/
		
		dfs(a, visited1, v);
		System.out.println();
		bfs(a, visited2, v);
		
	}
	
	public static void dfs(int[][] a, boolean[] visited, int n) {		// stack or recursion
		visited[n] = true;
		System.out.print(n + " ");
		
		for(int i=1; i<a.length; i++) {
			if(a[n][i]==1 && visited[i]==false) {
				dfs(a, visited, i);
			}
		}
	}
	
	public static void bfs(int[][] a, boolean[] visited, int n) {		// queue
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		System.out.print(n + " ");
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int i=1; i<a.length; i++) {
				if(a[tmp][i]==1 && visited[i]==false) {
					q.add(i);		//
					visited[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}
}
