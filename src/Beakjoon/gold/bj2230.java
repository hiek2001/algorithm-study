package Beakjoon.gold;
import java.util.Scanner;
import java.util.Arrays;
public class bj2230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int A[] = new int[N];
		for(int i=0 ; i<N ; i++)
			A[i] = sc.nextInt();
		Arrays.sort(A);
		
		int start = 0;
		int end = 1;
		int min = Integer.MAX_VALUE;
		while(end < N) {
			int gap = A[end] - A[start];
			if(gap >= M) {
				min = Math.min(min, gap);
				start++;
			} else {
				end++;
			}
		}
		System.out.println(min);
	}
}
