package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 19788 KB , 200 ms
 */
public class bj4779 {
	public static void main(String[] args) throws Exception{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0 ; i<4 ; i++) {
			int N = Integer.parseInt(br.readLine());
			
			// 길이가 3^N인 칸토어 집합 생성
			int length = (int) Math.pow(3,  N);
			char[] arr = new char[length];
			Arrays.fill(arr, '-');
			
			// 칸토어 집합을 재귀적으로 처리
			cantor(arr, 0 ,length);
			
			// 결과 출력
			System.out.println(new String(arr));
		}	
	}
	
	static void cantor(char[] arr, int start, int length) {
		// 더 이상 나눌 부분이 없으면 종료
		if(length == 1) {
			return;
		}
		
		// 중간 1/3 부분을 공백으로 채우기
		int size = length / 3;
		for(int i=start+size ; i<start+2*size ; i++) {
			arr[i] = ' ';
		}
		
		// 나머지 부분 재귀적으로 처리
		cantor(arr, start, size); // 왼쪽 1/3
		cantor(arr, start+2*size, size); // 오른쪽 1/3
	}

}
