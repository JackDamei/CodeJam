package y2020.kickstartrB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class MainCfail {
	
	static long MAX = 1000000000;

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
		
			String s = in.next();
			
			long cptH=0, cptV=0;
			LinkedList<Integer> list = new LinkedList<Integer>();
			long mult = 1;
			for (int i=0; i<s.length();i++) {
				char c = s.charAt(i);
				if (c == '(') continue;
				if (c == 'N') cptV -= mult;
				if (c == 'S') cptV += mult;
				if (c == 'W') cptH -= mult;
				if (c == 'E') cptH += mult;
				if (c>'1'&&c<='9') {
					int n = Integer.parseInt(s.substring(i,i+1));
					mult *= n;
					list.addFirst(n);
				}
				if (c == ')') mult /= list.removeFirst();
			}
			cptH = cptH%MAX;
			cptH += cptH < 0 ? MAX : 0;
			cptV = cptV%MAX;
			cptV += cptV < 0 ? MAX : 0;
			
			System.out.println(String.format("Case #%d: %d %d",t+1,cptH+1,cptV+1));
		}
		
		in.close();
	}

}
