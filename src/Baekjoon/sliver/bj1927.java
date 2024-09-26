package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 1927, 최소 힙
 * 
 * 1. 문제 분석 
	- 최소 힙 = 오름차순 정렬
	- 0이면 배열의 가장 작은 값 출력, 그 값을 배열에서 제거
	- 비어있는 경우, 0 출력
  2. 의사결정
	- 내부적으로 힙 자료구조를 사용하며, 자동 정렬해주는 우선순위 큐 사용
	- 우선순위 큐 최소의 시간복잡도 O(log N) < 배열 최악의 시간복잡도 O(N) 
  3.코드 구현
	- 명령이 0일 때
		- 우선순위 큐가 비어있으면 0 출력
		- 비어있지 않으면 큐에서 값 꺼내기
	- 명령이 0이 아닐 때
		- 우선순위 큐에 주어진 값 삽입
	- StringBuilder로 최종 출력
	
	26120 kb, 268 ms
 */
public class bj1927 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>();
		for(int i=0 ; i<N ; i++) {
			int input = Integer.parseInt(br.readLine());
			
			if(input == 0) {
				if(que.isEmpty()) sb.append(0);
				else sb.append(que.poll());
				sb.append("\n");
			} else {
				que.add(input);
			}
		}
		
		System.out.print(sb);
	}
}
