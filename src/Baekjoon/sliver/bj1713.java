package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj1713 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int student[] = new int[101]; // 추천기록
		StringTokenizer st = new StringTokenizer(br.readLine());		
		List<Integer> frame = new ArrayList<>();
		for(int i=0 ; i<M ; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(frame.contains(num)) { // 이미 사진틀에 있는 경우
				student[num]++;
			} else { // 사진틀이 가득찬 경우
				if(frame.size() == N) {
					int minValue = 1001;
					int candidate = 0;
					
					// 추천 횟수가 가장 적은 학생 찾기
					for(int j=0 ; j<frame.size() ; j++) {
						int currentStudent = frame.get(j);
						if(student[currentStudent] < minValue) {
							minValue = student[currentStudent];
							candidate = currentStudent;
						}
					}
					
					// 가장 오래된 학생 찾기
					frame.remove(Integer.valueOf(candidate));
					student[candidate] = 0;
				}
				
				// 새로운 학생 추가
				frame.add(num);
				student[num]++;
			}
		}
		
		// 결과 출력
		Collections.sort(frame);
		for(int i : frame) {
			System.out.print(i+" ");
		}
	}
}
