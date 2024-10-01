package Beakjoon.gold;
import java.util.*;
import java.io.*;
public class bj13975 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0 ; i<T ; i++) {
			PriorityQueue<Long> que = new PriorityQueue<Long>();
			long N = Long.parseLong(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<N ; j++) {
				que.add(Long.parseLong(st.nextToken()));
			}
		
			long totalCost = 0;
			
			while(que.size() > 1) {
				long a = que.poll();
				long b = que.poll();
				long sum = a+b;
				totalCost += sum;
				que.add(sum);
			}
			
			sb.append(totalCost).append("\n");
		}
		
		System.out.print(sb);
	}
	

}
