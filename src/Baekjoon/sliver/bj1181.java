package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		HashSet<String> set = new HashSet<>();
		for(int i=0 ; i<N ; i++) {
			set.add(br.readLine());
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<String>() {
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) return o1.compareTo(o2);
				else return o1.length() - o2.length();
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(String str : list) {
			sb.append(str).append("\n");
		}
		System.out.print(sb);
		
	}
}
