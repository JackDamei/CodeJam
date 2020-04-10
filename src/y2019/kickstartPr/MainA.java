package y2019.kickstartPr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			
			int A = in.nextInt();
			int B = in.nextInt();
			int N = in.nextInt();
			
			boolean found = false;
			int a=A, b=B;
			for (int i=0; i<N && !found; i++) {
				int guess = (a+b)/2;
				System.out.println(guess);
				String answer = in.next();
				switch (answer) {
				case "CORRECT":
					found = true;
					break;
				case "TOO_BIG":
					b = guess-1;
					break;
				case "TOO_SMALL":
					a = guess+1;
					break;
				}
			}
			if (!found)
				break;
			
		}
		in.close();
	}
}
