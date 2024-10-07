package Beakjoon.gold;

import java.io.*;
import java.util.*;

/*
 * 0 1 bfs 사용하여 다시 풀었음
 * 
 * 기존 16112 kb, 123 ms
 * 개선 14280 kb, 108 ms
 */
public class bj2665_2 {
	 static int[][] map;
	 static int[][] dist;
	 static int N;
	 
	 static class Node{
	        int x, y;
	        Node(int x, int y) {
	            this.x = x;
	            this.y = y;
	        }
	    }
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());
	        
	        map = new int[N][N]; // 미로 저장
	        dist = new int[N][N]; // 검은 방을 몇개 지나왔는지를 저장하는 배열
	        
	        for(int i=0 ; i<N ; i++) {
	            String str = br.readLine();
	            for(int j=0 ; j<N ; j++) {
	                map[i][j] = str.charAt(j) - '0'; // 숫자로 비교하는게 더 쉬워서 '0' 빼줌
	                dist[i][j] = Integer.MAX_VALUE; // 무한대로 초기화
	            }
	        }
	        
	        bfs(0,0);
	        
	        System.out.print(dist[N-1][N-1]);
	}
	
	static void bfs(int start, int end) {
		int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        Deque<Node> que = new ArrayDeque<Node>();
        que.add(new Node(start, end));
        dist[start][end] = 0; // 시작하는 곳은 0으로 초기화
        
        while(!que.isEmpty()) { // queue의 값이 없어질 때까지
            Node now = que.poll();
            int x = now.x;
            int y = now.y;
            
            for(int i=0 ; i<4 ; i++) { // 동,서,남,북 이동하면서 검은방인지 흰방인지 확인
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx > N-1 || ny > N-1) continue; // 미로 배열 안에서만 탐색
                
             // 흰 방(1)은 가중치가 0, 검은 방(0)은 가중치가 1
                if(dist[nx][ny] > dist[x][y] + (map[nx][ny] == 0 ? 1 : 0)) {
                	dist[nx][ny] = dist[x][y] + (map[nx][ny] == 0 ? 1 : 0);
                
                	if(map[nx][ny] == 1) que.addFirst(new Node(nx, ny));
                    else que.addLast(new Node(nx, ny)); 
                }
            }
        }
        
	}
}
