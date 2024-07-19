package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj15787 {
	static boolean train[][];
	//static int seatCheck[];
	static int count, N;
	static Set<String> seatCheck;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		train = new boolean[N+1][21]; 
		for(int i=1 ; i<=M ; i++) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int trainNum = Integer.parseInt(st.nextToken());
			int seatNum = 0;
			if(st.hasMoreTokens()) {
				seatNum = Integer.parseInt(st.nextToken());
			}		
			
			orderCheck(order, trainNum, seatNum);
		}
		
		seatCheck = new HashSet<>();
		fullSeatCheck();
		
		System.out.print(seatCheck.size());
		
	}
	
	public static void fullSeatCheck() {
		for(int i=1 ; i<=N ; i++) {			
			StringBuilder sb = new StringBuilder();
			for(int j=1 ; j<21 ; j++) {
				if(train[i][j]) {
					sb.append("1");
				} else {
					sb.append("0");
				}
				
			}
			seatCheck.add(sb.toString());
		}
	}
	
	public static void orderCheck(int order, int trainNum, int seatNum) {
		if(order == 1) {	
			if(train[trainNum][seatNum] == false) {
				train[trainNum][seatNum] = true;
			}
			
		} else if(order == 2) {
			if(train[trainNum][seatNum] == true) {
				train[trainNum][seatNum] = false;
			}
			
		} else if(order == 3) {
			for(int j=20 ; j>1 ; j--) {
				train[trainNum][j] = train[trainNum][j-1];
			}
			train[trainNum][1] = false; // 가장 오른쪽 자리는 비워줘야함

		} else if(order == 4) {
			for(int j=1 ; j<20 ; j++) {
				train[trainNum][j] = train[trainNum][j+1];
			}
			train[trainNum][20] = false; // 가장 왼쪽 자리는 비워줘야 함
		}
	}
}
