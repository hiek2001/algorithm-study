package Beakjoon.gold;
import java.util.*;
public class bj1915 {
	static long D[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		D = new long[N][M];
		long max = 0;
		for(int i=0 ; i<N ; i++) {
			String mline = sc.next();
			for(int j=0 ; j<M ; j++) {
				D[i][j] = Long.parseLong(String.valueOf(mline.charAt(j)));
				if(i>0 && j>0 && D[i][j] == 1) {
					D[i][j] = Math.min(D[i-1][j-1], Math.min(D[i-1][j], D[i][j-1])) + 1;
				}
				if(max < D[i][j]) {
					max = D[i][j];
				}
			}
		}
		System.out.println((int)Math.pow(max,2));
	}
}
