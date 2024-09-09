package Baekjoon.sliver;
import java.util.*;
/*
 * 점화식
 * N = 18일 경우,
 * min((13kg 최소 봉지수 + 1), (15kg 최소 봉지수 + 1))
 * D가 ikg일때 최소 봉지수가 담긴 Array라면
 * 
 * D[i] = min(D[i-3]+1 , D[i-5]+1)
 */
public class bj2839{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] D = new int[5001];
        Arrays.fill(D, 5001); // 초기화되지 않은 상태에서 계산될 수 있음
        
        if(N>=3) D[3] = 1;
        if(N>=5) D[5] = 1;
        
        for(int i=6 ; i<5001 ; i++) {
        	if(D[i-3] != 5001 || D[i-5] != 5001) { // 유효한 값인지 확인
        		D[i] = Math.min(D[i-3], D[i-5])+1;
        	}
        }
        
        if(D[N] == 5001) System.out.println(-1); // 5001이면 불가능한 경우
        else System.out.print(D[N]);
    }
}
