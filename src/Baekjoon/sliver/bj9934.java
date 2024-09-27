package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj9934 {
	static int k;
	static ArrayList<Integer> arr[];
	static String[] input;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());
		
		input = br.readLine().split(" ");
		
		arr = new ArrayList[input.length];
		for(int i=0 ; i<input.length ; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		search(0, input.length-1, 0);
		
		for(int i=0 ; i<k ; i++) {
			for(int num : arr[i]) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);

	}
	
	static void search(int start, int end, int depth) {
		if(depth == k) return;
		
		int mid = (start+end)/2;
		
		arr[depth].add(Integer.parseInt(input[mid]));
		
		// 왼쪽 노드
		search(start, mid-1 , depth+1);
		
		// 오른쪽 노드
		search(mid+1, end, depth+1);
	}
}
