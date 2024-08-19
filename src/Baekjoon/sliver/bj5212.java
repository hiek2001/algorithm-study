package Baekjoon.sliver;
import java.util.*;

import Baekjoon.sliver.bj5212.Location;

import java.io.*;
public class bj5212 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int R = Integer.parseInt(str[0]);
		int C = Integer.parseInt(str[1]);
		
		// map 입력 받기
		// 육지면 stack에 위치 추가
		Stack<Location> stack = new Stack<Location>();
		char[][] map = new char [R][C];
		for(int i=0 ; i<R ; i++) {
			String input = br.readLine();
			for(int j=0 ; j<C ; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == 'X') {
					stack.push(new Location(i, j));
				}
			}
		}
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		int minX = R, maxX = 0, minY = C, maxY = 0;
		
		while(!stack.isEmpty()) {
			Location now = (Location) stack.pop();
			int x = now.x;
			int y = now.y;
			int seaCount = 0;
			for(int k=0 ; k<4 ; k++) {
				int mx = x + dx[k];
				int my = y + dy[k];
				if(mx>=0 && my>=0 && mx<R && my<C) { // 지도 안
					if(map[mx][my] == '.') { // 근처가 바다일 경우
						seaCount++;
					}
				} else { // 지도 바깥부분도 바다
					seaCount++;
				}
			}
			if(seaCount >= 3) { // 이 땅은 가라앉음
				map[x][y] = 'S';
			} else { // 유효한 땅이므로 최대, 최소 경계 갱신
				minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i=minX ; i<=maxX ; i++) {
			for(int j=minY ; j<=maxY ; j++) {
				if(map[i][j] == 'S') { // 가라앉은 땅은 바다로 출력
					sb.append('.');
				} else {
					sb.append(map[i][j]);
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
		
	}
	
	static class Location{
		int x;
		int y;
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
