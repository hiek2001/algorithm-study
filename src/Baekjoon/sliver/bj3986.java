package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 3986, 좋은 단어
 * 
 * 인덱스 0을 stack에 push한다.
 * 인덱스 1부터 str.length()까지 stack.peek()과 비교한다.
 * 
 * - stack.peek()과 string.charAt(index)이 같으면 stack.pop() 한다.
 * - stack이 비어있거나, 위 두개가 같지 않으면 stack에 push() 한다.
 * - 문자열의 인덱스 끝까지 했을 때 stack이 비어 있으면 count를 센다.
 * 
 * 22108 kb , 276 ms
 */
public class bj3986 {
	static int count = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<N ; i++) {
			String str = br.readLine();
			
			checkGoodWord(str);
		}
		System.out.print(count);
	}
	
	static void checkGoodWord(String str) {
		Stack<Character> stack = new Stack<>();
		int size = str.length();
		if(size%2 == 1) return;
		
		stack.push(str.charAt(0));
		
		for(int i=1 ; i<size ; i++) {
			if(stack.isEmpty() || (stack.peek() != str.charAt(i))) {
				stack.push(str.charAt(i));
			}else if(stack.peek() == str.charAt(i)) {
				stack.pop();
			} 
		}
		if(stack.isEmpty()) count++;
	}
}
