package Beakjoon.gold;
import java.util.*;
import java.io.*;
// 문제 풀이 : https://ranny-devlog.tistory.com/entry/%EB%B0%B1%EC%A4%80-2660-%ED%9A%8C%EC%9E%A5%EB%BD%91%EA%B8%B0-JAVA-%ED%92%80%EC%9D%B4
public class bj2660 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int[][] dist = new int[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 51);
            dist[i][i] = 0;
        }
		
		StringTokenizer st;
		while(true) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(S == -1) break;
			
			dist[S][E] = 1;
			dist[E][S] = 1;
		}
		
		
		for(int k=1 ; k<=N ; k++) {
			for(int i=1 ; i<=N ; i++) {
				for(int j=1 ; j<=N ; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		int[] scores = new int[N+1];
		int minScore = 51;
		for(int i=1 ; i<=N ; i++) {
			int maxDist = 0;
			for(int j=1 ; j<=N ; j++) {
				if(dist[i][j] != 51) {
					maxDist = Math.max(maxDist, dist[i][j]);
				}
			}
			
			scores[i] = maxDist;
			minScore = Math.min(minScore, maxDist);
		}
		
		ArrayList<Integer> candidates = new ArrayList<>();
		for(int i=1 ; i<=N ; i++) {
			if(scores[i] == minScore) {
				candidates.add(i);		
			}
		}
		
		sb.append(minScore).append(" ").append(candidates.size()).append("\n");
		for(int candidate : candidates) {
			sb.append(candidate).append(" ");
		}
		
		System.out.print(sb);
	}
	
}
