package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 1026, 보물
 * 
 * 14216 kb, 100 ms
 */
public class bj1026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Integer[] A = new Integer[N];
		Integer[] B = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		
		int result = 0;
		for(int i=0 ; i<N ; i++) {
			result += A[i] * B[i];
		}
		
		System.out.print(result);
		
	}
}
