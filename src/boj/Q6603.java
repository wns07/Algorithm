package boj;

import java.util.*;

public class Q6603 {		// 로또
	static int k = 0;
	static int[] tmpArr = null;
	static int[] lotto = new int[6];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			k = sc.nextInt();		// 6<k<13
			
			if(k == 0) {
				break;
			} else {
				tmpArr = new int[k];
			}
			
			for(int i=0; i<k; i++) {
				tmpArr[i] = sc.nextInt();
			}
			
			dfs(0, 0);
			System.out.println();
		}
	}
	
	public static void dfs(int start, int depth) {
		if(depth == 6) {
			for(int i=0; i<lotto.length; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<k; i++) {
			lotto[depth] = tmpArr[i];
			dfs(i+1, depth+1);
		}
	}
}
