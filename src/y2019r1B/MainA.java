package y2019r1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int P = in.nextInt();
			int Q = in.nextInt();

			int[] xcpt = new int[Q+1];
			int[] ycpt = new int[Q+1];
			for (int i=0; i<=Q; i++) {
				xcpt[i] = 0;
				ycpt[i] = 0;
			}

			for (int i=0; i<P; i++) {
				int x = in.nextInt();
				int y = in.nextInt();
				String dir = in.next();
				switch (dir) {
				case "E":
					for (x++; x<=Q; x++)
						xcpt[x]++;
					break;
				case "N":
					for (y++; y<=Q; y++)
						ycpt[y]++;
					break;
				case "W":
					for (x--; x>=0; x--)
						xcpt[x]++;
					break;
				case "S":
					for (y--; y>=0; y--)
						ycpt[y]++;
					break;
				}
			}

			int xmax=0, ymax=0, xval=0, yval=0;
			for (int i=0; i<=Q; i++) {
				if (xcpt[i]>xval) {
					xval=xcpt[i];
					xmax=i;
				}
				if (ycpt[i]>yval) {
					yval=ycpt[i];
					ymax=i;
				}
			}
			System.out.println("Case #"+(t+1)+": "+xmax+" "+ymax);
		}
		in.close();
	}
}