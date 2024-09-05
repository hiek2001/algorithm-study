package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/**
 * 2차열 배열을 입력 받는다.
 * 이동할 위치를 입력 받는다.
 * 이중 for문을 사용하여 이동할 거리를 계산한다.
 */
public class bj2167 {
	static int arr[][];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][M+1]; // 0 제외하고 1부터 사용
		
		for(int i=1 ; i<=N ; i++) { // 2차열 배열 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int j=1 ; j<=M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 이동할 위치 입력 받기
		int K = Integer.parseInt(br.readLine());
		for(int i=0 ; i<K ; i++) {
			 st = new StringTokenizer(br.readLine());
			 int a = Integer.parseInt(st.nextToken());
			 int b = Integer.parseInt(st.nextToken());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 int ans = calculation(a,b,x,y);
			 sb.append(ans).append("\n");
		}
		
		System.out.print(sb);
	}
	
	// (a,b) -> (x,y) 이동 거리 계산
	static int calculation(int a, int b, int x, int y) {
		int total = 0;
		for(int i=a ; i<=x ; i++) {
			for(int j=b ; j<=y ; j++) {
				total += arr[i][j];
			}
		}
		return total;
	}
}
