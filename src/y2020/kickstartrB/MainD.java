package y2020.kickstartrB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainD {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
		
			int W = in.nextInt();
			int H = in.nextInt();
			int L = in.nextInt();
			int U = in.nextInt();
			int R = in.nextInt();
			int D = in.nextInt();

			double[] fact = new double[W+H];
			fact[0] = 0;
			for(int i=1; i<W+H; i++)
				// log2 of x!
				fact[i] = fact[i-1]+(Math.log(i)/Math.log(2));
			
			double res = 0;
			
			// upside then rightside
			if (U>1 && R<W) {
				// at least R*right before (U-1)*down
				// at least R*right out of R+U-2 moves
				int n = R+U-2;
				for (int k=R; k<=n; k++) {
					double p = fact[n]-fact[n-k]-fact[k]-n;
					res += Math.pow(2, p);
				}
			}
			// leftside then downside
			if (L>1 && D<W) {
				// similarily
				int n = D+L-2;
				for (int k=D; k<=n; k++) {
					double p = fact[n]-fact[n-k]-fact[k]-n;
					res += Math.pow(2, p);
				}
			}			
			
			System.out.println(String.format("Case #%d: %.5f",t+1,res));
		}
		
		in.close();
	}

}
