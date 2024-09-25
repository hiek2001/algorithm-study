package Beakjoon.gold;
import java.util.*;
import java.io.*;
public class bj3190 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] board = new int[N+1][N+1];
		Arrays.fill(board, Integer.MIN_VALUE);
		
		int appleCount = Integer.parseInt(br.readLine());
		for(int i=0 ; i<appleCount ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			board[row][col] = 0; // 사과 표시
		}
		
		Queue<Spin> spin = new ArrayDeque<>();
		int moveCount = Integer.parseInt(br.readLine());
		for(int i=0 ; i<moveCount ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
			
			spin.offer(new Spin(time, dir));
		}
		
		// 북, 동, 남, 서
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int row = 1;
		int col = 1;
		int time = 0;
		int dir = 1;
		Queue<Node> que = new ArrayDeque<>();
		que.offer(new Node(row,col));
		board[row][col] = 2;
		
		// 보드 이동하며 확인
		while(true) {
			int dR = row + dr[dir];
			int dC = col + dc[dir];
			
			time++;
			
			if(dR<1 || dC<1 || dR>N || dC>N) {
				break;
			}
			if(board[dR][dC] == 2) {
				break;
			}
			
			if(board[dR][dC] == 0) {
				Node node = que.poll();
				board[node.row][node.col] = 0;
			}
			
			
			if(!spin.isEmpty()) {
				if(time == spin.peek().time) {
					Spin s = spin.poll();
					
					if (s.dir.equals("L"))
                        dir = dir-1 < 0 ? 3 : dir-1;
                    if (s.dir.equals("D"))
                        dir = dir+1 > 3 ? 0 : dir+1;
				}
			}
			
			board[dR][dC] = 2;
            que.offer(new Node(dR, dC));
            row = dR;
            col = dC;
		}
		System.out.print(time);
		
	}
	
	static class Spin{
		int time;
		String dir;
		Spin(int time, String dir) {
			this.time = time;
			this.dir = dir;
		}
	}
	
	static class Node{
		int row, col;
		Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
