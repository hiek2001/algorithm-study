package Baekjoon.sliver;
import java.util.*;
/**
 * 1966, 프린터 큐
 * 
 * Queue에는 문서의 인덱스와 중요도를 저장
 * PriorityQueue는 중요도를 내림차순으로 저장
 * Queue에서 문서를 하나씩 꺼내서 그 문서의 중요도가 PriorityQueue 최상단과 일치하는지 비교
 *  
 * 16380 kb, 144 ms
 */
import java.io.*;
public class bj1966 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for(int i=0 ; i<testCase ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int checkNum = Integer.parseInt(st.nextToken()); 
			
			Queue<Textbook> que = new LinkedList<Textbook>();
			PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder()); 
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
