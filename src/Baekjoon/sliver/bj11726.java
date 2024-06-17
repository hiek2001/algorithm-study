package Baekjoon.sliver;
import java.util.Scanner;
public class bj11726 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int D[] = new int[N+1];
		D[1] = 1;
		D[2] = 2;
		for(int i=3 ; i<=N ; i++) {
			D[i] = (D[i-1]+D[i-2]) % 10007;
		}
		
		System.out.println(D[N]);
		// 결과값에 10007를 나눠주게되면 for문에서 계산할때 오버플로우가 발생할 확률이 높아짐
	}
}
