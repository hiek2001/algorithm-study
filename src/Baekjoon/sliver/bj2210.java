package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 2210, 숫자판 점프
- 문제 분석
	- 숫자판에서 인접해있는 4방향으로 5번 이동하여
	- 6자리 수를 만들어 서로 다른 수의 개수 구하기
	
- 의사 결정
	- dx, dy의 방향 배열을 만들어서 인접한 4방향으로 움직이기
	- 6자리 숫자로 만들기 위해서는 시작한 좌표에서 연속적으로 움직여야하기 때문에 재귀 함수를 사용
	- 6자리 숫자들이 서로 중복 되지 않고 저장되어야 하기 때문에 HashSet에 저장
	
- 코드 구현
	- 각 좌표에서 DFS 탐색하여 6자리 숫자 생성
		- 숫자판 범위가 넘지 않은 상태에서 방향 배열을 사용해 인접한 방향으로 이동하며 6자리 숫자를 만듬
		- 재귀가 끝나면 마지막에 추가한 문자를 제거하여 다른 경로를 탐색함
		- 6자리 숫자가 완성되면 HashSet에 추가
	- 출력
		- HashSet의 사이즈를 출력
		
	15628 kb, 120 ms
 */
public class bj2210 {
	static int N = 5; // 숫자판 크기
	static int[][] arr;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static int cnt = 0;
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		arr = new int[N][N];
		
		// 숫자판 만들기
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 각 좌표에서 6자리 숫자 만들기
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				// 초기 cnt = 0, 현재 숫자를 포함한 문자열로 시작
				DFS(i, j, cnt, new StringBuilder(String.valueOf(arr[i][j])));
			}
		}
		
		System.out.print(set.size());
	}
	
	static void DFS(int x, int y, int cnt, StringBuilder sb) {
		if(cnt == 5) {
			set.add(sb.toString());
			return;
		}
		
		for(int k=0 ; k<4 ; k++) {
			int mx = x + dx[k];
			int my = y + dy[k];
			
			if(mx>=0 && my>=0 && mx<N && my<N) {
				sb.append(arr[mx][my]);
				
				DFS(mx, my, cnt+1, sb);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		
	}
}
