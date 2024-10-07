package Beakjoon.gold;
import java.util.*;
import java.io.*;
/*
 * 플로어드 워샬 알고리즘 사용
 * - 모든 학생 쌍 간의 비교 가능 여부 파악 해야 함
 * - 직접 연결되지 않은 노드들도 간접적인 경로를 파악할 수 있음
 * 
 * 다익스트라 알고리즘의 경우에는 단일 시작점에서 모든 다른 정점까지의 최단 경로를 구하는 것임
 */
public class bj2458 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[N+1][N+1];
	
		for(int i=1 ; i<=N ; i++) {
			Arrays.fill(dist[i], 503); // 무한대로 초기화
			dist[i][i] = 0;
		}
		
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			dist[S][E] = 1; // 단방향 간선
		}
		
		
		// 플로어드 워샬 알고리즘 사용
		for(int k=1 ; k<=N ; k++) {
			for(int i=1 ; i<=N ; i++) {
				for(int j=1 ; j<=N ; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int[] count = new int[N+1];
		for(int i=1 ; i<=N ; i++) {
			for(int j=1 ; j<=N ; j++) {
				if(i == j) continue; // 자기자신을 제외
				
				if(dist[i][j] < 503) { // 초기값보다 작으면 출발 노드와 도착 노드의 횟수 1 증가
					count[i]++;
					count[j]++;
				}
			}
		}
		
		int ans = 0;
		for(int i=1 ; i<=N ; i++) { // 자기 자신 제외한 모든 노드와 연결된 노드 찾기
			if(count[i] == N-1) ans++;
		}
		
		System.out.print(ans);
	}
}
