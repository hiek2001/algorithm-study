package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 4949, 균형잡힌 세상
 * 
 * input에서 .을 만나면 입력이 종료된다.
 * 
 * - 열린 괄호 [, (를 만나면 stack에 값을 추가한다.
 * - 닫힌 괄호 ) 를 만났을 때 stack이 비어있지 않는 경우
 *  -> stack.peek()가 열린 괄호 (가 아니면 반복문을 나간다.
 *  -> stack의 값을 제거한다.
 * - 닫힌 괄호 )를 만났을 때 stack이 비어있는 경우
 *  -> stack에 값을 추가한다.
 *
 * 닫힌 괄호 ]를 만났을 경우도 동일하다.
 * 
 * - stack의 값이 없을 경우에는 yes를, 값이 남아있을 경우에는 no를 출력한다.
 * 
 * 19152 kb, 176 ms
 */
public class bj4949 {
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = br.readLine();
			if(input.equals(".")) break;
			
			Stack<Character> stack = new Stack<>();
			for(int j=0 ; j<input.length() ; j++) {
				char c = input.charAt(j);
				
				if(c == '[' || c == '(') { 
					stack.add(c); 
				} else if(c == ')') { 
					if(!stack.isEmpty()) { 
						if(stack.peek() != '(') { 
							break;
						}
						stack.pop();
					} else {
						stack.add(c);
					}
				} else if(c == ']') {
					if(!stack.isEmpty()) {
						if(stack.peek() != '[') {
							break;
						}
						stack.pop();
					} else {
						stack.add(c);
					}
				} 
			}
			
			if(stack.isEmpty()) {
				sb.append("yes");
			} else {
				sb.append("no");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
