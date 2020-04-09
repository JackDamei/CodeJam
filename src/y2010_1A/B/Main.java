package y2010_1A.B;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		String filename = "src/y2010_1A/input-B";
		//String filename = "src/y2010_1A/B-small-practice";
		//String filename = "src/y2010_1A/B-large-practice";

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
				int N, K;
				String[] buff = in.readLine().split(" ");
				N = Integer.parseInt(buff[0]);
				K = Integer.parseInt(buff[1]);
				char[][] c = new char[N][N];

				for (int j=0; j<N; j++) {
					char[] tmp = in.readLine().toCharArray();
					int k, alt = 0;
					for (k=N-1; k>=0; k--)
						if (tmp[k] != '.') {
							c[j][alt] = tmp[k];
							alt++;
						}
					for (; alt<N; alt++)
						c[j][alt] = '.';
					//System.out.println(String.valueOf(c[j]));
				}
				
				boolean blue = false, red = false;
				
				char player = 'B';
				for (int j=0; j<N && !blue; j++) {
					for (int k=0; k<N && !blue; k++) {
						boolean b1=true, b2=true, b3=true, b4=true;
						for (int l=0; l<K && (b1 || b2 || b3 || b4); l++) {
							b1 = verify(b1, player, j, k+l, c, N);
							b2 = verify(b2, player, j+l, k, c, N);
							b3 = verify(b3, player, j+l, k+l, c, N);
							b4 = verify(b4, player, j+l, k-l, c, N);
						}
						blue = (b1 || b2 || b3 || b4);
					}
				}
				player = 'R';
				for (int j=0; j<N && !red; j++) {
					for (int k=0; k<N && !red; k++) {
						boolean b1=true, b2=true, b3=true, b4=true;
						for (int l=0; l<K && (b1 || b2 || b3 || b4); l++) {
							b1 = verify(b1, player, j, k+l, c, N);
							b2 = verify(b2, player, j+l, k, c, N);
							b3 = verify(b3, player, j+l, k+l, c, N);
							b4 = verify(b4, player, j+l, k-l, c, N);
						}
						red = (b1 || b2 || b3 || b4);
					}
				}
				// result
				String res;
				if (blue && red)
					res = "Both";
				else if (blue)
					res = "Blue";
				else if (red)
					res = "Red";
				else
					res = "Neither";
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int solve () {
		return 0;
	}

	public static boolean verify (boolean b, char player, int i, int j, char[][] c, int size) {
//		System.out.println (b && i>=0 && i<size && j>=0 && j<size && c[i][j]==player);
		return (b && i>=0 && i<size && j>=0 && j<size && c[i][j]==player);
	}
	
}
