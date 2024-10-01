package Beakjoon.gold;
import java.util.*;
import java.io.*;
public class bj1240 {
	static boolean[] visited;
	static int[] weight;
	static ArrayList<Integer> A[];
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		A = new ArrayList[N+1];
		for(int i=0 ; i<N+1 ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		weight = new int[N+1];
		for(int i=1 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			A[S].add(E);
			weight[S] = Integer.parseInt(st.nextToken());
			A[E].add(S);
			
		}
		
		for(int i=0 ; i<M ; i++) {
			visited = new boolean[N+1];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(bfs(a,b)).append("\n");
		}
		
		System.out.print(sb);
		
	}
	
	static int bfs(int s, int e) {
		Queue<Integer> que = new ArrayDeque<Integer>();
		int sum = 0;
		
		que.add(s);
		visited[s] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int next : A[now]) {
				if(!visited[next]) {
					que.add(next);
					visited[next] = true;
					sum += weight[next];
					if(next == e) return sum;
				}
			}
		}
		return sum;
	}
}
