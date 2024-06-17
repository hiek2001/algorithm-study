package Baekjoon.sliver;
import java.util.Scanner;
public class bj10844 {
	static int mod = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int D[][] = new int[N+1][10];
		for(int i=1; i<=9 ; i++) {
			D[1][i] = 1;
		}
		
		for(int i=2 ; i<=N ; i++) {
			D[i][0] = D[i-1][1];
			D[i][9] = D[i-1][8];
			for(int j=1 ; i<=8 ; j++) {
				D[i][j] = (D[i-1][j+1] + D[i-1][j-1]) % mod; //오버 플로우 방지
			}
		}
				
		int sum = 0;
		for(int i=0 ; i<=9 ; i++) {
			sum += (D[N][i]) % mod; //오버플로우 방지, 정확성 보장
		}
		
		System.out.println(sum);
		
	}
}
