package boj;

import java.util.*;

/*
 * 조건이 3개라서 dp로 풀려다가 못품
 * dfs로 풀려다가 못풀어서 인터넷 찾아보니 bfs로 풀어야한다고 알게됨
 * 왜 bfs로 풀까 고민하다가 그림을 그려봄(트리구조)
 * 조심해야할 것은 런타임에러와 시간초과...
 * 왜 배열크기를 100001로 잡을까?
 */

public class Q1697 {		// 숨바꼭질
	static int n, k;
	static int[] dx = {-1, 1, 2};
	static int cnt = 0;
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) {
		input();
		System.out.println(bfs());
	}
	
	public static void input() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();		// 수빈 5
		k = sc.nextInt();		// 동생 17
		sc.close();
	}
	
	public static int bfs() {		// 5-10-9-18-17 -> 4
		Queue<Position> q = new LinkedList<>();
		q.add(new Position(n, 0));
		visited[n] = true;
		
		while(!q.isEmpty()) {
			Position temp = q.poll();
			int now = temp.pos;
			int cnt = temp.count;
//			System.out.println("temp=" + now + " : " + cnt);
			
			if(now == k) {
				return cnt;
			}
			
			for(int i=0; i<3; i++) {
				int next = 0;
				int num = cnt+1;
				
				if(i != 2) {
					next = now + dx[i];
				} else {
					next = now * dx[i];
				}
//				System.out.println("for문 안 = " + i + " : " + next);
				
				if(0<=next && next<=100000) {				// 없으면 런타임 에러
					if(!visited[next]) {					// 없으면 시간초과
						q.add(new Position(next, num));
						visited[next] = true;
					}
				}
			}
//			System.out.println();
		}
		
		return -1;
	}
}

class Position {
	int pos;
	int count;
	
	Position(int pos, int count) {
		this.pos = pos;
		this.count = count;
	}
}