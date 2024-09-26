package Beakjoon.gold;
import java.util.*;
import java.io.*;
public class bj3190 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		
		int cnt = Integer.parseInt(br.readLine());
		for(int i=0 ; i<cnt ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			map[row][col] = 1; // 사과 위치 표시
		}
		
		int num = Integer.parseInt(br.readLine());
		Queue<Spin> spin = new ArrayDeque<>();
		for(int i=0 ; i<num ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			spin.add(new Spin(time, dir)); // 시간, 방향 저장
		}
		
		// 처음에는 (1,1)에서 시작하고, 동쪽을 보고 시작
		int time = 0;
		int col = 1;
		int row = 1;
		int dir = 1;
		
		// 0: 북, 1: 동, 2: 남, 3: 서
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		Queue<Node> que = new ArrayDeque<>();
		que.add(new Node(row, col));
		map[row][col] = 2; // 뱀의 자리
		
		while(true) {
			int dR = row + dr[dir];
			int dC = col + dc[dir];
			
			time++;
			
			if(dR<1 || dC<1 || dR>N || dR>N) break;
			
			if(map[dR][dC] == 2) break;
			
			if(map[dR][dC] == 0) { // 사과를 먹지 않았을경우
				Node now = que.poll(); // 뱀의 꼬리 부분 공간 만들기
				map[now.row][now.col] = 0;
			}
			
			map[dR][dC] = 2;
			que.add(new Node(dR, dC));
			
			if(!spin.isEmpty() && time == spin.peek().time) {
				Spin s = spin.poll();
				
				if(s.dir.equals("L")) { // 왼쪽 회전
					if(dir-1 < 0) dir = 3;
					else dir = dir-1;
				} else if(s.dir.equals("D")) { // 오른쪽 회전
					if(dir+1 > 3) dir = 0;
					else dir = dir+1;
				}
					
				
			}
			
			
			row = dR;
			col = dC;
			
		}
		
		System.out.print(time);
		
	}
	
	static class Node{
		int row;
		int col;
		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	static class Spin{
		int time;
		String dir;
		Spin(int time, String dir) {
			this.time = time;
			this.dir = dir;
		}
	}
}
