package y2019qualif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class MainC {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			@SuppressWarnings("unused")
			BigInteger N = in.nextBigInteger();
			int L = in.nextInt();

			BigInteger coded[] = new BigInteger[L];
			BigInteger table[] = new BigInteger[26];
			BigInteger message[] = new BigInteger[L+1];
			int stored = 0;

			// storing all numbers
			for (int i=0; i<L; i++)
				coded[i] = in.nextBigInteger();

			// check the first pgcd (where 2 numbers are not equal)
			int i=0;
			while (coded[i].equals(coded[i+1]))
				i++;
			message[i+1] = coded[i].gcd(coded[i+1]);

			// separating factors
			// (backwards then forwards)
			for (int j=i; j>=0; j--)
				message[j] = coded[j].divide(message[j+1]);
			for (; i<L; i++)
				message[i+1] = coded[i].divide(message[i]);			

			// sorting primes
			BigInteger tmp[] = Arrays.copyOf(message,message.length);
			Arrays.sort(tmp);

			table[stored] = tmp[0];
			stored++;
			i=1;
			while (stored < 26) {
				if (!tmp[i].equals(tmp[i-1])) {
					table[stored] = tmp[i];
					stored++;
				}
				i++;
			}

			// decoding
			String res = "";
			for (i=0; i<message.length; i++)
				res += " "+message[i]+" ";
			char c = 'A';
			for (i=0; i<26; i++) {
				res = res.replaceAll(" "+table[i]+" ", c+"");
				c++;
			}
			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();

	}

}