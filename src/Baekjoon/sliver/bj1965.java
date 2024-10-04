package Baekjoon.sliver;
import java.util.*;
import java.io.*;
// 문제 분석 : https://ranny-devlog.tistory.com/13
public class bj1965 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<N+1 ; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] count = new int[N+1]; // 상자 크기 별로 한번에 넣을 수 있는 개수 저장
		count[0] = 0;
		for(int i=1 ; i<N+1 ; i++) { // 기준 상자
			for(int j=0 ; j<i ; j++) { // 비교 대상 상자
				
				if(a[j] < a[i] && count[j] >= count[i]) 
					count[i] = count[j] + 1;
			}
		}
		
		int max = -1;
		for(int num : count) {
			max = Math.max(num, max);
		}
		
		System.out.print(max);
	}
}
