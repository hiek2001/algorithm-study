package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * KeyPoint : HashMap 자료구조를 사용하여 count를 세고, List로 전환하여 조건에 맞춰 정렬한다.
 * 
 * 입력되는 값을 key로 저장하여 해당 값에 맞춰 count를 센다.
 * HashMap을 List로 전환하고, 람다식으로 조건에 맞춰 정렬한다.
 * 
 * 14200 kb, 104 ms
 */
public class bj1302 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0 ; i<N ; i++) {
			String str = br.readLine();
			
			int count = 0;
			if(map.containsKey(str)) {
				count = map.get(str);
			}
			map.put(str, ++count);
		}
		
		// Map.Entry를 List로 변환
		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
		
		// value 내림차순 -> key 오름차순 정렬
		entryList.sort((x, y) -> {
			int valueCompare = y.getValue().compareTo(x.getValue());
			if(valueCompare != 0) return valueCompare;
			return x.getKey().compareTo(y.getKey()); // value가 같으면 key 기준 오름차순 정렬					
		});
		
		System.out.print(entryList.get(0).getKey());
	}

}
