package Beakjoon.gold;
import java.util.Scanner;
public class bj13398 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N];
		for(int i=0 ; i<N ; i++) {
			A[i] = sc.nextInt();
		}
		
		int L[] = new int[N];
		int result = L[0];
		L[0] = A[0];
		for(int i=1 ; i<N ; i++) {
			L[i] = Math.max(A[i], L[i-1]+A[i]);
			result = Math.max(result, L[i]); // 1개도 제거하지 않았을 경우
		}
		
		int R[] = new int[N];
		R[N-1] = A[N-1];
		for(int i=N-2 ; i>=0 ; i--) {
			R[i] = Math.max(A[i], R[i+1]+A[i]);
		}
		
		for(int i=1 ; i<N-1 ; i++) {
			int temp = L[i-1] + R[i+1];
			result = Math.max(result, temp);
		}
		
		System.out.println(result);
	}
}
