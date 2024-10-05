package Baekjoon.sliver;
import java.io.*;
// 문제 분석 : https://ranny-devlog.tistory.com/entry/%EB%B0%B1%EC%A4%80-14916-%EA%B1%B0%EC%8A%A4%EB%A6%84%EB%8F%88-JAVA-%ED%92%80%EC%9D%B4
public class bj14916 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		int count = 0;
		if(num % 5 == 0) {
			num /= 5;
			sb.append(num);
		} else {
			while(num > 0) {
				num -= 2;
				count++;
				if(num % 5 == 0) {
					num /= 5;
					count += num;
					sb.append(count);
					break;
				}
			}
		}
		
		if(num < 0) System.out.print(-1);
		
		System.out.print(sb);

	}
}
