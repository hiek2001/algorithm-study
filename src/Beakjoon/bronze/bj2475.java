package Beakjoon.bronze;
import java.util.*;
import java.io.*;
public class bj2475 {
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int result = 0;
        for(int i=0 ; i<5 ; i++) {
            int num = Integer.parseInt(st.nextToken());
            result += Math.pow(num, 2);
        }
        System.out.println(result%10);
    }

}
