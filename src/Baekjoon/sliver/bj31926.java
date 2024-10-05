package Baekjoon.sliver;
import java.util.Scanner;
public class bj31926 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int time = 8;
		
		for(int i=1 ; ; i++) {
			// daldidalgo가 2의 배수면 daldidan 만드는데 2초 소모
			// daldian -> 복사, n -> 입력 : 2초 소모
			if(N - Math.pow(2, i) == 0) { 
				time = time + i + 2;
				break;
			} // daldidalgo가 2의 배수가 아니면, daldidan 만드는데 1초 소모
			 // daldidalgo daldida -> 복사(이건 daldidalgo 만드는 시간 소요로 침)
			 // n -> 입력 : 1초 소모
			else if(N - Math.pow(2, i) < 0) { 
				time = time + i + 1;
				break;
			}
		}
		
		System.out.print(time);
	}
}
