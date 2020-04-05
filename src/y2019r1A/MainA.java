package y2019r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int R = in.nextInt();
			int C = in.nextInt();

			if (R*C < 10)
				System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
			else {
				System.out.println("Case #"+(t+1)+": POSSIBLE");
				int a = Math.max(R, C);
				int b = Math.min(R, C);
				for (int i=0; i<b-1; i+=2) {
					for (int j=0; j<a; j++) {							
						int c1, c2;
						c1 = i +1;
						c2 = j +1;
						if (R>C)
							System.out.println(c2+" "+c1);
						else
							System.out.println(c1+" "+c2);
						c1++;
						c2 = (j+(a+1)/2)%a +1;
						if (R>C)
							System.out.println(c2+" "+c1);
						else
							System.out.println(c1+" "+c2);
						if (i == b-3) {
							c1++;
							c2 = j +1;
							if (R>C)
								System.out.println(c2+" "+c1);
							else
								System.out.println(c1+" "+c2);
						}
					}
				}
			}
		}
		in.close();
	}
}