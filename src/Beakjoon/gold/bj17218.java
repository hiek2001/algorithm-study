package Beakjoon.gold;
import java.util.*;
import java.io.*;
/*
 * KeyPoint : LCS 알고리즘을 사용
 * 
 * 각 문자열을 입력 받고, 1부터 저장한다.
 * LCS 알고리즘 점화식을 사용하여 LCS 배열을 세팅한다.
 * -> 처음 LCS 배열을 모두 0으로 초기화한다.
 * -> 각 부분 문자열이 같으면 LCS[i][j] = LCS[i-1][j-1] + 1 한다.
 * -> 각 부분 문자열이 다르면 LCS[i-1][j],LCS[i][j-1] 이 중 큰 값을 LCS[i][j]에 저장한다.
 * 
 * LCS 배열의 가장 마지막 값부터 LCS[i-1][j]과 LCS[i][j-1] 중 현재 값과 같은 값을 찾는다.
 * -> 같은 값이 있으면 위쪽 값으로 이동한다.
 * -> 같은 값이 없으면 result 배열에 해당 문자를 넣고, 왼쪽으로 이동한다.
 * 
 * 해당 result 값을 reverse로 출력한다.
 * 
 * 14172 KB, 100 ms
 * 
 * LSC 알고리즘 설명 : https://velog.io/@emplam27/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EA%B7%B8%EB%A6%BC%EC%9C%BC%EB%A1%9C-%EC%95%8C%EC%95%84%EB%B3%B4%EB%8A%94-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Longest-Common-Substring%EC%99%80-Longest-Common-Subsequence#%EC%B5%9C%EC%9E%A5-%EA%B3%B5%ED%86%B5-%EB%B6%80%EB%B6%84%EC%88%98%EC%97%B4longest-common-subsequence-%EC%B0%BE%EA%B8%B0
 * 
 */
public class bj17218 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();	
		
		char[] A = new char[str1.length()+1];
		char[] B = new char[str2.length()+1];
		int[][] LCS = new int[A.length][B.length]; // 0 포함, [9][8]
		for(int i=1 ; i<A.length ; i++) {
			A[i] = str1.charAt(i-1);
		}
		for(int i=1 ; i<B.length ; i++) {
			B[i] = str2.charAt(i-1);
		}
		
		
		// LCS 알고리즘 사용하여 값 세팅
		for(int i=1 ; i<A.length ; i++) {
			for(int j=1 ; j<B.length ; j++) {
				if(A[i] == B[j]) { // 값이 같을 경우
					LCS[i][j] = LCS[i-1][j-1] + 1;
				} else { // 값이 다를 경우
					LCS[i][j] = Math.max(LCS[i-1][j],LCS[i][j-1]);
				}
			}
		}
		
		ArrayList<String> result = new ArrayList<>();
		
		// 동일한 문자열 찾기
		int start = str1.length();
		int end = str2.length();
		while(start>0 && end>0) {
			if((LCS[start][end] == LCS[start-1][end]) && (LCS[start][end] == LCS[start][end-1])) {
				start-=1;
			} else if((LCS[start][end] != LCS[start-1][end]) && (LCS[start][end] != LCS[start][end-1])) {
				result.add(String.valueOf(A[start]));
				start-=1;
				end-=1;
			} else if(LCS[start][end] == LCS[start-1][end]) {
				start-=1;
			} else if(LCS[start][end] == LCS[start][end-1]) {
				end-=1;
			} else if(LCS[start][end] == 0) {
				return;
			}
		}
		
		StringBuffer sb = new StringBuffer(String.join("", result));
		System.out.print(sb.reverse().toString());
		
	}
}
