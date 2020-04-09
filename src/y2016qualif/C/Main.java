package y2016qualif.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	public static void main(String[] args) {

		//String filename = "src/y2016qualif/C-test";
		//String filename = "src/y2016qualif/C-test-small";
		//String filename = "src/y2016qualif/C-test-large";
		//String filename = "src/y2016qualif/C-small-attempt0";
		//String filename = "src/y2016qualif/C-small-attempt1";
		String filename = "src/y2016qualif/C-large";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int i=0; i<T; i++) {
				int ind = i+1;
				// parser
				String buff = in.readLine();
				String[] data = buff.split(" ");				
				int N = Integer.parseInt(data[0]);
				int J = Integer.parseInt(data[1]);
				// calcul
				String res = solve(N,J);
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+":\n"+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	static String solve (int N, int J) {
		String res = "";
		int digit[] = new int[N];
		for (int i=0; i<N; i++){
			digit[i] = 0;
		}
		digit[0]=1; digit[N-1]=1;
		
		int cpt = 0;
		
		while (cpt<J) {
			BigInteger number = BigInteger.valueOf(0);
			BigInteger pow = BigInteger.valueOf(1);
			for (int i=0; i<digit.length; i++) {
				number = number.add(BigInteger.valueOf(digit[i]).multiply(pow));
				pow = pow.multiply(BigInteger.valueOf(10));
			}
			System.out.println(number);

			String s = test(digit);
			if (s != "") {
				cpt++;
				res += s;
				System.out.println(cpt);
			}
			//nextnumber
			for (int i=1; i<N-1; i++) {
				if (digit[i] == 0){
					digit[i] = 1;
					break;
				} else {
					digit[i] = 0;
				}
			}
		}
		
		return res;
	}
	
	static String test(int[] tab) {
		String res = "";
		boolean b = true;
		for (int i=2; i<11 && b; i++) {
			//calcul du nombre
			BigInteger number = BigInteger.valueOf(0);
			BigInteger pow = BigInteger.valueOf(1);
			for (int j=0; j<tab.length; j++) {
				number = number.add(BigInteger.valueOf(tab[j]).multiply(pow));
				pow = pow.multiply(BigInteger.valueOf(i));
			}
			//test de divisibilité
			//BigInteger racine = number.Math.sqrt(number);
			boolean found = false;
			//for (long j=2; ((BigInteger.valueOf(j).pow(2)).compareTo(number) < 1) && !found; j++){
			for (long j=2; ((BigInteger.valueOf(j)).compareTo(BigInteger.valueOf(10000)) < 1) && !found; j++){
				if (found = (number.mod(BigInteger.valueOf(j)) == BigInteger.ZERO)) {
					//System.out.println (number+" "+j);
					res += " "+j;
				}
			}
			b = found;
		}
		if (b) {
			BigInteger number = BigInteger.valueOf(0);
			BigInteger pow = BigInteger.valueOf(1);
			for (int i=0; i<tab.length; i++) {
				number = number.add(BigInteger.valueOf(tab[i]).multiply(pow));
				pow = pow.multiply(BigInteger.valueOf(10));
			}
			//System.out.println(number);
			return number+res+"\n";
		}
		return "";
	}
		
}
