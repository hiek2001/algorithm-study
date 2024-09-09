package Baekjoon.sliver;
import java.util.*;
//int minValue = Math.min(D[i/3], D[i/2]) + 1;
// 이렇게 하게 되면 D[i/3], D[i/2]은 정확히 나누어지지 않은 경우도 있어, +1이 되지 않음
// 조건문을 추가하여 정확히 나누어떨어질 수 있도록 설정
public class bj1463 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] D = new int[N+1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[1] = 0;
		if(N>=2) D[2] = 1;
		if(N>=3) D[3] = 1;
		for(int i=4 ; i<N+1 ; i++) {
			int minValue = D[i-1];
			
			if(i%3 == 0) { // 큰 수를 먼저 나누면 횟수를 줄일 수 있음
				minValue = Math.min(minValue, D[i/3]);
			} 
			if(i%2 == 0) {
				minValue = Math.min(minValue, D[i/2]);
			}

			D[i] = minValue+1;
		}
		System.out.print(D[N]);
	}
}
