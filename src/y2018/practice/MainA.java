package y2018.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			
			int A = in.nextInt();
			int B = in.nextInt();
			@SuppressWarnings("unused")
			int N = in.nextInt();

			boolean correct = false;
			int a=A;
			int b=B;
			while (!correct) {
				int half = (a+b)/2;
				System.out.println(half);
				String ans = in.next();
				switch (ans) {
				case "CORRECT":
					correct = true;
					break;
				case "TOO_BIG":
					b = half-1;
					break;
				case "TOO_SMALL":
					a = half+1;
					break;
				}
			}
			
		}

		in.close();
	}

}
