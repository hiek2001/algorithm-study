package Baekjoon.sliver;
import java.util.*;
import java.io.*;
// DP[100] = 약 20억 이상
// 이므로 int 타입 말고 long 타입 사용해야함
public class bj9461 {
	 public static void main(String[] args) throws Exception {
	        long[] DP = new long[101];
	        DP[1] = 1;
	        DP[2] = 1;
	        DP[3] = 1;
	        
	        int index = 4;
	        for(int i=2 ; i<99 ; i++) {
                DP[index++] = DP[i] + DP[i-1];
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        for(int i=0 ; i<N ; i++) {
	            int num = Integer.parseInt(br.readLine());
	            sb.append(DP[num]).append("\n");
	    }
	    System.out.print(sb);
	}
}
