package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 
 */
public class bj20291_2 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> map = new HashMap<>();		
		for(int i=0 ; i<N ; i++) {		
			int count = 0;
			String[] input = br.readLine().split("\\.");
			
			if(map.containsKey(input[1])) { // 동일한 확장자가 있으면
				count = map.get(input[1]);	// 해당 확장자의 count 값 가져오기		
			} 
			map.put(input[1], ++count); // 확장자에 맞춰 count 더해서 넣기
		}
		
		List<String> keySet = new ArrayList<>(map.keySet());

		// 확장자 기준으로 오름차순 정렬
		Collections.sort(keySet);
		
		for(String key : keySet) { // 출력
			 sb.append(key+" "+map.get(key)).append("\n");
		}		
		System.out.print(sb);
	}
	
}
