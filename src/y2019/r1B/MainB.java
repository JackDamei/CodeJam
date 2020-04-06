package y2019.r1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class MainB {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
		@SuppressWarnings("unused")
		int W = in.nextInt();

		for (int t=0; t<T; t++) {
			int D1 = 56;
			int D2 = 210;
			int a, b, c, d, e, f;
			BigInteger pow = BigInteger.valueOf(2);

			System.out.println(D2);
			BigInteger S2 = in.nextBigInteger();
			d = S2.divide(pow.pow(D2/4)).mod(pow.pow(7)).intValue();
			e = S2.divide(pow.pow(D2/5)).mod(pow.pow(7)).intValue();
			f = S2.divide(pow.pow(D2/6)).mod(pow.pow(7)).intValue();

			System.out.println(D1);
			BigInteger S1 = in.nextBigInteger();
			S1 = S1.subtract(BigInteger.valueOf(d).multiply(pow.pow(D1/4)));
			a = S1.divide(pow.pow(D1)).intValue();
			b = S1.divide(pow.pow(D1/2)).mod(pow.pow(7)).intValue();
			c = S1.divide(pow.pow(D1/3)).mod(pow.pow(7)).intValue();

			System.out.println(a+" "+b+" "+c+" "+d+" "+e+" "+f);
			
			if (in.nextInt() == -1) {
				in.close();
				return;
			}
		}
		in.close();
	}
}