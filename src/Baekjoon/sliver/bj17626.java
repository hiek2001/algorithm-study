package Baekjoon.sliver;
import java.io.*;
// 점화식
// DP[N] = 자연수 N이 주어질 때, 제곱합으로 표현되는 최소 갯수
// DP[N] = DP[i*i] - DP[N-i*i]
// ex) DP[10] = 1 + 9
//            = 4 + 6
public class bj17626 {
	static int[] DP;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		DP = new int[N+1];
		
		// 제곱수 자체는 항상 1개로 표현되기 때문에 1로 초기화
		// ex) 4 = 2^2
		for(int i=1 ; i*i<=N ; i++) { 
			DP[i*i] = 1;
		}
		
		for(int i=1 ; i<=N ; i++) {
			if(DP[i] != 0) continue; // 이미 계산된 부분은 건너뛰기
			solve(i);	// i에 대한 최소 항 계산
		}
		
		System.out.println(DP[N]);
	}
	
	static void solve(int num) {
		for(int i=1 ; i*i<=num ; i++) { // i는 num보다 작은 모든 제곱수
			if(DP[num] == 0) { // DP[num]이 계산되지 않은 경우
				DP[num] = DP[i*i] + DP[num-i*i]; // 제곱수 항을 더함
			} else { // 이미 값이 있는 경우는 최소값을 갱신
				DP[num] = Math.min(DP[num], DP[i*i] + DP[num-i*i]);
			}
		}
	}
}
