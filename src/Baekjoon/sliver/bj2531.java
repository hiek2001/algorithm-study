package Baekjoon.sliver;
import java.util.Scanner;
public class bj2531 {
	public static void main(String[] args){
		 Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int k = sc.nextInt();
        int c = sc.nextInt();
        int sushi[] = new int[n];
        for(int i=0 ; i<n ; i++)
            sushi[i] = sc.nextInt();
        int eating[] = new int[d+1];
        eating[c] = 3002; // 쿠폰 번호 체크
        
        int count = 1; // 쿠폰번호 한개 추가
        // 처음 슬라인드 윈도우 생성
        for(int i=0 ; i<k ; i++) {
            int sushiId = sushi[i];
            if(eating[sushiId] == 0) count++;
            eating[sushiId]++;
        }
        int max = count;
        
        // 슬라인드 윈도우 이동
        for(int i=0 ; i<n-1 ; i++) {
            int startId = sushi[i];
            int endId = sushi[i+k<n ? i+k : (i+k)%n];
            if(--eating[startId] == 0) count--;
            if(++eating[endId] == 1) count++;
            max = Math.max(max, count);
        }
        System.out.println(max);
		
	}
	
}
