package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj1244 {
	static int arr[];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N+1];
		for(int i=1 ; i<=N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int student = Integer.parseInt(br.readLine());
		for(int i=0 ; i<student ; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			if(gender == 1) {
				boyFunction(Integer.parseInt(st.nextToken()));
			} else if(gender == 2) {
				girlFunction(Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i=1 ; i<=N ; i++) {
			System.out.print(arr[i]+" ");
			if(i%20 == 0) System.out.println();
		}
		
	}
	
	public static void boyFunction(int num) {
		for(int i=1 ; i<=N ; i++) {
			if(i%num == 0) { // 숫자의 배수만 스위치 변경
				if(arr[i] == 0) arr[i] = 1;
				else arr[i] = 0;
			}
		}
	}
	
	public static void girlFunction(int num) {
		int s_index = num-1;
		int e_index = num+1;
		
		// 시작, 끝 인덱스의 마지노선 설정
		while(s_index > 0 && e_index < N+1) {
			if(arr[s_index] == arr[e_index]) { // 중심 기준으로 양쪽이 같은지 확인
				if(arr[s_index] == 1) {
					arr[s_index] = 0;
					arr[e_index] = 0;
				} else {
					arr[s_index] = 1;
					arr[e_index] = 1;
				}
				s_index--;
				e_index++;
			} else { // 같지 않으면 반복문 나오기
				break;
			}
		}
		
		// 해당 숫자만 스위치 변경
		if(arr[num] == 1) arr[num] = 0;
		else arr[num] = 1;
	}
}
