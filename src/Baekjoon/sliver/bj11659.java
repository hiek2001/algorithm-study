package Baekjoon.sliver;
import java.util.*;
public class bj11659 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int N = sc.nextInt();
		int M = sc.nextInt();
		int A[] = new int[N+1];
		int S[] = new int[N+1];
		for(int i=1 ; i<=N ; i++)
			A[i] = sc.nextInt();
		
		S[1] = A[1];
		for(int i=2 ; i<=N ; i++)
			S[i] = S[i-1] + A[i];
		
		for(int i=0 ; i<M ; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x > y) {
				int temp = x;
				x = y;
				y = temp;
			}
			if(x == y) result = A[y];
			else result = S[y] - S[x-1];
			System.out.println(result);
		}
	}
}
