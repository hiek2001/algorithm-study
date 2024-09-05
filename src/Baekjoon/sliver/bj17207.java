package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/**
 * 일의 난이도, 처리시간을 입력 받아 각 배열에 저장한다.
 * 중첩 반복문을 사용하여 계산한다.
 * Person 생성자를 만들어 처리량을 기준으로 오름차순 정렬한다.
 * 가장 작은 값을 도출한다.
 */
public class bj17207 {
	static int A[][], B[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 배열 입력 받기
		A = new int[5][5];
		B = new int[5][5];
		for(int i=0 ; i<5 ; i++) { // 일의 난이도
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<5 ; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0 ; i<5 ; i++) { // 일의 처리 시간
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0 ; j<5 ; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 계산하기
		Person ans[] = new Person[5];
		ans[0] = new Person("Inseo"); 
		ans[1] = new Person("Junsuk");
		ans[2] = new Person("Jungwoo");
		ans[3] = new Person("Jinwoo");
		ans[4] = new Person("Youngki");
		for(int i=0 ; i<5 ; i++) { // 사람
			for(int j=0 ; j<5 ; j++) { // 예상 일량
				for(int k=0 ; k<5 ; k++) { // index
					ans[i].setCost(A[i][k] * B[k][j]);
				}
			}
		}
		
		Arrays.sort(ans);
		
		System.out.println(ans[0].name);
		
	}
	
	static class Person implements Comparable<Person>{
		String name;
		int cost;
		public Person(String s) {
			this.name = s;
			this.cost = 0;
		}
		public void setCost(int c) {
			this.cost += c;
		}
		@Override
		public int compareTo(Person p) {
			if(this.cost == p.cost) {
				return p.name.compareTo(this.name);
			}
			else return Integer.compare(this.cost, p.cost);
		}
	}
}
