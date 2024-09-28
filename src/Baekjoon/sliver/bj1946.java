package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 1946, 신입 사원
- 문제 분석
	- 2개의 성적 중 1개의 성적이 다른 사람보다 잘함 -> 합격
	- 2개의 성적이 다른 사람의 성적에 비해 둘다 낮으면 ->  불합격
	- 순위로 입력되며, 동석차 없음
- 의사 결정
	- 동석차가 없는 상태에서는 1차(서류 등수) 순위에 1등은 1명
	- 이 기준으로 오름차순 정렬
	- 정렬을 한 상태에서 2차(면접 등수) 순위가 낮으면 채용, 높다면 탈락이기 때문에 그리디 알고리즘 사용
- 코드 구현
	- 신입사원의 수 만큼 이중 배열을 선언하여 입력되는 성적을 저장
	- Arrays.sort()를 사용해 1차 순위를 기준으로 오름차순 정렬
	- 1차의 1등은 반드시 한명이기 때문에 count를 1로 초기화
	- 1차의 1등 기준, 1등의 2차 순위 > 2등의 2차 순위 비교
		- 채용 횟수 증가
		- 비교 대상의 등수로 변경
 */
public class bj1946 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		int[][] A;
		
		for(int i=0 ; i<T ; i++) {
			int N = Integer.parseInt(br.readLine());		
			A = new int[N][2];  // 신입사원들의 성적 순위 저장
			
			for(int j=0 ; j<N ; j++) {
				String[] input = br.readLine().split(" ");
				
				A[j][0] = Integer.parseInt(input[0]);
				A[j][1] = Integer.parseInt(input[1]);	
			}
			
			// 1차 성적 순위를 기준으로 오름차순 정렬
			Arrays.sort(A, (x,y) -> Integer.compare(x[0], y[0])); 
			
			int count = 1; // 1등 한명은 반드시 있기 때문에, 1로 초기화 
			int diff = A[0][1];
			
			for(int j=1 ; j<N ; j++) { // 2등부터 탐색			
				if(diff > A[j][1]) { // 1등의 2차 순위와 2등의 2차 순위를 비교
					count++;
					diff = A[j][1];
				}
			}
			sb.append(count).append("\n");
		}
		System.out.print(sb);
	}
}
