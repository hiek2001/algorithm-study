package Beakjoon.gold;
import java.util.*;
import java.io.*;
/*
 * 7569, 토마토
- 문제 분석
	- 익은 토마토를 기준으로 상하좌우앞뒤 토마토가 후숙됨
	- 대각선은 영향 X
	- 몇일이 지나야 토마토가 모두 익을지, 최소 일수 구하기
	- 1 : 익은 토마토 / 0: 익지 않은 토마토 / -1 : 토마토가 자리에 없음
		- 출력 
			- 모두 있으면 0, 모두 익지 X -1, 최소 몇일 소요?
- 의사 결정
	- 익은 토마토를 기준으로 상하좌우앞뒤 토마토를 모두 후숙시키며 전파 -> 너비 우선 탐색 사용
	- 상하좌우앞뒤를 모두 확인하는 6방향 탐색
- 코드 구현
	- 초기 토마토 상자 상태를 저장
		- 삼중 배열에 토마토 상태 저장
		- 익은 토마토이면 Queue에 삽입
		- 익지 않은 토마토이면 익지 않은 토마토 개수 증가
	- 익지 않은 토마토 개수가 0이면 0을 바로 출력
	- 토마토 상태 탐색 시작
		-  탐색을 시작하기 전 날짜를 0으로 만들기 위해 -1로 초기화
		- 익은 토마토들은 모두 큐에 추가된 상태
		- 같은 날에 처리해야되기 때문에 현재 큐에 있는 토마토들의 개수를 계산하여 for문을 통해 하나씩 처리
			- 주변 상하좌우앞뒤 방향의 토마토 상태를 확인
				- 해당 토마토가 상자 안에 있고
				- 익지 않은 토마토(0)가 있다면 익은 상태로 변경(1)
				- 익은 토마토를 큐에 추가
		- 모든 토마토를 탐색한 후, 남아있는 익지 않은 토마토가 있는지 확인
			- 익지 않은 토마토가 있다면 -1을 출력
			- 모든 토마토가 익었다면 소요된 날짜를 출력
	
	100088 kb, 604 ms
 */
public class bj7569 {
	static int M, N, H;
	static int tomato[][][];
	static int dx[] = {-1,1,0,0,0,0}; // 위, 아래, 좌, 우, 앞, 뒤
	static int dy[] = {0,0,-1,1,0,0};
	static int dz[] = {0,0,0,0,-1,1};
	static Queue<Node> que = new ArrayDeque<Node>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // 가로 칸 수
		N = Integer.parseInt(st.nextToken()); // 세로 칸 수
		H = Integer.parseInt(st.nextToken()); // 상자 수
		
		// 익지 않은 토마토 개수
		int unripeCount = 0;
		
		// 초기 토마토 상자 상태 저장
		tomato = new int[H][N][M];
		for(int h=0 ; h<H ; h++) {
			for(int n=0 ; n<N ; n++) {
				st = new StringTokenizer(br.readLine());
				
				for(int m=0 ; m<M ; m++) {
					tomato[h][n][m] = Integer.parseInt(st.nextToken());
					
					if(tomato[h][n][m] == 1) {
						que.add(new Node(h, n, m));
					}
					
					if(tomato[h][n][m] == 0) unripeCount++;
				}
			}
		}
		
		// 토마토 모두 익음 -> 0 출력
		if(unripeCount == 0) {
			System.out.print(0);
			return;
		}
		
		System.out.println(bfs());
		
	}
	
	static int bfs() {
		int days = -1;
		
		// 큐가 비어있지 않을 동안 탐색
		while(!que.isEmpty()) {
			int size = que.size();
			days++; // 하루 경과
			
			// 현재 큐에 있는 모든 노드 탐색
			for(int s=0 ; s<size ; s++) {
				Node now = que.poll();
			
				// 6방향 탐색
				for(int i=0 ; i<6 ; i++) {
					int nz = now.h + dz[i];
					int nx = now.n + dx[i];
					int ny = now.m + dy[i];
					
					// 상자 경계를 넘지 않도록 확인
					if(nx < 0 || nx >= N) continue;
					if(ny < 0 || ny >= M) continue;
					if(nz < 0 || nz >= H) continue;
					
					// 아직 익지 않은 토마토기 있으면 익게 하고 큐에 추가
					if(tomato[nz][nx][ny] == 0) {
						tomato[nz][nx][ny] = 1;
						que.add(new Node(nz, nx, ny));
					}
				}
			}
		}
		
		// 남아있는 익지 않은 토마토가 있는지 확인
		for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                	if(tomato[i][j][k] == 0) return -1; // 익지 않은 토마토가 남아있으면 -1 출력
                }
            }
		}
		
		return days; // 모든 토마토가 익었을 때는 날짜 출력
	}
	
	
	static class Node{
		int h, n, m;
		Node(int h, int n, int m) {
			this.h = h;
			this.n = n;
			this.m = m;
		}
	}
}
