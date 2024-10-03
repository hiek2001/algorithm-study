package Baekjoon.sliver;
import java.util.*;
public class bj2108 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] a = new int[N];
		for(int i=0 ; i<N ; i++) {
			a[i] = sc.nextInt();
		}
		
		// 합 구하기
		HashMap<Integer, Integer> map = new HashMap<>();
		double sum = 0;
		for(int num : a) {
			sum += num;
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		sb.append((int)Math.round((double) sum/N)).append("\n");
		
		// 중앙값 구하기
		Arrays.sort(a);
		sb.append(a[N/2]).append("\n");
		
		// 최빈값 구하기
		int max = 0;
		for(int num : map.values()) {
			max = Math.max(max, num);
		}
		
		List<Integer> modeList = new ArrayList<>();
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue() == max) {
				modeList.add(entry.getKey());
			}
		}
		
		Collections.sort(modeList);
		if(modeList.size() > 1) sb.append(modeList.get(1)).append("\n");
		else sb.append(modeList.get(0)).append("\n");
		
		// 범위 구하기
		sb.append(a[N-1]-a[0]);
		
		sb.append("\n");
		System.out.print(sb);
		
	}
	
	
}
