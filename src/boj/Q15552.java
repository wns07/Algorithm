package boj;

import java.io.*;

public class Q15552 {		// 빠른 A+B
	public static void main(String[] args) throws IOException {
		// Scanner -> BufferedReader
		// System.out.println -> BufferedWriter
		// BufferedWriter.flush는 맨마지막에 한번만
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][2];
		
		for(int i=0; i<a.length; i++) {
				String[] s = br.readLine().split(" ");
				a[i][0] = Integer.parseInt(s[0]);
				a[i][1] = Integer.parseInt(s[1]);
		}
		
		for(int i=0; i<a.length; i++) {
			bw.write((a[i][0]+a[i][1] + "\n"));
		}
		bw.flush();
		bw.close();
	}
}
