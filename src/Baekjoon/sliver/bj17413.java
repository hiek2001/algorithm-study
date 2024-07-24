package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj17413 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		char arr[] = line.toCharArray();
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		boolean tagCheck = false;
		
		for(char c : arr) { // 간결하게 작성한 버전
			if(c == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				tagCheck = true;
				sb.append(c);
			} else if(c == '>') {
				tagCheck = false;
				sb.append(c);
			} else if(tagCheck) {
				sb.append(c);
			} else if(c == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(c);
			} else {
				stack.push(c);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		
		System.out.print(sb);
		
		// 가장 처음 작성한 버전
//		for(int i=0 ; i<arr.length ; i++) {
//			char str = arr[i];
//
//			if((str >= 'a' && str <= 'z') || (str >= '0' && str <= '9')) {
//				stack.add(str);
//				if(stack.size() > 0 && tagCheck) // 태그 안에 있는 내용일 경우
//					sb.append(stack.pop());
//			} else if(str == ' ') {
//				while(!stack.isEmpty()) {
//					sb.append(stack.pop());
//				}
//				sb.append(" ");
//			} else if(str == '<') {
//				if(i > 0) {
//					if((arr[i-1] >= 'a' && arr[i-1] <= 'z') || (arr[i-1] >= '0' && arr[i-1] <= '9')) {
//						while(!stack.isEmpty()) {
//							sb.append(stack.pop());
//						}
//					}
//				}
//				stack.add(str);
//				sb.append(stack.pop());
//				tagCheck = true;
//			} else if(str == '>') {
//				stack.add(str);
//				sb.append(stack.pop());
//				tagCheck = false;
//			}
//		}
//		while(!stack.isEmpty()) { // 문장이 끝난 후에도 stack에 남아있으면 실행
//			sb.append(stack.pop());
//		}
//	
//		System.out.print(sb);
	}
}
