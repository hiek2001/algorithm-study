package Beakjoon.gold;
import java.util.*;
import java.io.*;
// 문제 분석 : https://ranny-devlog.tistory.com/14
public class bj2631 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] a = new int[N];
        int[] count = new int[N];	
		for(int i=0 ; i<N ; i++) {
			a[i] = Integer.parseInt(br.readLine());
            count[i] = 1;
		}
		
		int max = 1;
		for(int i=1 ; i<N ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(a[i] > a[j]) {
					count[i] = Math.max(count[i], count[j]+1);
				}
			}
			max = Math.max(max, count[i]);
		}
		
		System.out.print(N-max);
	}
}
