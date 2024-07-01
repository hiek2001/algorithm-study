package Beakjoon.gold;
import java.util.Scanner;
public class bj2342 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int mp[][] = {{0,2,2,2,2}
			,{2,1,3,4,3}
			,{2,3,1,3,4}
			,{2,4,3,1,3}
			,{2,3,4,3,1}
		};
		
		int dp[][][] = new int[100001][5][5];
		for(int i=0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				for(int k=0 ; k<100001 ; k++) {
					dp[k][i][j] = 100001*4;
				}
			}
		}
		dp[0][0][0] = 0;
		int n = 0, s = 1;
		while(true) {
			n = sc.nextInt();
			if(n == 0) break;
			for(int i=0 ; i<5 ; i++) { // 왼발 위치
				if(n == i) continue;
				for(int j=0 ; j<5 ; j++) { // 오른발 위치 
					// 오른발 옮기기
					dp[s][i][n] = Math.min(dp[s-1][i][j] + mp[j][n], dp[s][i][n]);
					// mp[j][n] -> 오른발 j번째 위치에서 눌러야 되는 n의 위치의 힘
				}
			}
			
			for(int j=0 ; j<5 ; j++) { // 오른발 위치
				for(int i=0 ; i<5 ; i++) { // 왼발 위치
					// 왼발 옮기기
					dp[s][n][j] = Math.min(dp[s-1][i][j] + mp[i][n], dp[s][n][j]);
				}
			}
			s++;
		}
		s--;
		
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i<5 ; i++) {
			for(int j=0 ; j<5 ; j++) {
				min = Math.min(min, dp[s][i][j]);
			}
		}
		System.out.println(min);
	}
}
