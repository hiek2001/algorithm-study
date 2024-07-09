package Baekjoon.sliver;
import java.util.*;
public class bj1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// Queue add
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1 ; i<=N ; i++)
			que.add(i);
		
		//
		int num = 0;
		sb.append("<");
		while(!que.isEmpty()) {
			num++;
			if(num%K != 0) {
				que.add(que.poll());
			} else {
				sb.append(que.poll());
				if(que.size() == 0) sb.append(">");
				else sb.append(", ");
			}
		}
		System.out.print(sb);
	}
}
