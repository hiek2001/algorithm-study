package Baekjoon.sliver;
import java.io.*;
import java.util.*;
public class bj18870 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 좌표 입력 받기
		int[] origin = new int[N]; // 원본 배열
		int[] sorted = new int[N]; // 정렬할 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
		}
		
		// 오름차순 정렬
		Arrays.sort(sorted);
		
		HashMap<Integer, Integer> rankingMap = new HashMap<>();
		int rank = 0;
		for(int num : sorted) { // 정렬된 배열을 map에 추가하면서 순위를 매김
			if(!rankingMap.containsKey(num)) {
				rankingMap.put(num, rank);
				rank++;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int key : origin) { // 원본 배열을 순회하면서 map에 있는 key에 대한 value를 가져와 저장
			int ranking = rankingMap.get(key);
			sb.append(ranking).append(" ");
		}
		System.out.print(sb);
	}
}
