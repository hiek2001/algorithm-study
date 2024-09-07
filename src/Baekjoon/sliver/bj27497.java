package Baekjoon.sliver;
import java.util.*;
import java.io.*;

public class bj27497 {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		Stack<String> stack = new Stack<>(); // 가장 나중에 입력된 문자열 찾기 위한 stack
		Deque<String> deque = new LinkedList<>(); // 앞, 뒤 추가를 위한 deque
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int btn = Integer.parseInt(st.nextToken());
			String word = null;
			
			if(st.hasMoreTokens()) { // 뒤에 문자열이 있을 경우, 추가
				word = st.nextToken();
				stack.add(word);
			}
			
			if(btn == 1) {
				deque.add(word);
			} else if(btn == 2) {
				deque.addFirst(word);
			} else {
				if(!deque.isEmpty()) { 
					if(stack.pop() == deque.getFirst()) {
						deque.removeFirst();
					} else {
						deque.removeLast();
					}
				}
			}
		}
		
		// 출력
		if(deque.isEmpty()) {
			sb.append(0);
		} else {
			for(String s : deque) {
				sb.append(s);
			}
		}
		sb.append("\n");
		
		System.out.print(sb);
	}
}
