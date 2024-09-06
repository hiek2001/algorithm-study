package Baekjoon.sliver;
import java.util.*;
import java.io.*;
/*
 * KeyPoint : 부분 문자열이 중복되면 안되므로 HashSet 자료구조를 사용하여 저장
 * 
 * 전체 문자열은 바로 저장, 1자리 문자열은 for문을 사용하여 HashSet에 저장
 * 2자리 문자열부터 substring을 사용해 원하는 문자열을 잘라 저장하고
 * 재귀함수를 호출하여 str.length()-1 자리까지 저장한다. 
 */
public class bj11478 {
	static HashSet<String> set = new HashSet<>();
	static String str;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		
		// str.length()자리 문자열 HashSet에 추가
		set.add(str);
		
		// 1자리 문자열 HashSet에 추가
		for(int i=0 ; i<str.length() ; i++) {
			set.add(String.valueOf(str.charAt(i)));
		}
		
		// 2자리 ~ str.length()-1자리까지 문자열 HashSet에 추가 
		func(0, 1);
		
		System.out.print(set.size());
	}
	
	static void func(int start, int size) {
		if(size == str.length()-1) return;
		
		while(start+size < str.length()) {
			String word = String.valueOf(str.substring(start, start+size+1));
			set.add(word);
			start++;
		}
		
		func(0, ++size);
	}
	
}
