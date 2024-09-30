package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 14156 KB, 96 ms
 */
public class bj17198 {
	static int[][] map;
	static boolean[][] visited;
	static int startX, endX, startY, endY;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[10][10];
		
		for(int i=0 ; i<10 ; i++) {
			String input = br.readLine();
			for(int j=0 ; j<10 ; j++) {
				map[i][j] = input.charAt(j);
				
				if(map[i][j] == 'B') {
					startX = i;
					startY = j;
				}else if(map[i][j] == 'L') {
					endX = i;
					endY = j;
				}
			}
		}
		
		visited = new boolean[10][10];
		System.out.print(bfs()-1);
	}
	
	static int bfs() {
		Queue<Node> que = new ArrayDeque<Node>();
		
		que.add(new Node(startX, startY, 0));
		visited[startX][startY] = true;
		
		int dirs[][] = {{-1,0},{1,0},{0,-1},{0,1}};
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			if(now.x == endX && now.y == endY) return now.length;
			
			for(int[] dir : dirs) {
				int nx = now.x + dir[0];
				int ny = now.y + dir[1];
				
				if(nx < 0 || nx >= 10) continue;
				if(ny < 0 || ny >= 10) continue;
				
				if(!visited[nx][ny] && map[nx][ny] != 'R') {
					que.add(new Node(nx, ny, now.length+1));
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
