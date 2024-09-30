package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 50720 KB, 248 ms
 */
public class bj7562 {
	static int map[][];
	static boolean visited[][];
	static int startX, startY, endX, endY;
	static int N;
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0 ; i<T ; i++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			String[] input = br.readLine().split(" ");
			startX = Integer.parseInt(input[0]);
			startY = Integer.parseInt(input[1]);
			
			input = br.readLine().split(" ");
			endX = Integer.parseInt(input[0]);
			endY = Integer.parseInt(input[1]);
		
			visited = new boolean[N][N];
			sb.append(bfs()).append("\n");
		}
		
		System.out.print(sb);
	}
	
	static int bfs() {
		Queue<Node> que = new ArrayDeque<Node>();
		que.add(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		int[][] dirs = {{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			if(now.x == endX && now.y == endY) return now.length;
			
			for(int[] dir : dirs) {
				int nx = now.x + dir[0];
				int ny = now.y + dir[1];
				
				if(nx < 0 || nx >= N) continue;
				if(ny < 0 || ny >= N) continue;
				
				if(!visited[nx][ny]) {
					que.add(new Node(nx, ny, now.length + 1));
					visited[nx][ny] = true;
				}
			}
			
		}
		return -1;
	}
	
	static class Node{
		int x, y, length;
		Node(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
}
