package Beakjoon.gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class bj14719 {
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		input = new int[W];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<W ; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] leftMax = new int[W];
		int[] rightMax = new int[W];
		
		leftMax[0] = input[0];
		for(int i=1 ; i<W ; i++) {
			leftMax[i] = Math.max(leftMax[i-1], input[i]);
		}
		
		rightMax[W - 1] = input[W - 1];
		for(int i=W-2 ; i>=0 ; i--) {
			rightMax[i] = Math.max(rightMax[i+1], input[i]);
			
		}
		
		int ans = 0;
		for(int i=0 ; i<W ; i++) {
			int minHeight = Math.min(leftMax[i], rightMax[i]);
			if(minHeight > input[i]) {
				ans += minHeight - input[i];
			}
		}
		System.out.print(ans);
	}
}
