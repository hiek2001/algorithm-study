package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * KeyPoint : 괄호 안 - 바로 꺼내기 / 괄호 밖 - 공백이나 문장이 끝나면 Stack에 있는 모든 값 꺼내기
 * 
 * 현재 인덱스가 숫자일 경우, Stack에 값을 add 한다.
 * 괄호 안에 있는 알파벳일 경우, Stack에 값을 add 한다. 괄호 밖 알파벳이면 Stack 값을 바로 꺼낸다.
 * 괄호 밖 공백일 경우, Stack의 모든 값을 꺼낸다.
 * 현재 인덱스가 괄호일 경우, Stack에 있는 모든 값을 꺼낸다.
 * 모든 과정이 끝난 후에 Stack에 남아있는 값이 있다면 모두 꺼낸다.
 * 
 * 23208 kb, 204ms
 */
public class bj17413_2 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		
		Stack<Character> stack = new Stack<>();
		boolean open = false; // 괄호 안에 있는지 확인하기위한 것
		
		for(int i=0 ; i<arr.length ; i++) {
			if((arr[i] - '0') >= 0 && (arr[i] - '0') <= 9) { // 숫자 0 ~ 9 확인
				stack.add(arr[i]);
			} else if(arr[i] >= 'a' && arr[i] <= 'z') { // a ~ z
				stack.add(arr[i]);
				
				if(open) sb.append(stack.pop()); // '<' 안에 있는 알파벳일 경우, 값 꺼내기
			} else if(arr[i] == ' ') { // 공백
				if(!open) { // 괄호 밖
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				}
				
				sb.append(' ');
			} else if(arr[i] == '<') { // '<' 시작
				open = true;
				
				while(!stack.isEmpty()) { // '>' 와 '<' 사이에 있는 알파벳 꺼내기
					sb.append(stack.pop());
				}
				
				sb.append(arr[i]);
			} else if(arr[i] == '>') { // '>' 끝
				open = false;
				
				sb.append(arr[i]);
			}
			
		}
		
		// stack에 값이 남아있을 경우
		while(!stack.isEmpty()) { 
			sb.append(stack.pop());
		}
		
		System.out.print(sb);
	}
}
