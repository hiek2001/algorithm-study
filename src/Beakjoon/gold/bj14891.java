package Beakjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class bj14891 {
	static LinkedList<Integer>[] wheel = new LinkedList[5];
	static int[] directInfo;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 톱니 바퀴 입력받기
		for (int i = 1; i <= 4; i++) {
			wheel[i] = new LinkedList<>();
			String input = br.readLine();
			for (int j = 0; j < input.length(); j++) {
				wheel[i].addLast((int) input.charAt(j) - 48);
			}
		}

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			directInfo = new int[5];
			String input[] = br.readLine().split(" ");
			int wheelNum = Integer.parseInt(input[0]);
			directInfo[wheelNum] = Integer.parseInt(input[1]);
			turnCheck(wheelNum);
			roll();
		}

		// 톱니바퀴 점수별 계산
		int sum = 0;
		sum += wheel[1].get(0) * (1);
		sum += wheel[2].get(0) * (2);
		sum += wheel[3].get(0) * (4);
		sum += wheel[4].get(0) * (8);
		System.out.print(sum);
	}

	static void roll() {
		for (int i = 1; i < 5; i++) {
			if (directInfo[i] != 0) {
				if (directInfo[i] == 1) { // 시계 방향
					wheel[i].addFirst(wheel[i].pollLast()); // 마지막 요소를 첫번째로 이동
				} else { // 반시계 방향
					wheel[i].addLast(wheel[i].pollFirst()); // 첫번째 요소를 마지막으로 이동
				}
			}
		}
	}

	static void turnCheck(int num) {
		// 우측 톱니바퀴 회전 정보 설정
		for (int i = num; i < 4; i++) {
			if (wheel[i].get(2) != wheel[i + 1].get(6)) { // 우측 톱니바퀴 극 확인
				directInfo[i + 1] = directInfo[i] * (-1); // 다르면 반대 방향으로 설정
			} else {
				break; // 같으면 회전 전파 중지
			}
		}

		// 좌측 톱니바퀴 회전 정보 설정
		for (int i = num - 1; i > 0; i--) {
			if (wheel[i].get(2) != wheel[i + 1].get(6)) { // 좌측 톱니바퀴 극 확인
				directInfo[i] = directInfo[i + 1] * (-1); // 다르면 반대 방향으로 설정
			} else {
				break; // 같으면 회전 전파 중지
			}
		}
	}
}
