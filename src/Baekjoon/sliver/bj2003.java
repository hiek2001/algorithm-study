package Baekjoon.sliver;
import java.util.Scanner;
public class bj2003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long sum = sc.nextLong();
        int A[] = new int[N+1];
        for(int i=0 ; i<N ; i++)
            A[i] = sc.nextInt();
        
        int start_index = 0;
        int end_index = 0;
        int count = 0;
        int result = A[0];
        while(end_index != N) {
        	if(sum > result) {
        		end_index++;
        		result = result + A[end_index];
        	} else if(sum < result) {
        		result = result - A[start_index];
        		start_index++;
        	} else {
        		count++;
        		end_index++;
        		result = result + A[end_index];
        	}
        }
        System.out.println(count);
	}
}
