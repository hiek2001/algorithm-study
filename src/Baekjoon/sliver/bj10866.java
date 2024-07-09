package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj10866 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=0 ; i<N ; i++) {			
			String str = br.readLine();
			String arr[] = str.split(" ");
			
			switch(arr[0]) {
			case "push_front" :
				deque.addFirst(Integer.parseInt(arr[1]));
				break;
			
			case "push_back" :
				deque.addLast(Integer.parseInt(arr[1]));
				break;
				
			case "pop_front" :
				if(deque.isEmpty()) bw.write(-1+"\n");
				else bw.write(deque.pollFirst()+"\n");
				break;
				
			case "pop_back" :
				if(deque.isEmpty()) bw.write(-1+"\n");
				else bw.write(deque.pollLast()+"\n");
				break;
				
			case "size" :
				bw.write(deque.size()+"\n");
				break;
				
			case "empty" :
				if(deque.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
				break;
				
			case "front" :
				if(deque.isEmpty()) bw.write(-1+"\n");
				else bw.write(deque.getFirst()+"\n");
				break;
				
			case "back" :
				if(deque.isEmpty()) bw.write(-1+"\n");
				else bw.write(deque.getLast()+"\n");
				break;
			}
		}
		bw.flush();
		bw.close();
	}
}
