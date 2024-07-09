package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj1935 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		char str[] = br.readLine().toCharArray(); // 알파벳, 사칙연산 입력 받기
		
		Stack<Double> stack = new Stack<Double>();
		int arr[] = new int[N];
		for(int i=0 ; i<N ; i++) {
			arr[i] = Integer.parseInt(br.readLine()); // 알파벳에 맞는 값 배열에 넣기
		}
		
		for(int i=0 ; i<str.length ; i++) {
			char ch = str[i];
			if(ch>='A' && ch<='Z') { // 알파벳일 경우, 해당 값을 stack에 넣기
				stack.push((double)arr[ch-'A']);
			} else { // 사칙연산일 경우, 두 개의 값을 꺼내 계산한 후 결과값 stack에 넣기
				double next = stack.pop();
				double now = stack.pop();
				next = calculation(now, next, ch);
				stack.push(next);
			}
		}
		
		String formattedResult = String.format("%.2f", stack.pop()); // 소수점 두번째까지
		System.out.println(formattedResult);
	}
	public static double calculation(double now, double next, char operator) {
		double result = 0;
		if(operator == '*') result = now * next;
		else if(operator == '+') result = now + next;
		else if(operator == '-') result = now - next;
		else if(operator == '/') result = now / next;
		return result;
	}
}
