package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj18258 {
	 public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	        int N = Integer.parseInt(br.readLine());
	        
	        int last = -1;
	        Queue<Integer> que = new LinkedList<>();
	        for(int i=0 ; i<N ; i++) {
	            String str = br.readLine();
	            String arr[] = str.split(" ");
	            
	            switch(arr[0]) {
	                case "push" : 
	                    last = Integer.parseInt(arr[1]);
	                    que.add(last);
	                    break;
	                
	                case "pop" :
	                    if(que.isEmpty()) {
	                        bw.write(-1+"\n");
	                    } else {
	                        bw.write(que.poll()+"\n");                        
	                    }
	                    break;
	                
	                case "size" :
	                    bw.write(que.size()+"\n");
	                    break;
	                    
	                case "empty" :
	                    if(que.isEmpty()) {
	                        bw.write(1+"\n");
	                    } else {
	                        bw.write(0+"\n");
	                    }
	                    break;
	                    
	                case "front" :
	                    if(que.isEmpty()) {
	                        bw.write(-1+"\n");
	                    } else {
	                        bw.write(que.peek()+"\n");
	                    }
	                    break;
	                    
	                case "back" :
	                    if(que.isEmpty()) {
	                        bw.write(-1+"\n");
	                    } else {
	                        bw.write(last+"\n");
	                    }
	                    break;
	            }
	        }
	         bw.flush();
	         bw.close();
	    }
}
	
