package Baekjoon.sliver;
import java.io.*;
import java.util.*;
public class bj11722 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] a = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] count = new int[N];
		for(int i=0 ; i<N ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
			count[i] = 1;
		}
		
		
		for(int i=1; i<N ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(a[i] < a[j]) {
					count[i] = Math.max(count[i], count[j]+1);
				}
				
			}

		}
		
		int max = 0;
		for(int num : count) {
			max = Math.max(max, num);
		}
		
		System.out.print(max);
	}
}
