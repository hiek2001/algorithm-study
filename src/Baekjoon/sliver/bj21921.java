package Baekjoon.sliver;
import java.util.Scanner;
public class bj21921 {
	public static void main(String[] args) { // 슬라이드 윈도우 사용
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int X = sc.nextInt();
		int visitor[] = new int[N+1];
		for(int i=0 ; i<N ; i++) 
			visitor[i] = sc.nextInt();
		
		int sum = 0;
		int max = 0;
		int count = 0;
		for(int i=0 ; i<N ; i++) {
			sum += visitor[i];
			
			if(i == X-1) {
				max = sum;
				count++;
			}
			if(i > X-1) {
				sum -= visitor[i-X];
				if(sum > max) {
					max = sum;
					count = 1;
				} else if(sum == max) {
					count++;
				}
			}
		}
		
		if(max == 0) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(count);
		}
	}
	
}
