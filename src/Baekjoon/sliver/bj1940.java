package Baekjoon.sliver;
import java.util.Arrays;
import java.util.Scanner;
public class bj1940 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int A[] = new int[N];
		for(int i=0 ; i<N ; i++)
			A[i] = sc.nextInt();
		Arrays.sort(A);
		
		int i=0;
		int j = N-1;
		int count = 0;
		while(i < j) {
			if(A[i]+A[j] < M) i++;
			else if(A[i]+A[j] > M) j--;
			else {
				count++;
				i++;
				j--;
			}
			
		}
		System.out.println(count);
	}
}
