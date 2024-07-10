package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj1966 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for(int i=0 ; i<testCase ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int checkNum = Integer.parseInt(st.nextToken()); // 말 이해가 어려웠음. 기존 checkNum 자리가 몇번째로 출력되는지
			
			Queue<Textbook> que = new LinkedList<Textbook>();
			PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder()); // max로 비교할 경우, 중요도가 같을때 비교 못함. 우선순위 que 사용하기
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) { // 중요도 입력 받기	
				int weight = Integer.parseInt(st.nextToken());
				que.add(new Textbook(j, weight)); 
				pQue.add(weight); // 내림차순 queue 사용하여 중요도 자동 정렬
			}
			
			int printCount = 0;
			while(!que.isEmpty()) {
				Textbook now = que.poll();
				if(now.weight == pQue.peek()) { // que의 중요도와 우선순위 que의 중요도와 같으면 인쇄
					pQue.poll();				
					printCount++;				
					if(now.index == checkNum) { 
						break;
					}
				} else {
					que.add(now);
				}
			}
			sb.append(printCount+"\n");
			
		}
		System.out.print(sb);
	}
	
	
	static class Textbook {
		int index;
		int weight;
		Textbook(int index, int weight) {
			this.index = index;
			this.weight = weight;
		}
	}
}
