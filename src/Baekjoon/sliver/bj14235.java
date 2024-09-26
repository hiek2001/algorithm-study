package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 14235, 크리스마스 선물
- 문제 분석
	- 아이들 만나면 산타가 들고 있는 선물 중 가치가 가장 큰 것을 줌
- 의사 결정
	- 값이 삽입될 때마다 자동으로 내림차순 정렬해주는 우선순위 큐 사용
- 코드 구현
	- 0 이외에 숫자는 공백으로 구분되어 입력되기 때문에, StringTokenizer.hasMoreTokens() 메소드를 사용해 입력된 문자열에 남은 숫자가 있는지 확인함
	- 0 일 경우
		- input 배열에서 1부터 입력 받은 선물 갯수까지 우선순위 큐에 삽입
	 - 0이 아닐 경우
		 - 우선순위 큐에 값이 없으면 -1을 출력
		 - 값이 있으면 꺼내면서 출력

	39240 KB, 352 ms
 */
public class bj14235 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
		int[] input = new int[101];
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int index=0;
			while(st.hasMoreTokens()) {
				input[index++] = Integer.parseInt(st.nextToken());
			}
			
			if(input[0] != 0) { // 거점에서 선물 충전
				for(int j=1 ; j<index ; j++) {
					que.add(input[j]);
				}
			} else { // 아이들에게 선물 나눠줌
				// 산타가 선물이 없으면 -1 출력
				// 산타가 선물이 있으면 우선순위 큐에서 선물 꺼내기
				sb.append(que.isEmpty() ? -1 : que.poll()).append("\n");		
			}
		}
		
		System.out.print(sb);
	}
}
