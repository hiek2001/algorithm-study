package Baekjoon.sliver;
import java.util.*;
public class bj14501 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T[] = new int[N+1];
		int P[] = new int[N+1];
		int D[] = new int[N+2];
		for(int i=1 ; i<=N ; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		for(int i=N ; i>0 ; i--) {
			if(i+T[i] > N+1) {
				D[i] = D[i+1];
			} else {
				D[i] = D[i+T[i]]+P[i];
			}
		}
		
		System.out.println(D[1]);
	}
}
