package Baekjoon.sliver;
import java.util.*;
import java.io.*;
public class bj9012{
    static String str;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i=0 ; i<N ; i++) {
            str = br.readLine();
            
            bw.write(solve(str)+"\n");
            
        }
        bw.flush();
        bw.close();
    }
    
    public static String solve(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int j=0 ; j<str.length() ; j++) {
                if(str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else if(stack.empty()) {
                	return "NO";
                } else {                  
                    stack.pop();
                }            
        }
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }
}
