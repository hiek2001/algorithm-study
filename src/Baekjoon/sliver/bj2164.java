package Baekjoon.sliver;

import java.util.*;

public class bj2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1 ; i<=N ; i++)
			que.add(i);
		
		while(que.size()>1) {
			int now = que.peek();
			que.remove(now);
			que.add(que.poll());
		}
		System.out.println(que.poll());
	}
}
