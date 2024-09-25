package Baekjoon.sliver;
import java.io.*;
import java.util.*;
/**
 * 1406, 에디터
 * 
 * 입력받은 문자열을 deque에 삽입
 * 
 * L : deque 맨 뒤 꺼내서 임시 stack에 삽입
 * P : 함께 입력받는 문자열을 deque 맨 뒤에 추가
 * D : 임시 stack의 문자열 꺼내서 deque 맨 뒤 추가
 * B : deque 맨 뒤 문자열 버리기
 *
 * 177512 kb , 640 ms
 */
public class bj1406 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		Deque<Character> deque = new LinkedList<>();
		for(int i=0 ; i<str.length() ; i++) { // 문자열을 deque에 add
			deque.add(str.charAt(i));
		}
		
		int N = Integer.parseInt(br.readLine());
		
		Stack<Character> temp = new Stack<>(); 
		for(int i=0 ; i<N ; i++) {
			String[] input = br.readLine().split(" ");
			
			if(input[0].equals("L")) {
				if(deque.size() > 0) {
					temp.add(deque.pollLast());
				}	
			} else if(input[0].equals("P")) {
				deque.add(input[1].charAt(0));
			} else if(input[0].equals("D")) {
				if(temp.size() > 0) {
					deque.add(temp.pop());
				}
			} else if(input[0].equals("B")){
				if(deque.size() > 0) {
					deque.pollLast();
				}
			}
		}
		
		// stack, temp에 남은 문자 모두 출력
		StringBuilder sb = new StringBuilder();
		while(deque.size() > 0) {
			sb.append(deque.pollFirst());
		}
		while(temp.size() > 0) {
			sb.append(temp.pop());
		}
		
		System.out.print(sb);
	}
	
}
