package Baekjoon.sliver;
import java.util.*;
/*
 * 17948KB , 184ms
 */
public class bj17478 {
	static StringBuilder sb = new StringBuilder();
	static int length = 0;
	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		chatbot(N);
		
		System.out.println(sb);
	}
	
	static void chatbot(int N) {
		char[] line = new char[length];
		Arrays.fill(line, '_');
		if(N > 0) {
			sb.append(new String(line)).append("\"재귀함수가 뭔가요?\"\n");
			sb.append(new String(line)).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
			sb.append(new String(line)).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
			sb.append(new String(line)).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
			length += 4;
			chatbot(N-1);
			sb.append(new String(line)).append("라고 답변하였지.\n");
		} else if(N == 0) {
			length += 4;
			sb.append(new String(line)).append("\"재귀함수가 뭔가요?\"").append("\n");
			sb.append(new String(line)).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
			sb.append(new String(line)).append("라고 답변하였지.").append("\n");
			
			return;
		}
		

	}
}
