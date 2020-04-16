package y2019.r2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
		
			int N = in.nextInt();
			int[][] molecules = new int[N][2];
			for (int i=0; i<N; i++) {
				molecules[i][0] = in.nextInt();
				molecules[i][1] = in.nextInt();
			}
			
			
			System.out.println(String.format("Case #%d:",t+1));
		}
		
		in.close();
	}
	
}
