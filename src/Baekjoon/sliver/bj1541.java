package Baekjoon.sliver;
import java.io.*;
// 최소의 값을 구하기 위해서는
// - 기호를 만난 이후의 모든 수들은 전부 더한 후, 한꺼번에 빼야 함
// 이전 코드의 경우
// 모든 + 연산을 먼저 처리하고 이후 각각 빼고 있어 틀렸음
public class bj1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split("-");
		
		int result = 0;
		for(String num : line[0].split("\\+")) {
			result += Integer.parseInt(num);
		}
		
		for(int i=1 ; i<line.length ; i++) {
			int tempSum = 0;
			for(String num : line[i].split("\\+")) {
				tempSum += Integer.parseInt(num);
			}
			result -= tempSum;
		}
		
		System.out.print(result);
		
//		ASIS 코드		
//		int sum = 0;
//		for(int i=line.length-1 ; i>=0 ; i--) {			
//			if(line[i].contains("+")) {				
//				String[] str = line[i].split("\\+");
//				for(String s : str) {
//					sum += Integer.parseInt(s);
//				}
//				line[i] = String.valueOf(sum);
//			}
//		}
//		
//		int result = Integer.parseInt(line[0]);
//		for(int i=1 ; i<line.length ; i++) {
//			result -= Integer.parseInt(line[i]);
//		}
//		
//		System.out.print(result);
	}
}
