package y2018.r2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			int C = in.nextInt();
			int[] B = new int[C];
			for (int i=0; i<C; i++)
				B[i] = in.nextInt();

			if (B[0] == 0 || B[C-1] == 0) {
				out.println(String.format("Case #%d: IMPOSSIBLE", t+1));
				continue;
			}
			
			// y = max offset + 1
			int[] offset = new int[C];
			int iter = 0;
			int max = 0;
			for (int i=0; i<C; i++) {
				if (B[i] > 0) {
					for (int j=0; j<B[i]; j++) {
						offset[iter+j] = iter+j-i;
						max = Math.max(max, Math.abs(offset[iter+j]));
					}
					iter += B[i];
				}
			}
			out.println(String.format("Case #%d: %s", t+1, max+1));
			
			int[] destination = new int[C];
			for (int i=0; i<C; i++)
				destination[i] = i-offset[i];
			
			for (int i=0; i<max+1; i++) {
				String line = "";
				if (i == max)
					for (int j=0; j<C; j++)
						line += ".";
				else {
					int[] tmp = destination.clone();
					for (int j=0; j<C; j++) {
						int d = tmp[j];
						if (j == d) {
							line += ".";
						} else if (j < d) {
							line += "\\";
							destination[j+1] = d;
						} else {
							line += "/";
							destination[j-1] = d;
						}
					}
				}
				out.println(line);
			}
		}
		
		in.close();
	}
	
}
