package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 임의의 수 n을 a0 + x0 + a0 형식으로 표현하는 방식은 n/2 가지
 * a0 + x0 + a0의 재귀적 팰린드롬 개수는 D(a0)
 * D(n) = D(n-1), n이 홀수일 경우
 * D(n) = D(n-1) + D(n/2), n이 짝수일 경우
 * 
 * 점화식 도출 이해하는데 참고한 블로그 : https://hipopatamus.tistory.com/145
 */
public class bj2705 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int arr[] = new int[1001];
		solve(arr);
		
		for(int i=0 ; i<t ; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(arr[N]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void solve(int[] arr) {
		arr[1] = 1; // 1일때 갯수는 1개.
		
		for(int i=2 ; i<arr.length ; i++) {
			if(i%2 == 0) { // 짝수
				arr[i] = arr[i-1] + arr[i/2];
			} else { // 홀수
				arr[i] = arr[i-1];
			}
		}
	}
}
