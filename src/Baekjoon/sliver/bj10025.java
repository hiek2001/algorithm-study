package Baekjoon.sliver;
import java.util.Scanner;
public class bj10025 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt() *2 + 1;
		int A[] = new int[1000001];
		for(int i=0 ; i<N ; i++) {
			int ice = sc.nextInt();
			int location = sc.nextInt();
			A[location] = ice;
		}
		
		 int sum = 0, max = 0;
	      for (int i = 0; i <= 1000000; i++) {
	         if(i-K>=0) sum -= A[i - K];
	         sum += A[i];
	         max = Math.max(max,sum);
	      }

		System.out.println(max);
	}
}
