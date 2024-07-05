package Beakjoon.gold;
import java.util.Scanner;
public class bj1644 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int A[] = new int[N+1];
		int arrIndex = 0;
		for(int i=0 ; i<=N ; i++) {
			if(Prime(i)!=0) {
				A[arrIndex++] = i;
			}
		}
			
		
		int startIndex = 0;
		int endIndex = 0;
		int count = 0;
		int sum = A[0];
		while(endIndex < arrIndex) {
			if(sum < N) {
				endIndex++;
				sum += A[endIndex];
			} else if(sum > N) {
				sum -= A[startIndex];
				startIndex++;
			} else {
				count++;
				endIndex++;
				sum += A[endIndex];
			}
		}
		System.out.println(count);
	}
	
	public static int Prime(int num) {
		if(num < 2) return 0;
		else if(num == 2) return num;
		
		for(int i=2 ; i<=Math.sqrt(num); i++) {
			if(num%i == 0) return 0;
		}
		return num;
	}
	

}
