package y2017qualif;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MainC {

	public static void main(String[] args) {

		//String filename = "src/y2017qualif/C-test";
		//String filename = "src/y2017qualif/C-small-1-attempt0";
		//String filename = "src/y2017qualif/C-small-2-attempt0";
		String filename = "src/y2017qualif/C-large";

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
				String[] buff = (in.readLine()).split(" ");
				long N = Long.parseLong(buff[0]);
				long K = Long.parseLong(buff[1]);

				// calcul
				long[] pow = new long[61];
				long p = 1;
				for (int j=0; j<61; j++) {
					pow[j] = p;
					p*=2;
				}
				
				String res = solve(N,K,pow);

				//System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	static String solve (Long N, Long K, long[] pow) {
	
		int i=0;
		while (pow[i] <= K)
			i++;

		int p=i;
		long e = (N-(pow[p-1]-1))/pow[p-1];
		long r = (N-(pow[p-1]-1))%pow[p-1];
		long S = K-(pow[p-1]-1);
		long ecart = e;
		if (S <= r)
			ecart++;
		long min, max;
		min = (ecart-1)/2;
		max = ecart-1-min;
		return max+" "+min;
	}

}

