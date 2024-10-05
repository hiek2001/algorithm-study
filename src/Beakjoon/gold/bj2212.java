package Beakjoon.gold;
import java.util.*;
import java.io.*;
// 문제 풀이 : https://ranny-devlog.tistory.com/entry/%EB%B0%B1%EC%A4%80-2212-%EC%84%BC%EC%84%9C-JAVA-%ED%92%80%EC%9D%B4
public class bj2212 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 센서 수
		int K = Integer.parseInt(br.readLine()); // 집중국 수
		
		int[] sensors = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0 ; i<N ; i++) {
			sensors[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sensors); // 센서의 위치를 오름차순 정렬
		
		Integer[] distance = new Integer[N-1]; // 각 센서 사이 거리 
		for(int i=1 ; i<N ; i++) {
			for(int j=i-1 ; j<i ; j++) {
				distance[j] = sensors[i] - sensors[j];
			}
		}
		
		Arrays.sort(distance, Collections.reverseOrder()); // 센서 사이의 거리를 내림차순 정렬
		
		int sum = 0;
		for(int i=K-1 ; i<N-1 ; i++) {
			sum += distance[i];
		}
		
		System.out.print(sum);
		

	}
}
