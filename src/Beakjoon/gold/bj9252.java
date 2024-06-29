package Beakjoon.gold;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class bj9252 {
	static long DP[][];
	static char A[];
	static char B[];
	static ArrayList<Character> Path;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		DP = new long[A.length][B.length];
		for(int i=1 ; i<A.length ; i++) {
			for(int j=1 ; i<B.length ; j++) {
				if(A[i-1] == B[j-1]) {
					DP[i][j] = DP[i-1][j-1] + 1;
				} else {
					DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]);
				}
				
			}
		}
		System.out.println(DP[A.length][B.length]);
		getText(A.length, B.length);
		for(int i=Path.size()-1 ; i>=0 ; i--) {
			System.out.print(Path.get(i));
		}
		System.out.println();
	}
	
	private static void getText(int r, int c) {
		if(r==0 || c==0) return;
		if(A[r-1] == B[c-1]) {
			Path.add(A[r-1]);
		} else {
			if(DP[r-1][c] > DP[r][c-1])
				getText(r-1, c);
			else 
				getText(r, c-1);
		}
	}
}
