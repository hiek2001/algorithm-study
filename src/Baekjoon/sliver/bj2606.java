package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj2606 {
	static ArrayList<Integer> A[];
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		A = new ArrayList[N+1];
		for(int i=0 ; i<=N ; i++) {
			A[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer st;
		for(int i=0 ; i<M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			A[a].add(b);
			A[b].add(a);
		}
		
		visited = new boolean[N+1];
		visited[0] = true;
		System.out.print(bfs(1));
	}
	
	static int bfs(int start) {
		int count = 0;
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.add(start);
		visited[start] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int next : A[now]) {
				if(!visited[next]) {
					visited[next] = true;
					que.add(next);
					count++;
				}
			}
		}
		return count;
	}
}
