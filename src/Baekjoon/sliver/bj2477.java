package Baekjoon.sliver;
import java.util.*;
import java.io.*;

/**
 * 이동 거리를 입력 받는다.
 * 전체 면적을 계산하기 위해 최대 길이와 높이, 해당 인덱스를 저장한다.
 * 최대 길이와 높이를 사용하여 잘려진 부분의 길이, 높이를 구한다.
 * (전체 면적의 넓이 - 잘려진 부분의 넓이) * k 하여 결과값을 도출한다.
 */
public class bj2477 {
	static int maxWidth, maxHeight;
	static int length[];
	static int indexWidth, indexHeight;
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());	
		length = new int[6]; // 이동 거리 입력 받기
		
		// 최대 높이, 너비 초기화
		maxWidth = 0;
		maxHeight = 0;
		
		// 입력 받으면서 최대 높이, 너비와 가리키는 인덱스 저장
		for(int i=0 ; i<6 ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int direction = Integer.parseInt(st.nextToken());
			length[i] = Integer.parseInt(st.nextToken());
			if(direction == 1 || direction == 2) {
				if(maxWidth < length[i]) {
					maxWidth = length[i];
					indexWidth = i;
				}
			} else {
				if(maxHeight < length[i]) {
					maxHeight = length[i];
					indexHeight = i;
				}
			}
		}
		
		int smallWidth = lengthCut(indexHeight); // 잘린 부분 높이 구하기
		int smallHeight = lengthCut(indexWidth); // 잘린 부분 너비 구하기
		
		System.out.println(maxWidth*maxHeight);
		System.out.println(smallWidth*smallHeight);
		
		int result = ((maxWidth*maxHeight)-(smallWidth*smallHeight))*k;
		System.out.println(result);
		
	}
	
	static int lengthCut(int index) {		
		int ans = 0;
		if(index == 0) {
			ans = Math.abs(length[index+1]) - length[5];
		} else if(index == 5) {
			ans = Math.abs(length[index-1]) - length[0];
		} else {
			ans = Math.abs(length[index+1] - length[index-1]);
		}
		return ans;
	}
}
