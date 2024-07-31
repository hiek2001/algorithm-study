package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj20207 {
	static int arr[] = new int[366];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int maxEnd = 0;
		for(int i=0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			check(start, end);
			maxEnd = Math.max(end, maxEnd);
		}
		
		int height = 0;
		int length = 0;
		int result = 0;
		for(int i=1 ; i<=maxEnd ; i++) {
			height = Math.max(arr[i], height);
			if(arr[i] != 0) length++;
			else { // 일 수 중간에 0이 나오는 경우
				result += height * length;
				height = 0;
				length = 0;
			}
		}
		
		// 모든 일 수가 색칠되어 있을 경우
		// 0을 만나지 않고 일 수가 끝난 경우
		if(height != 0) result += height * length;
		
		System.out.print(result);
		
	}
	
	public static void check(int start, int end) {
		for(int i=start; i<=end ; i++) {
			arr[i]++;
		}
	}
}
