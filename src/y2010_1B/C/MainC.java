package y2010_1B.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MainC {

	public static void main(String[] args) {

		//String filename = "src/y2010_1B/input-C";
		//String filename = "src/y2010_1B/C-small-practice";
		String filename = "src/y2010_1B/C-large-practice";

		FileInputStream file;
		int MAX = 512;
		int modulo = 100003;
		int T;
		long[][] r = new long[MAX][MAX];
		long[][] cnk = new long[MAX][MAX];


		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			String buff = in.readLine();
			T = Integer.parseInt(buff);

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			// binôme de Newton ou Cnk combinaison
			for (int i=0; i<MAX; i++) {
				for (int j=0; j<MAX; j++) {
					if (i<j)
						cnk[i][j] = 0;
					else if (i==j || j==0)
						cnk[i][j] = 1;
					else
						cnk[i][j] = (cnk[i-1][j]+cnk[i-1][j-1])%modulo;
				}
			}
			for (int i=2; i<MAX; i++) {
				r[i][1] = 1;
			}
			for (int i=2; i<MAX; i++) {
				for (int j=2; j<i; j++) {
					for (int k=1; k<j; k++) {
						r[i][j] += r[j][k]*cnk[i-j-1][j-k-1];
						r[i][j] %= modulo;
					}
				}
			}

			for (int i=0; i<T; i++) {
				int ind = i+1;
				int N = Integer.parseInt(in.readLine());
				int res = 0;
				for (int j=1; j<N; j++) {
					res += r[N][j];
					res %= modulo;
				}
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();





		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}
