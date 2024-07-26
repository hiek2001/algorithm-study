package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj12933 {
	static char arr[];
	static char quack[] = {'q','u','a','c','k'};
	static boolean visited[];
	static int count; // 오리 수
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = br.readLine().toCharArray();
		
		visited = new boolean[arr.length];
		count = 0;
		
		if(arr[0] != 'q' || arr.length%5 != 0) {
			System.out.print(-1);
			return;
		}
		
		// 미방문이면서 q일 경우, 오리 갯수 구하기
		for(int i=0 ; i<arr.length ; i++) {
			if(!visited[i] && arr[i] == 'q') { 
				solution(i);
			}
		}
		
		// 모두 방문했지만 개수가 없는 경우
		if(count == 0) {
			System.out.print(-1);
			return;
		}
		
		System.out.print(count);
	}
	
	public static void solution(int start) {
		int j = 0;
		boolean first = true;
		for(int i=start ; i<arr.length ; i++) {
//			j = j % quack.length;
			if(quack[j] == arr[i] && !visited[i]) {
				visited[i] = true;
//				j++;
				if(arr[i] == 'k') {
					if(first) {
						count++;
						first = false;
					}
					j = 0;
					continue;
				}
				j++;
			}
			
//			if(arr[i] == 'k') {
//				if(first) {
//					count++;
//					first = false;
//				} 
//				j = 0;
//			}
		}
	}
}
