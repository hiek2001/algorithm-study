package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj11728 {
	static int idx, a_idx, b_idx;
	static int N, M;
	static int result[], A[], B[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N];
		B = new int[M];
		result = new int[N+M];
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {           
            A[i] = Integer.parseInt(st.nextToken());
        }
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<M ; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
			
		char endCheck;
		a_idx = 0;
		b_idx = 0;
		idx = -1;
		while(true) {
			if(a_idx == N) {
				endCheck = 'B';
				break;
			}
			if(b_idx == M) {
				endCheck = 'A';
				break;
			}
			if(A[a_idx] < B[b_idx]) {
				result[++idx] = A[a_idx++];
			} else {
				result[++idx] = B[b_idx++];
			}
				
		}
		
		solve(endCheck);
		
		for(int num : result) {
			bw.write(num+" ");
		}
        bw.flush();
        bw.close();
		
		
	}
	private static void solve(char endCheck) {
		if(endCheck == 'A') {
			for(int i=a_idx ; i<N ; i++) {
				result[++idx] = A[i];
			}
		} else if(endCheck == 'B') {
			for(int i=b_idx ; i<M ; i++) {
				result[++idx] = B[i];
			}
		}
	}
}
