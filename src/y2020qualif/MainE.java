package y2020qualif;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainE {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			
			int N = in.nextInt();
			int K = in.nextInt();

			int[][] grid = new int[N][N];
			String res = "";
			
			// EASY CASE
			if (K%N == 0) {
				System.out.println("Case #"+(t+1)+": POSSIBLE");
				int base = K/N;
				for (int i=0; i<N; i++) {
					res = "";
					for (int j=0; j<N; j++)
						res += ((base-i+j+N-1)%N+1)+" ";
					System.out.println(res);
				}
				continue;
			} 
			// if N=3 only possible if 3, 6 or 9
			if(K==N+1 || K==N*N-1 || N==3) {
				System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
				continue;
			}
			System.out.println("Case #"+(t+1)+": POSSIBLE");				
			// find A, B, C
			int A=1, B=1, C=1;
			boolean set = false;
			while (!set) {
				if (K-(N-2)*A > 2*N) {
					A++;
					continue;
				}
				C = K-(N-2)*A-B;
				while (A==C || A==B || C>N) {
					B++;
					C--;
				}
				if (B <= N) {
					set = true;
				}
				else {
					B = 1;
					A++;
				}
			}
			//System.out.println("A="+A+" B="+B+" C="+C);
			
			if (B != C) {
				// make chain
				int[] chain = new int[N];
				chain[0] = A;
				chain[1] = B;
				chain[N-1] = C;
				int ind = 2;
				for (int i=1; i<=N; i++) {
					if (i!=A && i!=B && i!=C) {
						chain[ind] = i;
						ind++;
					}
				}
				// print
				// N-2 first lines
				for (int i=0; i<N-2; i++)
					for (int j=0; j<N; j++)
						grid[i][j] = chain[(N+j-i)%N];
				// 2 last lines
				for (int j=0; j<N; j++)
					grid[N-2][j] = chain[(j+1)%N];
				for (int j=0; j<N; j++)
					grid[N-1][j] = chain[(j+2)%N];
			} else {
				// isolate A and B
				int[] chain = new int[N-2];
				int ind=0;
				for (int i=1; i<=N; i++)
					if (i!=A && i!=B) {
						chain[ind] = i;
						ind++;
					}
				// print
				// N-2 first lines
				for (int i=0; i<N-2; i++) {
					ind = N-2-i;
					for (int j=0; j<N; j++) {
						if (j == i)
							grid[i][j] = A;
						else if (j == (i+N-1)%(N-2))
							grid[i][j] = B;
						else {
							grid[i][j] = chain[ind%(N-2)];
							ind++;
						}
					}
				}
				// 2 last lines
				grid[N-2][N-2] = B;
				grid[N-2][N-1] = A;
				grid[N-1][N-2] = A;
				grid[N-1][N-1] = B;
				grid[N-2][0] = chain[0];
				grid[N-1][0] = chain[1];
				if (N%2 == 0) {
					grid[N-2][N-3] = chain[N-3];
					grid[N-1][N-3] = chain[N-4];
				} else {
					grid[N-2][N-3] = chain[N-4];
					grid[N-1][N-3] = chain[N-3];					
				}
				for (int j=1; j<N-3; j++) {
					grid[N-2][j] = chain[j-1+(2*(j%2))];
					grid[N-1][j] = chain[j-1+(2*((j+1)%2))];
				}
			}
			// CHECKING
			int trace = 0;
			for (int i=0; i<N; i++) {
				trace += grid[i][i];
				int line = 0;
				int col = 0;
				for (int j=0; j<N; j++) {
					line += grid[i][j];
					col += grid[j][i];
				}
				if (line != (N*(N+1))/2)
					System.out.println("Error line "+i);
				if (col != (N*(N+1))/2)
					System.out.println("Error col "+i);
			}
			if (trace != K)
				System.out.println("Error trace is "+trace+" instead of "+K);
			
			
			// OUTPUT
			for (int i=0; i<N; i++) {
				res = "";
				for (int j=0; j<N; j++)
					res += grid[i][j]+" ";
				System.out.println(res);
			}
		}
		in.close();
	}
}
