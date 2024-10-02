package Baekjoon.sliver;
import java.io.*;
public class bj25206 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] gradeScale = { 
	            {"A+", "4.5"}, {"A0", "4.0"}, {"B+", "3.5"}, {"B0", "3.0"}, 
	            {"C+", "2.5"}, {"C0", "2.0"}, {"D+", "1.5"}, {"D0", "1.0"}, {"F", "0.0"} 
	        };
		
		
		double sum = 0;
		double totalCredits = 0;
		
		String line;
		while((line = br.readLine()) != null && !line.isEmpty()) {
			String[] input = line.split(" ");
			
			double score = 0;
			double credits = Double.parseDouble(input[1]);
			
			for(String[] grade : gradeScale) {
				if(input[2].equals("P")) continue;
				
				if(input[2].equals(grade[0])) {
					score = Double.parseDouble(grade[1]);
					totalCredits += credits;
					break;
				}
			}
			
			sum += score * credits;
		}
		
		System.out.print(sum / totalCredits);
	}
}
