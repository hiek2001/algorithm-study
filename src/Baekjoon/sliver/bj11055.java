package Baekjoon.sliver;
import java.util.*;
import java.io.*;
// 문제 조건
// - 수열이 "증가"하는 부분 수열 중, "합"이 가장 큰 것
// s[i] = s[j] + a[i]
public class bj11055 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] s = new int[n]; // 합 저장
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            s[i] = a[i]; // 초기값은 각 원소 자체로 설정
        }
        
        for(int i=1 ; i<n ; i++) {
            for(int j=0 ; j<i ; j++) {
                if(a[i] > a[j] && s[i] < s[j] + a[i]) {
                    s[i] = s[j] + a[i]; // 이전 부분 수열의 최대 합을 갱신
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for(int sum : s) {
            max = Math.max(sum, max);
        }
        
        System.out.print(max);
        
    }
}
