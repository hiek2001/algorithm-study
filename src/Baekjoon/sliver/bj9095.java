package Baekjoon.sliver;
import java.io.*;
// dp[n] = 정수 n이 주어질 때, n을 1,2,3 합으로 나타내는 방법의 갯수
// '갯수'를 찾는 것이므로 dp[5] 이면 dp[5]가 나올 수 있는 경우의 수를 모두 찾아보기
// dp[1] ~ dp[5] 직접 찾아서 점화식 도출
// dp[n] = dp[i-1] + dp[i-2] + dp[i-3]
public class bj9095 {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4 ; i<11 ; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for(int i=0 ; i<n ; i++) {
			sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
		}
		
		System.out.println(sb);
	}
}
