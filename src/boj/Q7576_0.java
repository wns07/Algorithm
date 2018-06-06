package boj;

import java.util.*;
/*
 * 실패...
 * 이유분석 : count값을 가지려고 하면 헷갈림... 차라리 visited를 배열로 만드는게 낫다
 * 좌표값을 횟수랑 한꺼번에 입력받기.
 */
public class Q7576_0 {			// 토마토
	static int[] dx = {0, 0, -1, 1};		// 상하좌우
	static int[] dy = {1, -1, 0, 0};
	
	static int[][] a;
	static int cnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		a = new int[n + 1][m + 1];

		for (int i = 1; i < a.length; i++) { // 1:익은토마토, 0:익지않은토마토, -1:비어있음
			for (int j = 1; j < a[i].length; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		solve();

		// result : 저장될 때부터 다 익음:0, 토마토가 모두 익지 못하는 상황:-1
		
		resultPrint();
	}
	
	public static void solve() {
		bfs();
	}

	public static void bfs() {		// cnt 증가
		Queue<Point> q = new LinkedList<>();
		
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				if(a[i][j] == 1) {
					q.add(new Point(i, j));
				}
			}
		}
		
		/* 0에서 1로 바꿔주고 횟수를 증가해줘야 하는 부분 */
		while(!q.isEmpty()) {
			Point temp = q.poll();
			
			System.out.println(temp.x + " : " + temp.y);
			
			for(int i=0; i<4; i++) {
				int next_x = temp.x + dx[i];
				int next_y = temp.y + dy[i];
				
				if(next_x<0 || next_y<0 || next_x>a.length-1 || next_y>a[1].length-1) {
					continue;
				}
				
				if(a[next_x][next_y] == 0) {
					a[next_x][next_y] = 1;
				}
			}
			
			cnt++;
			System.out.println("cnt : " + cnt);
		}
		
	}
	
	public static boolean check() {
		for(int i=1; i<a.length; i++) {
			for(int j=1; j<a[i].length; j++) {
				if(a[i][j] == 0) {		// 익지 않은 토마토가 존재
					return false;
				}
			}
		}
		
		return true;
	}
	
	public static void resultPrint() {
		if(check()) {
			if(cnt == 0) {
				System.out.println(0);
			} else {
				System.out.println(cnt);
			}
		} else {
			System.out.println(-1);
		}
	}

	public static void test() {
		for (int i = 1; i < a.length; i++) {
			for (int j = 1; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static class Point {
		private int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
