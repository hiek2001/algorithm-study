package Baekjoon.sliver;
import java.io.*;
//DP[1] = step[1]
//DP[2] = step[1] + step[2]
//DP[3] = step[1] + step[3]
//          = step[2] + step[3] 이므로 max(step[1]+step[3] , step[2] + step[3]) 이다.
//DP[4] = step[1] + step[2] + step[4] = DP[2] + step[4]
//          = step[1] + step[3] + step[4] = DP[1] + step[3] + step[4] 이므로 max( DP[2] + step[4] , DP[1] + step[3] + step[4] )
//DP[5] = step[1] + step[2] + step[4] + step[5] = DP[2] + step[4] + step[5]
//          = step[1] + step[3] + step[5] = DP[3] + step[5] 이므로 max( DP[2] + step[4] + step[5], DP[3] + step[5])
public class bj2579 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] step = new int[num+1];
		for(int i=1 ; i<=num ; i++) {
			step[i] = Integer.parseInt(br.readLine());
		}
		if(num==1) {
			System.out.print(step[1]);
			return;
		}
		
		int[] DP = new int[num+1];
		DP[1] = step[1];
		if(num>=2) DP[2] = DP[1] + step[2];
		if(num>=3) DP[3] = Math.max(step[1]+step[3], step[2]+step[3]);
		for(int i=4 ; i<=num ; i++) {
			DP[i] = Math.max(DP[i-3]+step[i-1]+step[i], DP[i-2]+step[i]);
		}
		
		System.out.print(DP[num]);
	}
}
