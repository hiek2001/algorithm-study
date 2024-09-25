package Beakjoon.gold;
import java.util.*;
/*
 * 1158, 요세푸스 문제
 * 
 * 297356 kb, 668 ms
 */
public class bj1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt(); // 사람 수
		int K = sc.nextInt(); // k번째 사람을 제거
		
		// Queue add : 1부터 N까지 숫자를 queue에 추가
		Queue<Integer> que = new LinkedList<Integer>();
		for(int i=1 ; i<=N ; i++)
			que.add(i); 
		
		int num = 0;
		sb.append("<");
		while(!que.isEmpty()) {
			num++; // 순서를 나타내는 카운터 증가
			if(num%K != 0) { // k번째가 아닌 경우
				// k번째가 아니면 큐에서 꺼낸 후 다시 큐의 끝에 삽입(사람들이 원형으로 이동)
				que.add(que.poll());
			} else { // k번째 사람인 경우
				sb.append(que.poll()); // 해당 사람을 큐에서 제거하고 출력에 추가
				if(que.size() == 0) sb.append(">");
				else sb.append(", ");
			}
		}
		System.out.print(sb);
	}
}

