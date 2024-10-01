package Beakjoon.gold;
import java.util.*;
import java.io.*;
public class bj1863 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		Stack<Integer> stack = new Stack<Integer>();
		
		int count = 0;
		stack.add(0);
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			st.nextToken(); // x좌표 필요없음
			int now = Integer.parseInt(st.nextToken()); // y좌표

			while(!stack.isEmpty() && stack.peek() > now) {
				stack.pop();
				count++;
			}
			
			if(stack.peek() < now) {
				stack.add(now);
			}			
		}
		
		while(!stack.isEmpty() && stack.peek() > 0) {
			stack.pop();
			count++;
		}
		
		
		System.out.print(count);
	}
}
