package Baekjoon.sliver;
import java.util.Arrays;
import java.util.Scanner;
public class bj3273 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0 ; i<N ; i++)
			arr[i] = sc.nextInt();
		int sum = sc.nextInt();
		Arrays.sort(arr);
		
		int count = 0;
		int i=0;
		int j=N-1;
		while(i<j) {
			if(arr[i] + arr[j] < sum) i++;
			else if(arr[i] + arr[j] > sum) j--;
			else {
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
	}
}
