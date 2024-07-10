package Baekjoon.sliver;
import java.util.*;
public class bj10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		char D[] = str.toCharArray();		
		int laserLocation[] = new int[D.length/2];
//		Stack<Integer> stack = new Stack<>();
		Stack<Character> stack = new Stack<>();
		int index = -1;
		int resultCount = 0;
//		for(int i=0 ; i<D.length ; i++) {
//			if(D[i] == '(') {
//				stack.push(i);
//			} else if(D[i] == ')'){
//				if(D[i-1] != '(') {
//					int start = stack.pop();
//					int end = i;
//					int laserCount = 0;
//					for(int num : laserLocation) { // 시간 초과의 원인. 레이저를 만났을 때 즉시 막대기의 개수 세기
//						if(start<num && end>num) 
//							laserCount++;
//					}
//					resultCount += laserCount + 1;
//				} else {
//					laserLocation[++index] = i;
//					stack.pop();
//				}
//			}
//		}
		
		for(int i=0 ; i<D.length ; i++) {
			if(D[i] == '(') {
				stack.push(D[i]);
			} else if(D[i] == ')') {
				stack.pop();
				if(D[i-1] != ')') { // () 레이저를 의미
					resultCount += stack.size();
				} else { // ) 막대기 닫힘을 의미
					resultCount += 1;
				}
			}
		}
		System.out.print(resultCount);
		
	}
}
