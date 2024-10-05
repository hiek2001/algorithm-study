package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj13417 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			int N = Integer.parseInt(br.readLine());
			
			
			st = new StringTokenizer(br.readLine());	
			char[] arr = new char[N];
			for(int j=0 ; j<N ; j++) {
				arr[j] = st.nextToken().charAt(0);
			}
			
			Deque<Character> deque = new ArrayDeque<Character>();
			deque.add(arr[0]);
			for(int k=1 ; k<N ; k++) {
				if(deque.peekFirst() >= arr[k]) {
					deque.addFirst(arr[k]);
				} else {
					deque.addLast(arr[k]);
				}
			}
			
			while(!deque.isEmpty()) {
				sb.append(deque.pollFirst());
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
}
