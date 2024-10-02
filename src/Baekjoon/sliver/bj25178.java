package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj25178 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] A = br.readLine().toCharArray();
		char[] B = br.readLine().toCharArray();
		
		boolean flag = true; // false: No, true: Yes
		// 첫, 마지막 글자 동일한지 확인
		if(A[0] != B[0] || A[N-1] != B[N-1]) {
			flag = false;
		}
		
		
		// map에 글자 추가
		HashMap<Character, Integer> map = new HashMap<>(); 
		for(char a : A) { // a 글자를 추가할 때 1 증가
			map.put(a, map.getOrDefault(a, 0) + 1);
		}
		for(char b : B) { // b 글자 추가할 때 1 감소
			map.put(b, map.getOrDefault(b, 0) - 1);
		}
		
		
		// 글자가 겹쳤다면 해당 글자의 갯수는 0
		// 0이 아니면 NO 출력
		for(int count : map.values()) {
			if(count != 0) {
				flag = false;
				break;
			}
		}
		
		// 자음 순서 비교
		char[] vowels = {'a','e','i','o','u'};
		String strA = removeVowels(A, vowels);
		String strB = removeVowels(B, vowels);
		
		if(!strA.equals(strB)) flag = false;
		
		System.out.print(flag ? "YES" : "NO");
		
	}
	
	static String removeVowels(char[] arr, char[] vowels) { 
		StringBuilder sb = new StringBuilder();
		for(char c : arr) {
			boolean isVowel = false;
			
			// 모음 배열을 비교하면서 모음인지 확인
			for(char vowel : vowels) {
				if(c == vowel) {
					isVowel = true;
					break;
				}
			}
			
			if(!isVowel) sb.append(c); 
		}
		
		return sb.toString();
	}
}
