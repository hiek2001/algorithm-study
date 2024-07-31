package Beakjoon.gold;
import java.util.*;
import java.io.*;
public class bj16719 {
	static char input[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input = br.readLine().toCharArray();
	
		visited = new boolean[input.length];
		zoac(0, input.length-1);
		
		br.close();
		System.out.print(sb.toString());
	}
	
	public static void zoac(int start, int end) {
		if(start > end) return;
		
		int index = start;
		for(int i=start ; i<=end ; i++) { // start ~ end에서 사전 순서로 가장 낮은 알파벳을 찾기 (index)
			if(input[index] > input[i]) {
				index = i;
			}
		}
		
		visited[index] = true;
		
		for(int i=0 ; i<input.length ; i++) {
			if(visited[i]) {
				sb.append(input[i]);
			}
		}
		sb.append("\n");
		
		zoac(index+1, end);
		zoac(start, index-1);
	}
}
