package Baekjoon.sliver;
import java.util.Scanner;
public class bj20922 {
	static int count, max, checkNum, N, K;
	static int A[], checkArr[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		A = new int[N];
		checkArr = new int[100001];
		for(int i=0 ; i<N ; i++) {
			A[i] = sc.nextInt();
		}
		
		int max = 0;
		int startIndex = 0;
		int endIndex = 0;
		
		while(endIndex < N) {
			if(checkArr[A[endIndex]] < K) {
				checkArr[A[endIndex]]++;
				endIndex++;
				max = Math.max(max, endIndex-startIndex);
			} else {
				checkArr[A[startIndex]]--;
				startIndex++;
			}
		}
		
		System.out.println(max);
	}

}
