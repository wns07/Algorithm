import java.util.*;

public class Test {
	static int[][][] b;
	
	public static void main(String[] args) {
		int[][][] a = new int[1][2][3];
		
		System.out.println(a.length);
		
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[i].length; j++) {
				for(int k=0; k<a[i][j].length; k++) {
					System.out.print(a[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		/////////////////////////////////////////////////////
		solve();
	}
	
	public static void solve() {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		
		b = new int[4][m][n];
		System.out.println(b.length);
		
		for(int i=0; i<b.length; i++) {
			for(int j=0; j<b[i].length; j++) {
				for(int k=0; k<b[i][j].length; k++) {
					System.out.print(b[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
