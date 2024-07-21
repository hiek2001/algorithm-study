package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj4396 {
	static int N;
	static String arr[][];
	static String result[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new String[N][N];
		
		result = new String[N][N];
		// 지뢰 있는 모양 입력 받기
		// 결과 배열 초기화
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			String starLine = st.nextToken();
			for(int j=0 ; j<N ; j++) {
				arr[i][j] = starLine.substring(j, j+1);
				result[i][j] = ".";
			}
		}
		
		boolean bombTriggered = false;
		// 열린 내용 입력 받기
		for(int i=0 ; i<N ; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0 ; j<N ; j++) {
				String starCheck = line.substring(j, j+1);
				 if(starCheck.equals("x")) { 
                    if(arr[i][j].equals("*")) { // 지뢰가 열림. 모든 지뢰 열기
                    	bombTriggered = true;
                    } else { // 지뢰가 열리지 않음. 지뢰 숫자 세기
                        result[i][j] = starCount(i, j);
                    }     
                } 
			}
		}
		
		if(bombTriggered)  bombAllOpen();
		
		// 결과 출력
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void bombAllOpen() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				if(arr[i][j].equals("*")) result[i][j] = "*";
			}
		}
		
	}
	
	public static String starCount(int start, int end) {
		int move[] = {-1,0,1};
		int starCnt = 0;
		for(int i=0 ; i<3 ; i++) {
			for(int j=0; j<3 ; j++) {
				int x = start + move[i];
				int y = end + move[j];
				if(x>=0 && y>=0 && x<N && y<N) {
					if(arr[x][y].equals("*")) starCnt++;
				}
			}
		}
		return String.valueOf(starCnt);
	}
}
