package Beakjoon.gold;
import java.util.*;
import java.io.*;
public class bj1240 {
	static boolean[] visited;
	static ArrayList<ArrayList<Node>> A = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=0 ; i<=N ; i++) {
			A.add(new ArrayList<>());
		}
		
		for(int i=0 ; i<N-1 ; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			A.get(S).add(new Node(E, W));	
			A.get(E).add(new Node(S, W));
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
		Queue<Node> que = new ArrayDeque<Node>();
		
		que.add(new Node(s, 0));
		visited[s] = true;
		
		while(!que.isEmpty()) {
			Node current = que.poll();
			int now = current.end;
			int weight = current.weight;
			
			if(now == e) return weight;
			
			for(Node next : A.get(now)) {
				if(!visited[next.end]) {
					que.add(new Node(next.end, weight + next.weight));
					visited[next.end] = true;
				}
			}
		}
		return -1;
	}
	
	static class Node{
		int end, weight;
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}
}
