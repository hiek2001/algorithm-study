package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * 1268, 임시 반장 정하기
- 문제 분석
	- 다른 학생과 같은 반을 많이 한 학생이 임시반장
	- 임시 반장이 될 수 있는 학생이 여러 명이면 그 중 가장 작은 번호만 출력
- 의사 결정 및 코드 구현
	- 각 학생에 대한 5년 간의 반 정보를 저장하기 위해 이중 배열을 선언
	- Student 클래스에 학생에 번호와 같은 반 횟수를 저장
	- 이중 for문 사용해 학생들의 반 정보를 이중 배열에 저장하고
	- List에 학생 객체들을 저장, 횟수는 0으로 초기화
	- 이중 for문 사용하여 학생 간의 같은 반 횟수를 계산
		- 기준 학생(i)와 비교 대상 학생(j)가 동일하지 않을 때만 비교를 수행
		- wasClassmate() 메소드에서는 두 학생이 5년동안 한번이라도 같은 반에 있었는지 확인
			- 과거에 같은 반이었다면 true를 반환
			- 기준 학생의 count를 1 증가
	- Collections.sort()를 사용해 정렬 수행
		- count 기준으로 내림차순 정렬
		- 동일한 count가 있으면 학생 번호 기준으로 오름차순 정렬하여 가장 작은 학생이 출력되도록 함
		
	15032 kb, 168 ms
 */
public class bj1268 {
	static int[][] arr;
	
	static class Student{
		int num, count;
		Student(int num, int count) {
			this.num = num;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// N명의 학생에 대한 5년간의 반 정보
		arr = new int[N+1][5];
		
		// 입력 받아서 학생들의 반 정보를 저장
		List<Student> students = new ArrayList<>();
		StringTokenizer st;
		for(int i=1 ; i<=N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=1 ; j<5 ; j++) {				
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
			
			// 각 학생을 초기화하여 리스트에 추가 (count = 0으로 시작)
			students.add(new Student(i, 0));
		}
		
		// 학생 간의 같은 반 횟수를 계산
		for(int i=1 ; i<=N ; i++) { // 비교 기준 학생
			for(int j=1 ; j<=N ; j++) { // 비교 대상 학생
				if(i != j && wasClassmate(i, j)) {
					students.get(i-1).count++; // 같은 반인 적이 있으면 count 증가
				}
			}
		}
		
		// count 내림차순, num 오름차순 정렬
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				if(s1.count != s2.count) return Integer.compare(s2.count, s1.count); // count 내림차순
				else return Integer.compare(s1.num, s2.num); // num 오름차순
			}
		});
		
		// 가장 같은 반이 많았던 학생의 번호 출력
		System.out.print(students.get(0).num);
	}
	
	// 두 학생이 한번이라도 같은 반에 있었는지 확인
	static boolean wasClassmate(int studentA, int studentB) {
		for(int k=1 ; k<5 ; k++) {
			if(arr[studentA][k] == arr[studentB][k]) return true;
		}
		return false;
	}

}
