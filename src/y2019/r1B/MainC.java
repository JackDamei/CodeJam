package y2019.r1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainC {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			System.out.println("Case #"+(t+1)+": ");
		}
		in.close();
	}
}
