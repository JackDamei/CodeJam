package y2010_1C.C;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		//String filename = "src/y2010_1C/input-C";
		//String filename = "src/y2010_1C/C-small-practice";
		String filename = "src/y2010_1C/C-large-practice";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));


			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));


			for (int i=0; i<T; i++) {
				int ind = i+1;

				/* parser */
				int M, N;
				String[] data = in.readLine().split(" ");
				M = Integer.parseInt(data[0]);
				N = Integer.parseInt(data[1]);

				int[][] table = new int[M][N];

				for (int j=0; j<M; j++) {
					char[] line = in.readLine().toCharArray();
					for (int k=0; k<(N/4); k++) {
						int digit = Character.digit(line[k],16);
						table[j][4*k] = digit/8;
						table[j][4*k+1] = (digit/4)%2;
						table[j][4*k+2] = (digit/2)%2;
						table[j][4*k+3] = digit%2;
					}
				}

				String res = solve (M,N,table);

				System.out.print("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res);
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int search (int x, int y, int n, int[][] t) {
		boolean b = true;
		int base = t[x][y];
		for (int i=0; i<n && b; i++) {
			for (int j=0; j<n && b; j++) {
				if (t[x+i][y+j] != (base+i+j)%2)
					b = false;
			}
		}
		return b ? 1 : 0;
	}

	public static String solve (int M, int N, int[][] table) {

		int cpt = 0;
		String res = "";

		for (int n=Math.min(M, N); n>=0; n--) {
			int tmp = 0;
			for (int i=0; i<M; i++) {
				if (i > M-n)
					break;
				for (int j=0; j<N; j++) {
					if (j > N-n)
						break;
					if (table[i][j] == -1)
						continue;
					int good = search(i,j,n,table);
					if (good == 1) {
						tmp++;
						for (int x=i; x<i+n; x++)
							for (int y=j; y<j+n; y++)
								table[x][y] = -1;
					}
				}
			}
			if (tmp > 0) {
				res += n+" "+tmp+"\n";
				cpt++;
			}
		}
		
		res = cpt+"\n"+res;

		return res;
	}

}