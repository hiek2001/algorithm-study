package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj22252 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long sum = 0; // C가 100,000인 경우에 k가 30,000만 되어도 int 범위를 초과함
		HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int btn = Integer.parseInt(st.nextToken()); 
			String name = st.nextToken();
			int size = Integer.parseInt(st.nextToken());
			
			if(btn == 1) {	
				PriorityQueue<Integer> pq = map.getOrDefault(name, new PriorityQueue<>(Collections.reverseOrder()));
				
				for(int j=0 ; j<size ;j++) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
				map.put(name, pq);
			} else { // btn == 2
				if(map.containsKey(name)) {
					PriorityQueue<Integer> pq = map.get(name);
					
					int actualSize = Math.min(size, pq.size());
					for(int j=0 ; j<actualSize ; j++) { // 횟수만
						sum += pq.poll();
					}
				}
			}
		}
		System.out.print(sum);
	}
}
