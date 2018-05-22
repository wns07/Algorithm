package boj;

import java.util.*;

public class Q2178 {		// 미로탐색
	static int n, m;
	static int[] dx = {0, 0, -1, 1};		// 상하좌우
	static int[] dy = {1, -1, 0, 0};
	static int[][] a;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		input();
		bfs();
//		testPrint();
		System.out.println(a[n][m]);
	}
	
	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visited[1][1] = true;
		q.add(new Point(1,1));
		
		while(!q.isEmpty()) {
			Point temp = q.poll();
//			System.out.println("x=" + temp.x + ", y=" + temp.y);
			
			for(int i=0; i<4; i++) {
				int next_x = temp.x + dx[i];
				int next_y = temp.y + dy[i];
				
				// 범위 체크
				if(1<=next_x && next_x<a.length && 1<=next_y && next_y<a[0].length) {
					if(a[next_x][next_y]!=0 && !visited[next_x][next_y]) {
						visited[next_x][next_y] = true;
						a[next_x][next_y] = a[temp.x][temp.y] + 1;
						q.add(new Point(next_x, next_y));
					}
				}
				
//				System.out.println(i+" : x=" + next_x + ", y=" + next_y);
			}
			
		}
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		a = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		String[] s = new String[n];
		
		for(int i=0; i<n; i++) {
			s[i] = sc.next();
		}
		
		for(int i=1; i<a.length; i++) {					// i=1,2,3,4
			for(int j=1; j<a[i].length; j++) {			// j=1,2,3,4,5
				a[i][j] = s[i-1].charAt(j-1) - '0';		// ASCII 코드 변환
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
	}
}

class Point {
	int x;		// private로 하면 값을 못불러옴(해당 클래스 안에서만 쓸수 있으니까)
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}