package swea;

import java.util.*;

public class Q2056 {		// 연월일 달력(D1)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		String[] s = new String[t];
		int[] month = new int[t];
		int[] day = new int[t];
		
		for(int i=0; i<t; i++) {
			s[i] = sc.next();
		}
		
		for(int i=0; i<t; i++) {
			month[i] = Integer.parseInt(s[i].substring(4, 6));
			day[i] = Integer.parseInt(s[i].substring(6, 8));
		}
		
		for(int i=0; i<t; i++) {
			System.out.print("#" + (i+1) + " ");
			
			switch(month[i]) {
				case 1 : case 3 : case 5 : case 7 :
				case 8 : case 10: case 12: {
					if(1<=day[i] && day[i]<=31) {
						System.out.println(s[i].substring(0, 4) + "/" + s[i].substring(4, 6) + "/" + s[i].substring(6, 8));
					} else {
						System.out.println(-1);
					}
					break;
				}
				case 4 : case 6 : case 9 : case 11 : {
					if(1<=day[i] && day[i]<=30) {
						System.out.println(s[i].substring(0, 4) + "/" + s[i].substring(4, 6) + "/" + s[i].substring(6, 8));
					} else {
						System.out.println(-1);
					}
					break;
				}
				case 2 : {
					if(1<=day[i] && day[i]<=28) {
						System.out.println(s[i].substring(0, 4) + "/" + s[i].substring(4, 6) + "/" + s[i].substring(6, 8));
					} else {
						System.out.println(-1);
					}
					break;
				}
				default : {
					System.out.println(-1);
				}
			}
		}
	}
}
