package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj17276 {
	static int arr[][], ans[][];
	static int n, d, count, m;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for(int k=0 ; k<testCase ; k++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			
			arr = new int[n+1][n+1];	
			ans = new int[n+1][n+1];	
			// 데이터 입력 받기
			for(int i=1 ; i<=n ; i++) { 
				st = new StringTokenizer(br.readLine());
				for(int j=1 ; j<=n ; j++) {				
					int num = Integer.parseInt(st.nextToken());
					arr[i][j] = num;
					ans[i][j] = num;
				}
			}
			
			m = (n+1)/2;
			count = Math.abs(d) / 45;
			if(d > 0) { // 양수 : 시계 방향	
				while(count > 0) {
					clockWiseDirection();
					copyArray(arr, ans);
					count--;
				}				
			} else if(d < 0) { // 음수 : 반시계 방향
				while(count > 0) {
					counterClockWiseDirection();
					copyArray(arr, ans);
					count--;
				}
			} 
			
			for(int i=1 ; i<=n ; i++) {
				for(int j=1 ; j<=n ; j++) {
					sb.append(ans[i][j]).append(" ");
				}
				sb.append("\n");
			}
			
			System.out.print(sb);
		}
	}
	
	// 배열 복사
	public static void copyArray(int[][] dest, int[][] src) {
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=n ; j++) {
				dest[i][j] = src[i][j];
			}
		}
	}
	
	// 반시계 방향
	public static void counterClockWiseDirection() {
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=n ; j++) {
				if(i == j) {
					ans[m][j] = arr[i][j];
				}
				
				if(m == j) {
					ans[i][i] = arr[i][j];
					ans[i][j] = arr[i][n-i+1];
					ans[n-i+1][i] = arr[j][i];
				}
				
			}
		}
	}
	
	// 시계 방향
	public static void clockWiseDirection() {
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=n ; j++) {
				if(i == j) {
					ans[i][m] = arr[i][j];
				}
				
				if(m == j) {
					ans[i][n-i+1] = arr[i][j];
					ans[j][n-i+1] = arr[i][n-i+1];
				}
				
				if(m == i) {
					ans[j][j] = arr[i][j];
				}
				
			}
		}
	}
}
