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
            D[i] = Math.min(D[i-3], D[i-5])+1;
        }
        
        if(D[N] > 5001) System.out.println(-1); // 계산되지 않은 값에서 계산된 경우 초기값(5001)보다 큼
        else System.out.print(D[N]);
    }
}
