package Beakjoon.gold;
import java.util.*;
public class bj2493 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		Stack<pair> stack = new Stack<pair>();
		for(int i=1 ; i<=N ; i++) {
			int num = sc.nextInt();
			// 스택 체크
			while(!stack.isEmpty()) {
				if(stack.peek().num > num) {
					sb.append(stack.peek().index+" ");
					break;
				}
				stack.pop();
			}
			
			if(stack.isEmpty()) sb.append(0+" ");

			stack.add(new pair(i, num));
			
		}
		System.out.print(sb);
	}
	
	static class pair{
		int index;
		int num;
		pair(int index, int num) {
			this.index = index;
			this.num = num;
		}
	}
}
