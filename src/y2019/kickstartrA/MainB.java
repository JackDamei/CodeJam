package y2019.kickstartrA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int R = in.nextInt();
			int C = in.nextInt();
			boolean[][] isOffice = new boolean[R][C];
			for (int i=0; i<R; i++) {
				String s = in.next();
				for (int j=0; j<C; j++)
					isOffice[i][j] = s.charAt(j)=='1';
			}
			
			
			int res = 0;
			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}

