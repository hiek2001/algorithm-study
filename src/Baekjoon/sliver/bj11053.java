package Baekjoon.sliver;
import java.util.*;
import java.io.*;
// 점화식의 의미
// dp[i] = 현재 index와 이전 index를 비교하여 큰 값의 갯수를 더함
// dp 배열에서 자기자신은 모두 1개이므로, 1로 초기화
// dp[i] = dp[j] + 1
public class bj11053 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<n ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1); // 자기자신은 모두 1개이므로, 1로 초기화
		
		for(int i=1 ; i<n ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(a[i] > a[j]) {
					if(dp[i] <= dp[j]) {
						dp[i] = dp[j] + 1;
					}
					
				}
			}
		}
		
		int max = 0;
		for(int num : dp) {
			if(max < num) {
				max = num;
			}
		}
		
		System.out.print(max);
	}
}
