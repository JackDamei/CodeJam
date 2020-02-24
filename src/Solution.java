import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
				
		for (int t=0; t<T; t++) {

			int R = in.nextInt();
			int C = in.nextInt();
			int H = in.nextInt();
			int V = in.nextInt();
			char[][] grid = new char[R][C];			
			int[] Rcount = new int[R];
			int[] Ccount = new int[C];
			int count = 0;
			boolean possible = true;
			
			for (int i=0; i<R; i++) {
				String s = in.next();
				for (int j=0; j<C; j++) {
					grid[i][j] = s.charAt(j);
					if (grid[i][j] == '@') {
						count++;
						Rcount[i]++;
						Ccount[j]++;
					}
				}
			}
			
			// total verification
			if (count % (H+1)*(V+1) != 0) {
				possible = false;
			}
			
			// horizontal verification
			int target = count/(H+1);
			int row = 0;
			int sum = 0;
			for (int i=0; i<H && possible; i++) {
				while (sum < target) {
					sum += Rcount[row];
					row++;
				}
				if (sum > target) {
					possible = false;					
				}
			}
			
			// vertical verification
			target = count/(V+1);
			int column = 0;
			sum = 0;
			for (int i=0; i<H && possible; i++) {
				while (sum < target) {
					sum += Ccount[column];
					column++;
				}
				if (sum > target) {
					possible = false;
				}
			}

			// cell verification
			
			
			if (possible)
				System.out.println("Case #"+(t+1)+": POSSIBLE");					
			else
				System.out.println("Case #"+(t+1)+": IMPOSSIBLE");
		}
		
		in.close();
	}

}
