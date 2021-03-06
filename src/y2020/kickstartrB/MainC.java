package y2020.kickstartrB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class MainC {
	
	static long MAX = 1000000000;

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
		
			String s = in.next();
			
			long cptH=0, cptV=0;
			LinkedList<Long> list = new LinkedList<Long>();
			long coef = 1;
			for (int i=0; i<s.length();i++) {
				char c = s.charAt(i);
				if (c == '(') continue;
				if (c == 'N') cptV -= coef;
				if (c == 'S') cptV += coef;
				if (c == 'W') cptH -= coef;
				if (c == 'E') cptH += coef;
				if (c>'1'&&c<='9') {
					list.addFirst(coef);
					int n = Integer.parseInt(s.substring(i,i+1));
					coef = (n*coef)%MAX;
				}
				cptV %= MAX;
				cptH %= MAX;
				if (c == ')') coef = list.removeFirst();
			}
			cptH += cptH < 0 ? MAX+1 : 1;
			cptV += cptV < 0 ? MAX+1 : 1;
			
			System.out.println(String.format("Case #%d: %d %d",t+1,cptH,cptV));
		}
		
		in.close();
	}

}
