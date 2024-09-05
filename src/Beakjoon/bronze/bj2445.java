package Beakjoon.bronze;
import java.util.Scanner;
public class bj2445 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int i=1 ; i<=n ; i++) {
			for(int j=1 ; j<=i ;j++) {
				sb.append("*");
			}
			for(int k=1 ; k<=2*(n-i) ; k++) {
				sb.append(" ");
			}
			for(int j=1 ; j<=i ; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for(int i=n-1 ; i>0 ; i--) {
			for(int j=1 ; j<=i ; j++) {
				sb.append("*");
			}
			for(int k=1 ; k<=2*(n-i); k++) {
				sb.append(" ");
			}
			for(int j=1 ; j<=i ; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		System.out.print(sb);
		
	}
}
