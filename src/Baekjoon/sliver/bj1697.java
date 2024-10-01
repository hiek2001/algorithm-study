package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj1697 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int max = 100000;
		int[] visited = new int[max+1];
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.add(X);
		visited[X] = 1;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now == K) {
				System.out.println(visited[now] - 1);
				return;
			}
			
			int[] dirs = {now-1, now+1, now*2};
			
			for(int next : dirs) {
				if(next>=0 && next<=max && visited[next] == 0) {
					visited[next] = visited[now] + 1;
					que.add(next);
				}
			}
		}
		
	}
}
