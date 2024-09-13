package Baekjoon.sliver;
import java.util.*;
// 점화식의 의미
// dp[i] = i번째 위치에서 끝나는 부분 수열의 합 중 가장 큰 값
// 즉, 새로운 수열을 시작할 것인지, 이전 수열을 이어서 확장할 것인지 선택해야 함
// dp[i] = max(dp[i-1]+a[i], a[i])
import java.io.*;
public class bj1912 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) { // 배열 입력
			a[i] = Integer.parseInt(st.nextToken());		
		}
		
		int[] dp = new int[n];
		dp[0] = a[0];
		for(int i=1 ; i<n ; i++) {
			dp[i] = Math.max(dp[i-1]+a[i], a[i]);
		}

		int max = Integer.MIN_VALUE;
		for(int num : dp) {
			if(max < num) {
				max = num;
			}
		}
		
		System.out.print(max);
	}
}
