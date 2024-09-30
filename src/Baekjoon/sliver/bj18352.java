package Baekjoon.sliver;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 18352 , 특정 거리의 도시 찾기
 * 
- 문제 분석
	- 특정한 도시 X부터 출발하여 도달할 수 있는 모든 도시 중
	- 최단 거리가 정확히 K인 모든 도시들의 번호 출력
	- 최단 거리가 K인 도시가 하나도 없으면 -1 출력
- 코드 구현
	- 이동하는 도시의 정보를 ArrayList 배열에 저장
		- 단방향 (출발 도시 -> 도착 도시)
			- 출발 도시를 배열 index에 저장
			- 도착 도시를 List의 값으로 저장
	- 최단 거리를 저장할 배열 dist 선언
	- 출발 도시를 시작으로 다른 도시를 번호 순서대로 지나가면서 최단 거리 도출 -> 너비 우선 탐색 사용
		- 처음 시작하는 도시 번호를 Queue에 삽입한 후 방문 배열에 true 저장
		- while문으로 Queue에 도시 번호가 없을 때까지 반복
		- 출발 도시 번호를 Queue에서 꺼내면
			- for문은 현재 도시(now)와 연결된 모든 인접 도시(next)를 차례대로 확인
			- if문을 통해 해당 도시에 방문한 적 있는지 확인하고
			- 만약 방문하지 않은 도시라면, 그 도시에 방문했다고 표시
			- 현재 도시까지 최단 거리에 1을 더한 값을 해당 도시까지의 거리로 dist에 기록
			- 그 다음 도시(next)를 Queue에 추가하여 탐색을 진행
			
	- for문을 사용해서 dist 배열에 출발 도시 기준으로 최단 거리가 있는지 확인
		- 있으면 도시 번호 출력
		- 없으면 -1 출력
		
	2735288 kb, 1076 ms
 */
public class bj18352 {
	static int N, M;
	static ArrayList<Integer> A[];
	static boolean visited[];
	static int count = 0;
	static int[] dist;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시 개수
		M = Integer.parseInt(st.nextToken()); // 도로 개수
		int K = Integer.parseInt(st.nextToken()); // 거리 정보
		int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		
		// 인접 리스트에 그래프 정보 저장
		visited = new boolean[N+1];
		A = new ArrayList[N+1];
		for(int i=0 ; i<N+1 ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());
			
			A[c1].add(c2);
		}
		
		dist = new int[N+1]; // 최단 거리 저장할 배열
		
		bfs(X);
		
		boolean found = false;
		for(int i=1 ; i<=N ; i++) {
			if(dist[i] == K) {
				sb.append(i).append("\n");
				found = true;
			}
		}
		
		if(!found) sb.append("-1");
		
		System.out.print(sb);
	}
	
	static void bfs(int start) {
		Queue<Integer> que = new ArrayDeque<>();
		
		que.add(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int next : A[now]) {
				if(!visited[next]) {
					visited[next] = true;
					dist[next] = dist[now] + 1;
					que.add(next);
				}
			}
		}
	}
}
