package Baekjoon.sliver;
import java.io.*;
import java.util.*;
public class bj10610 {
    public static void main(String[] args) throws Exception {
    	StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        char[] input = br.readLine().toCharArray();
        
        Arrays.sort(input);
        
        int sum = 0;
        for(int i=input.length - 1 ; i>=0 ; i--) {
        	int num = input[i] - '0';
        	sum += num;
        	sb.append(num);
        }
        
        
        
        if(sum % 3 != 0 || input[0] != '0') {
        	System.out.print(-1);
        	return;
        }
        
        System.out.print(sb);
    }
}
