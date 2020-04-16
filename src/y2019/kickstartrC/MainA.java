package y2019.kickstartrC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int R = in.nextInt();
			int C = in.nextInt();
			int Sr= in.nextInt();
			int Sc = in.nextInt();

			String instructions = in.next();
			
			int r = Sr;
			int c = Sc;
			for (int i=0; i<N; i++) {
				char dir = instructions.charAt(i);
				
				boolean zad = dir == 'W';
			
			}
			
			System.out.println(String.format("Case #%d: %d %d",t+1,r,c));
		}

		in.close();
	}

}
