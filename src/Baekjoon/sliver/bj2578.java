package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj2578 {
    static int arr[][];
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];

        // 빙고판 입력 받기
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 사회자 번호 부르기
        int numCnt = 0;
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                markNumber(num);
                numCnt++;
                if (numCnt >= 12) { // 3개의 빙고가 나오기 위해서는 최소 12개 필요
                    bingoCheck();
                }
                if (count >= 3) {
                    System.out.print(numCnt);
                    return;
                }
            }
        }
    }

    public static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == num) {
                    arr[i][j] = -1;
                    return; // 번호를 찾으면 더 이상 검사할 필요 없음
                }
            }
        }
    }

    // 빙고 갯수 검사
    public static void bingoCheck() {
        count = 0;

        // 행과 열 검사
        for (int i = 0; i < 5; i++) {
            int row = 0;
            int col = 0;
            for (int j = 0; j < 5; j++) {
                if (arr[i][j] == -1) row++;
                if (arr[j][i] == -1) col++;
            }
            if (row == 5) count++;
            if (col == 5) count++;
        }

        // 왼쪽 대각선 검사
        int diag1 = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][i] == -1) diag1++;
        }
        if (diag1 == 5) count++;

        // 오른쪽 대각선 검사
        int diag2 = 0;
        for (int i = 0; i < 5; i++) {
            if (arr[i][4 - i] == -1) diag2++;
        }
        if (diag2 == 5) count++;
    }
}
