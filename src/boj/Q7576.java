package boj;

import java.util.*;

public class Q7576 {		// 토마토 : 완성
	static int m, n;
	static int[][] a;
	static boolean[][] visited;
	
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	
	static int max = 0;
	
	public static void main(String[] args) {
		input();
		bfsTest();
//		bfs();
		resultPrint();
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();		// 6
		n = sc.nextInt();		// 4
		
		a = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				a[i][j] = sc.nextInt();				// 1:익음, 0:익지x, -1:비었음
			}
		}
//		testPrint();
	}
	
	public static void bfsTest() {
		Queue<TomatoPos> q = new LinkedList<>();
		
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				if(a[i][j] == 1) {
					q.add(new TomatoPos(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			TomatoPos temp = q.poll();
			
			for(int i=0; i<4; i++) {
				int next_x = temp.x + dx[i];
				int next_y = temp.y + dy[i];
				
				if(1<=next_x && next_x<a.length && 1<=next_y && next_y<a[0].length) {
					if(a[next_x][next_y]==0 && !visited[next_x][next_y]) {
						visited[next_x][next_y] = true;
						a[next_x][next_y] = 1;
						q.add(new TomatoPos(next_x, next_y, temp.count+=1));
						temp.count-=1;
					}
				}
			}
			
			if(temp.count > max) {
				max = temp.count;
			}
			
//			System.out.println("temp.x=" + temp.x + ", temp.y=" + temp.y + ", temp.count=" + temp.count);
		}
		
//		testPrint();
	}
	
	public static void bfs() {
		Queue<TomatoPos> q = new LinkedList<>();
		
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				if(a[i][j] == 1) {
					q.add(new TomatoPos(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			TomatoPos temp = q.poll();
			
			for(int i=0; i<4; i++) {
				int next_x = temp.x + dx[i];
				int next_y = temp.y + dy[i];
				
			}
			
			System.out.println(temp.x + " : " + temp.y);
		}
	}
	
	public static void resultPrint() {
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				if(a[i][j] == 0) {				// 모두 익지 못함
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(max);				// 최소날짜 or 저장될때부터 모두 익어있으면 0(초기화된거 그대로)
	}
	
	public static void testPrint() {
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("====================");
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}
}

class TomatoPos {
	int x;
	int y;
	int count;
	
	TomatoPos(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}