package Baekjoon.sliver;
import java.util.*;
/**
 * 10828, 스택
 * 
 * Stack 대신 ArrayDeque를 사용하여 성능 개선
 * -> Stack은 Vector를 상속받음으로써 지속적으로 동기화를 제공하지만, 단일 스레드 환경에서는 불필요한 오버헤드 발생
 * -> 단일 스레드 환경과 비동기 처리할 경우, ArrayDeque를 사용
 * 
 * 19844 kb, 176 ms
 */
import java.io.*;
public class bj10828 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		ArrayDeque<Integer> stack = new ArrayDeque();
		for(int i=0 ; i<N ; i++) {
			String input = br.readLine();
		
			if(input.startsWith("push")) { // push 명령어 처리		
				int value = Integer.parseInt(input.split(" ")[1]);
				stack.push(value);
				
			} else if(input.equals("pop")) { // pop 명령어 처리	
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
				
			} else if(input.equals("size")) { // size 명령어 처리
				sb.append(stack.size()).append("\n");
				
			} else if(input.equals("empty")) {
				sb.append(stack.isEmpty() ? 1 : 0).append("\n");
				
			} else if(input.equals("top")) {
				if(stack.isEmpty()) {
					sb.append("-1").append("\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
			}
			
		}
		
		System.out.print(sb);
	}
}
