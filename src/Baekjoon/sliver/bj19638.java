package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 19638, 센티와 마법의 뿅망치
 * 
- 문제 분석
	- 거인의 키가 센티보다 크면 뿅망치로 절반씩 줄임
	- 이 과정을 최대 T번 반복 가능
	- 뿅망치를 다 쓰거나 거인 키가 모두 센티보다 작아지면 결과 출력
- 의사 결정
	- 거인 키가 큰 순서대로 절반씩 줄이기 위해 우선순위 큐 사용
- 코드 구현
	- 키가 가장 큰 거인이 센티보다 작거나 1인 경우
		- 다시 큐에 넣고 종료
		- 출력 : NO, 큐에서 값 꺼내기
	- 키가 가장 큰 거인이 센티보다 클 경우
		- 반으로 줄여서 다시 큐에 넣고, 사용 횟수 증가
		- 출력 : YES, 사용 횟수 출력
		
	28884 KB, 328 ms
 */
public class bj19638 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int centi = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
		for(int i=0 ; i<N ; i++) { // 거인 키 추가
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int usedCount = 0;
		while(!pq.isEmpty() && T > 0) {
			int tallest = pq.poll();
			
			if(tallest < centi ) {
				pq.add(tallest);
				break;
			}
			
			if(tallest == 1) { // 키가 1이면 더 이상 뿅망치로 줄일 수 없음
				pq.add(tallest);
				break;
			}
			
			tallest /= 2;
			pq.add(tallest);
			T--;
			usedCount++;
		}
		
		if(pq.peek() >= 10 || pq.peek() == 1) {
			sb.append("NO").append("\n");
			sb.append(pq.poll());
		} else {
			sb.append("YES").append("\n");
			sb.append(usedCount);
		}
		
		System.out.print(sb);
		
	}
}
