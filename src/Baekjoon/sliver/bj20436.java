package Baekjoon.sliver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
public class bj20436 {
	static char[][] keyboard = {{'q','w','e','r','t','y','u','i','o','p'},{'a','s','d','f','g','h','j','k','l','\0'},{'z','x','c','v','b','n','m','\0','\0','\0'}};
	public static void main(String[] args) throws Exception {
		char[] mo = {'y','u','i','o','p','h','j','k','l','b','n','m'};
		
		HashMap<Character, Location> kb = new HashMap<>();
		for(int i=0 ; i<keyboard.length ; i++) {
			for(int j=0 ; j<keyboard[i].length ; j++) {
				if(keyboard[i][j] != '\0') {
					kb.put(keyboard[i][j], new Location(i, j));
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] hand = br.readLine().split(" ");
		char left = hand[0].charAt(0);
		char right = hand[1].charAt(0);
		
		int lx = kb.get(left).x;
		int ly = kb.get(left).y;
		int rx = kb.get(right).x;
		int ry = kb.get(right).y;
		
		
		String str = br.readLine();
		
		int ans = 0;
		for(int i=0 ; i<str.length() ; i++) {
			char now = str.charAt(i);
			Location loc = kb.get(now);
			
			if(isMo(now, mo)) {
				ans += Math.abs(rx - loc.x) + Math.abs(ry - loc.y);
				rx = loc.x;
				ry = loc.y;
			} else {
				ans += Math.abs(lx - loc.x) + Math.abs(ly - loc.y);
				lx = loc.x;
				ly = loc.y;
			}
			ans += 1;
		}

		System.out.print(ans);
		                 
	}
	
	public static boolean isMo(char c, char[] mo) {
		for(char m : mo) {
			if(c == m) return true;
		}
		return false;
	}
	
	static class Location{
		int x;
		int y;
		Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
