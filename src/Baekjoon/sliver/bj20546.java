package Baekjoon.sliver;
import java.util.*;
public class bj20546 {
	static int M;
	static int A[];
	static int jMoney, sMoney;
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		A = new int[15];
		for(int i=1 ; i<A.length ; i++) {
			A[i] = sc.nextInt();
		}
		
		jMoney = M;
		sMoney = M;
		int totalJmoney = jMoney + (A[14] * Jinhyeon());
		int totalSmoney = sMoney + (A[14] * Seongmin());
		
		if(totalJmoney > totalSmoney) System.out.print("BNP");
		else if(totalJmoney < totalSmoney) System.out.print("TIMING");
		else System.out.print("SAMESAME");
	}
	
	public static int Jinhyeon() {
		int cnt = 0;
		for(int i=1 ; i<A.length ; i++) {
			if(A[i] < M) {
				while(jMoney > A[i]) {
					jMoney -= A[i];
					cnt++;
				}
				break;
			}
		}
		return cnt;
	}
	
	public static int Seongmin() {
		int cnt = 0;
		int days = 0;
		for(int i=1 ; i<A.length ; i++) {
			if(M >= A[i]) {
				if(A[i-1] > A[i]) { // 전일 대비 주가 하락 하는지 확인
					days++;
					if(days == 3) {
						while(sMoney > A[i]) {
							sMoney -= A[i];
							cnt++;
						}
						days = 0;
					}
				} else if(A[i-1] == A[i]) {
					while(sMoney > A[i]) {
						sMoney -= A[i];
						cnt++;
					}
				} else {
					if(cnt > 0) {
						days++;
						if(days == 3) {
							sMoney += cnt * A[i];
						}
					}
				}
			} 
		}
		return cnt;
	}
}
