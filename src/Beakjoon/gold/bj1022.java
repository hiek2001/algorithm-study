package Beakjoon.gold;
import java.util.*;
import java.io.*;
// 문제 분석 - 포스팅 작성 : https://ranny-devlog.tistory.com/12
public class bj1022 {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int R1 = Integer.parseInt(input[0]);
		int C1 = Integer.parseInt(input[1]);
		int R2 = Integer.parseInt(input[2]);
		int C2 = Integer.parseInt(input[3]);
		
		// 출력 범위 만큼 배열 크기 설정
		int rows = R2-R1+1; // 7
		int cols = C2-C1+1; // 4
		int[][] arr = new int[rows][cols];
		
		// 출력할 때 최대 자릿수를 맞춰서 공간을 비워줘야하기 때문에 가장 큰 숫자를 찾기 
		int maxNumber = 0;
		for(int i=0 ; i<rows; i++) {
			for(int j=0 ; j<cols ; j++) {
				int value = getSpiralValue(R1+i, C1+j); // 좌표의 소용돌이 값을 계산
				arr[i][j] = value;
				maxNumber = Math.max(maxNumber, value);
			}
		}
		
		int maxDigits = String.valueOf(maxNumber).length();
		
		for(int i=0 ; i<rows ; i++) {
			for(int j=0 ; j<cols ; j++) {
				sb.append(String.format("%"+maxDigits+"d ", arr[i][j]));
			}
			sb.append("\n");
		}
//     ASIS
//		int max = Math.abs(R1);
//		for(int i=1 ; i<input.length ; i++) {
//			max = Math.max(Math.abs(max), Math.abs(Integer.parseInt(input[i])));
//		}
//		
//		int N = (max*2) + 1;
//		
//		int[][] arr = new int[N][N];
//		
//		// 우, 위, 좌, 아래 방향
//		int[] dx = {0,-1,0,1};
//		int[] dy = {1,0,-1,0};
//		
//		int x = N/2;
//		int y = N/2;
//		
//		int step = 1;
//		arr[x][y] = 1;
//		
//		int num = 2;
//		while(num <= N*N) {
//			for(int j=0 ; j<4 ; j++) {
//				for (int k = 0; k < step; k++) {
//                    x += dx[j];
//                    y += dy[j];
//
//                    // 배열 경계 체크 후 값 채움
//                    if (x >= 0 && x <= N && y >= 0 && y <= N) {
//                        arr[x][y] = num++;
//                    }
//
//                    if (num > N * N) break;  
//                }
//                if (j == 1 || j == 3) step++;  
//			
//			}
//		}
//	
//		
//		for(int i=N/2+R1 ; i<=N/2+R2 ; i++) {
//			for(int j=N/2+C1 ; j<=N/2+C2 ; j++) {
//				sb.append(arr[i][j]+" ");
//			}
//			sb.append("\n");
//		}
//		
		System.out.print(sb);
	}
	
	static int getSpiralValue(int x, int y) {
		int layer = Math.max(Math.abs(x), Math.abs(y)); // 몇 번째 소용돌이 층인지 계산
		int maxLayerValue = (2*layer+1) * (2*layer+1);
		
		int result;
		
		if(x == layer) // (하단) 좌 -> 우 이동 
			result = maxLayerValue - (layer - y); 
		else if(y == -layer) // (하단) 좌 -> (상단) 좌 이동 
			result = maxLayerValue - (2 * layer) - (layer - x);
		else if(x == -layer) // (상단) 좌 -> (상단) 우 이동
			result = maxLayerValue - (4 * layer) - (layer + y);
		else  // (상단) 우 -> (하단) 우 이동
			result = maxLayerValue - (6 * layer) - (layer + x);
		
		return result;
	}
}
