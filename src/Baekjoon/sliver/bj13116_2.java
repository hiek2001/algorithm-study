package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 13116, 30번
- 문제 분석 및 의사 결정
	- '공통으로 포함되는 꼭지점에 대응된 자연수 중 최대값' -> 최소 공통 조상 구하기
	- 최소 공통 조상 * 10 하기
- 코드 구현
	- a와 b의 노드가 다를 때 부모로 이동시키면서 레벨을 맞추기 위해 2로 나눔
	- 결과값 * 10 하여 출력
	
	34684 kb, 280 ms
 */
public class bj13116_2 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=0 ; i<T ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			while(a != b) {
                if(a > b) a /= 2;
                else  b /= 2;                   
	        }
			 
//			int min = Math.min(a, b);
//			if(min == a) {
//				// 큰 값과 작은 값의 노드 차이를 줄이기 위해 큰 값을 2로 나눔
//				while(true) {
//					if(b-a < a) break;
//					b /= 2;
//				}
//		
//			} else {
//				while(true) {
//					if(a-b < b) break;
//					a /= 2;
//				}
//			}
//			
//			while(a != b) {
//                if(a > b) {
//                    a /= 2;
//                    if(a == b) break;
//                    b /= 2;
//                } else {
//                     b /= 2;
//                    if(a == b) break;
//                    a /= 2;
//                }
//            }
			
			sb.append(a * 10).append("\n");
		}
		
		System.out.print(sb);
	}
}
