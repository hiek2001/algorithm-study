package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj1913 {
	static int arr[][];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		create();
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		
		sb.append(findNumber(num));
		System.out.print(sb);
	}
	
	public static String findNumber(int num) {
		String result = null;
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j] == num) {
					result=(i+1)+" "+(j+1);
				}
			}
		}
		return result;
	}
	
	public static void create() {
		int dx[] = {-1,0,1,0};
		int dy[] = {0,1,0,-1};
		
		int x = N/2;
		int y = N/2;
		
		int next = 0;
		int max = 1;
		int count = 0; // 같은 방향 이동 횟수
		int ls = 0; // 방향 전환 횟수
		for(int i=1 ; i<=7*7 ; i++) {
			arr[x][y] = i;
			
			x += dx[next%4];
			y += dy[next%4];
			count++;
			
			if(count == max) {
				next++;
				count = 0;
				ls++;
			}
			if(ls == 2) {
				max++;
				ls = 0;
			}
		}
	}
}
