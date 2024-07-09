package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj2346 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<A> deque = new ArrayDeque<A>();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1 ; i<=N ; i++) {
			int value = Integer.parseInt(st.nextToken());
			deque.add(new A(i,value));
		}
		
		// 1번 풍선 터트리기
		A now = deque.pollFirst();
		sb.append(now.index+" ");
		A next = null;
		int moveValue = now.value;
		while(!deque.isEmpty()) {
			// 양수일 경우, 인덱스 큰 쪽으로
			if(moveValue > 0) {
				// 앞에 있는 요소를 모두 뒤로 보내기
				for(int i=1 ; i<moveValue ; i++) {
					deque.addLast(deque.pollFirst());
				}
				
				next = deque.pollFirst();
			}
			// 음수일 경우, 인덱스 작은 쪽으로
			else {
				// 뒤에 있는 요소 모두 앞으로 보내기
				for(int i=1 ; i<-moveValue ; i++) {
					deque.addFirst(deque.pollLast());
				}	
				next = deque.pollLast();
			}
			moveValue = next.value;
			sb.append(next.index+" ");
		}
		System.out.println(sb);
	}
	
	public static class A{
		int index;
		int value;
		A(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
}
