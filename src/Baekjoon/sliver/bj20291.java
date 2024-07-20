package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj20291 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
			
		Map<String, Extension> extMap = new HashMap<>();
		for(int i=0 ; i<N ; i++) {
			String arr[] = br.readLine().split("\\.");			
			String extension = arr[1];
			
			if(extMap.containsKey(extension)) {
				extMap.get(extension).count++;
			} else {
				Extension newExt = new Extension(extension, 1);
				extMap.put(extension, newExt);
			}	
		}
		
		List<Extension> extList = new ArrayList<>(extMap.values());
		extList.sort(Comparator.comparing(e -> e.name));
		
		StringBuilder sb = new StringBuilder();
		for(Extension e : extList) {
			sb.append(e.name).append(" ").append(e.count).append("\n");
		}
		
		System.out.print(sb);
	}

	
	static class Extension{
		String name;
		int count;
		Extension(String name, int count) {
			this.name = name;
			this.count = count;
		}
		
	}
}
