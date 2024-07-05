package Beakjoon.gold;
import java.io.*;
import java.util.*;
public class bj2470 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int A[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {			
			A[i] = Integer.parseInt(st.nextToken());
		}
			
		Arrays.sort(A);
		
		int start = 0;
		int end = N-1;
		int min = 2000000001;
		int bestStart = 0, bestEnd = 0;
		while(start<end) {
			int gap = plusOrMinus(A[start], A[end]); 
			if(Math.abs(gap) < min) {
				min = Math.abs(gap);
				bestStart = A[start];
				bestEnd = A[end];
			}
//			min = Math.min(min, Math.abs(gap));
			if(gap > 0) end--;
			else if(gap < 0) start++;
			else {
				bestStart = A[start];
				bestEnd = A[end];
				break;
			}
		}
		bw.write(bestStart+" "+bestEnd);
		bw.flush();
		bw.close();
	}
	
	public static int plusOrMinus(int start, int end) {
		int result = 0;
		
		// 절대값의 수 swap
		if(Math.abs(start) < Math.abs(end)) {
			int temp = end;
			end = start;
			start = temp;
		}
		
		// 마이너스인 숫자 판별
		if((start>0 && end>0) || (start<0 && end<0) || end==0) {
			result = start - end;
		} else if(start<0 || end<0) {
			result = start + end;
		} 
		
		return result;
	}
}
