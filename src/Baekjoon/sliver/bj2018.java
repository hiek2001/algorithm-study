package Baekjoon.sliver;
import java.util.*;
public class bj2018 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N+1];
		for(int i=1 ; i<=N ; i++) {
			A[i] = i;
		}
		
		int start_index = 1;
		int end_index = 1;
		int sum = 1;
		int count = 1; // 15만 더한 경우, 추가
		while(end_index != N) {
			if(sum < N) {
				end_index++;
				sum = sum + A[end_index];
			} else if (sum > N) {
				sum = sum - A[start_index];
				start_index++;
			} else {
				count++;
				end_index++;
				sum = sum + A[end_index];
			}
		}
		System.out.println(count);
	}
}
