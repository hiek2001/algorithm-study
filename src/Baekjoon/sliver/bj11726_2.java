package Baekjoon.sliver;
import java.util.*;
public class bj11726_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		
		int[] DP = new int[N+1];
		DP[1] = 1;
		if(N>=2) {
			DP[2] = 2;
		}
		
		for(int i=3 ; i<N+1 ; i++) {
			DP[i] = (DP[i-1] + DP[i-2])%10007; // 모듈러의 연산 : N의 범위가 1000까지이므로, 경우의 수가 너무 커지는 것을 방지  
		}
		
		System.out.print(DP[N]%10007);
	}
}
