package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 1074 Z
문제 접근
- 배열을 사분면으로 나누고, 재귀함수로 count 계산

문제 풀이
- 주어진 것 : 한 변의 size, 타겟 위치 인덱스 r,c를 입력 받음
- 타켓 위치가 어느 사분면에 속하는지 확인하여 계산
-> 한 사분면의 크기를 전체 배열 크기의 4등분

생각해볼것
- 2,3,4사분면에 속하면 앞 사분면을 반드시 방문하는 count를 계산
-> 2사분면 : count += size * size / 4;
-> 3사분면 : count += (size * size / 4) * 2;
-> 4사분면 : count += (size * size / 4) * 3;

14280 KB , 100 ms

 */
public class bj1074 {
	static int size, r, c;
	static int count = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		size = (int)Math.pow(2, N); // 한 변의 길이
		find(size, r, c);
		
		System.out.print(count);
	}
	
	static void find(int size, int r, int c) {
		if(size == 1) return; // 더이상 확인해야할 size가 없으므로 해당 재귀 함수를 나간다.
		
		if(r < size/2 && c < size/2) { // 1사분면
			find(size/2, r, c);
		} else if(r < size/2 && c >= size/2) { // 2사분면
			count += size * size / 4; // 1사분면에 방문했던 횟수를 count에 추가한다. 
			find(size/2, r, c - size/2);
		} else if(r >= size/2 && c < size/2) { // 3사분면
			count += (size * size/4) * 2; // 1,2사분면에 방문했던 횟수를 count에 추가한다.
			find(size/2, r - size/2, c);
		} else { // 4사분면
			count += (size * size/4) * 3; // 1,2,3사분면에 방문했던 횟수를 count에 추가한다.
			find(size/2, r - size/2, c - size/2);
		}
		
	}
}
