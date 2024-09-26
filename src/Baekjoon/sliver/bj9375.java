package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 9375, 패션왕 신해빈
- 문제 분석
	- 해빈이가 의상을 종류별로 중복되지 않게 
	- 알몸이 아닌 상태로 의상을 착용할 수 있는 경우의 수 구하기
- 의사 결정
	- 의상의 종류가 겹치지 않게 경우의 수를 구해야되기 때문에 HashMap을 사용
	- HashMap(옷 종류, 갯수)를 저장
- 코드 구현
	- 의상 이름은 필요하지 않기 때문에 의상 종류만 StringTokenizer를 사용하여 저장
	- 해당 종류의 옷이 HashMap에 있을 경우, HashMap에 저장되어 있던 종류의 개수를 +1 증가
	- HashMap에 없을 경우, 해당 종류와 개수 1를 삽입
	- 안 입는 경우를 고려하여, 각 종류의 옷 개수에 +1 해준 값을 곱하기
		- [headgear] hat, turban, NULL 
		- [eyewear] sunglasses, NULL
		- NULL은 옷을 입지 않는 경우를 뜻함
	- 모든 종류를 입지 않은 상태(알몸)인 경우를 제외하기 위해 최종값에 -1를 함
	
	14248 KB, 96 ms
 */
public class bj9375 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<T ; i++) {
			HashMap<String, Integer> map = new HashMap<>(); // 옷 종류, 갯수 저장
			int N = Integer.parseInt(br.readLine());
			
			while(N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				st.nextToken(); // 옷 이름 사용 안함
				String kind = st.nextToken();
				
				if(map.containsKey(kind)) {
					map.put(kind, map.get(kind) + 1);
				} else {
					map.put(kind, 1);
				}
			}

			int cnt = 1;
			
			for(int val : map.values()) {
				cnt *= (val+1);
			}

			sb.append(cnt-1).append("\n");			
		}
		
		System.out.print(sb);
	}

}
