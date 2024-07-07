package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj10828 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		Stack stack = new Stack();
		for(int i=0 ; i<N ; i++) {
			String str = br.readLine();
			String arr[] = str.split(" ");
			
			switch(arr[0]) {
			case "push" : 
				stack.add(arr[1]);
				break;
				
			case "pop" :
				if(stack.empty()) {
					bw.write(-1+"\n");
				} else {
					bw.write(stack.pop()+"\n");
				}
				break;
				
			case "size" :
				bw.write(stack.size()+"\n");
				break;
				
			case "empty" :
				if(stack.empty()) {
					bw.write(1+"\n");
				} else {
					bw.write(0+"\n");
				}
				break;
				
			case "top" :
				if(stack.empty()) {
					bw.write(-1+"\n");
				} else {
					bw.write(stack.peek()+"\n");
				}
				break;
			}
		}
		bw.flush();
		bw.close();
		
	}
}
