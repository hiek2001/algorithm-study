package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj2847 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] score = new int[N];
		for(int i=0 ; i<N ; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}
		
		int count = 0;
		for(int i=N-1 ; i>0 ; i--) {
			for(int j=i-1 ; j<i ; j++) {
				if(score[j] >= score[i]) {
					count += score[j] - (score[i] - 1);
					score[j] = score[i] - 1;
				}
			}
		}
		
		System.out.print(count);
	}
}
