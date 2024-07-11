package Beakjoon.gold;
import java.util.*;
public class bj2504 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char D[] = str.toCharArray();
		
		int result = 0;
		int temp = 1;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0 ; i<D.length ; i++) {
			if(D[i] == '(') {
				stack.add(D[i]);
				temp *= 2;
			} else if(D[i] == '[') {
				stack.add(D[i]);
				temp *= 3;
			} else if(D[i] == ')') {
				if(stack.isEmpty() || stack.peek() != '(') {
					result = 0;
					break;
				}
				if(D[i-1] == '(') {
					result += temp;
				} 
				stack.pop();
				temp /= 2;
			} else if(D[i] == ']') {
				if(stack.isEmpty() || stack.peek() != '[') {
					result = 0;
					break;
				}
				if(D[i-1] == '[') {
					result += temp;
				}
				stack.pop();
				temp /= 3;
			}
		}
		if(!stack.isEmpty()) result = 0;
		System.out.println(result);	
			
			
			// 종속 관계와 결합 관계 구분 필수. 아래 코드는 그 구분을 못함.
//			if(D[i] == '(' || D[i] == '[') {
//				stack.push(D[i]);
//			} else if(D[i] == ')') {
//				if(stack.peek() == '(') {
//					stack.pop();
//					if(D[i-1] == '(') result = result + 2;	
//					else if(D[i-1] == ']' || D[i-1] == ')') result = result * 2;
//				} else {
//					result = 0;
//					break;
//				}
//				
//			} else if(D[i] == ']') {
//				if(stack.peek() == '[') {
//					stack.pop();
//					if(D[i-1] == '[') result = result + 3;
//					else if(D[i-1] == ']' || D[i-1] == ')') result = result * 3;
//				} else {
//					result = 0;
//					break;
//				}
//			}
		
	}		
}
