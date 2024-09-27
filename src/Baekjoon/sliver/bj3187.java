package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 3187, 양치기 꿍
- 문제 분석
	- 주어진 울타리 안에 양과 늑대를 카운팅
	- 양의 수가 늑대 수보다 작거나 같으면 양 = 0
	- 양이 더 많으면 늑대 = 0

- 의사 결정
	- 울타리 영역을 어떻게 구분지어야 할까?
		- 울타리 안을 탐색하기 위해 방문하지 않았고, 현재 위치가 양이거나 늑대이면 BFS 탐색
	- 양과 늑대 수 비교
		- 양의 수가 더 적거나 같으면 양은 0 처리
		- 양이 더 많으면 늑대는 0 처리
	
- 코드 구현
	- 주어진 값 입력 받아 이중 배열에 저장
	- 방문하지 않았고, 양이나 늑대가 있으면 BFS 탐색 시작
		- BFS는 Queue를 사용해 현재 위치에서 상하좌우 인접한 칸을 탐색
		- 울타리가 있거나 이미 방문하면 제외하고, 빈 공간이나 양, 늑대가 있는 곳으로 확인하여 개수 카운트
	- BFS 탐색이 끝날 때마다 조건에 따라 양이나 늑대를 0으로 처리리
	- 울타리 내부에서 살아남은 양과 늑대의 총합을 출력
	
	18656 KB, 180 ms
 */
public class bj3187 {
	static char[][] arr;
	static int[] dx = {0, -1, 0, 1};
	static int[] dy = {1, 0, -1, 0};
	static boolean[][] visited;
	static int R, C;
	static int sheep, wolf;
	static int ans_sheep, ans_wolf = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		// 입력 받기
		arr = new char[R][C];
		for(int i=0 ; i<R ; i++) {
			String input = br.readLine();
			for(int j=0 ; j<C ; j++) {
				arr[i][j] = input.charAt(j);
			}
		}
		
		visited = new boolean[R][C]; // 울타리 방문 확인
		for(int i=0 ; i<R ; i++) {
			for(int j=0 ; j<C ; j++) {
				// 방문하지 않았고, 현재 좌표가 늑대거나 양일 경우
				if(!visited[i][j] &&(arr[i][j] == 'v' || arr[i][j] == 'k')) {
					// 울타리 내부를 들어갈 때마다 양과 늑대 수 초기화
					sheep = 0;
					wolf = 0;
					
					// 울타리 내부 확인
					BFS(i, j);
					
					// 양의 수가 늑대보다 적거나 같으면 양을 0 처리
					// 그렇지 않으면 늑대를 0 처리
					if(wolf >= sheep) sheep = 0;
					else wolf = 0;
					
					// 양과 늑대의 총 합계
					ans_sheep += sheep;
					ans_wolf += wolf;
				}
			}
		}
		
		System.out.print(ans_sheep+" "+ans_wolf);
	}
	
	static void BFS(int x, int y) {
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(x, y));
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(arr[now.x][now.y] == 'v') wolf++;
			else if(arr[now.x][now.y] == 'k') sheep++;
			
			for(int k=0 ; k<4 ; k++) {
				int mx = now.x + dx[k];
				int my = now.y + dy[k];
				
				// 울타리 내부이면서 방문하지 않았고, 현재 좌표가 울타리가 아니라면
				if(mx>=0 && my>=0 && mx<R && my<C && !visited[mx][my] && arr[mx][my] != '#') {
					visited[mx][my] = true;
					que.add(new Node(mx, my));
				}
			}
		}
		
	}
	
	static class Node{
		int x;
		int y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
