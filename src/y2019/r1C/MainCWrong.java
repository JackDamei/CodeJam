package y2019.r1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainCWrong {

	public static int[][][][] states;
	public static char[][] matrix;
	
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int R = in.nextInt();
			int C = in.nextInt();
			matrix = new char[R][C];
			
			// memorize all game states
			states = new int[R][R][C][C];
			for (int rS=0; rS<R; rS++)
				for (int rE=rS; rE<R; rE++)
					for (int cS=0; cS<C; cS++)
						for (int cE=0; cE<C; cE++)
							states[rS][rE][cS][cE] = -1;
			
			for (int i=0; i<R; i++) {
				String s = in.next();
				for (int j=0; j<C; j++)
					matrix[i][j] = s.charAt(j);
			}

			int res = solve(0,R-1,0,C-1);
			
			System.out.println("Case #"+(t+1)+": "+res);
		}
		
		in.close();
	}
	
	public static int solve (int rS, int rE, int cS, int cE) {
		
		// if empty grid ... losing state
		if (rE < rS || cE < cS)
			return 0;
		
		int res;
		
		// if already done, get result
		if ((res = states[rS][rE][cS][cE]) != -1)
			return res;
		
		res = 0;
		for (int r=rS; r<=rE; r++) {
			boolean isLegal = true;
			for (int c=cS; c<=cE && isLegal; c++)
				if (matrix[r][c] == '#')
					isLegal = false;
			if (isLegal) {
				int s1 = solve(rS,r-1,cS,cE);
				int s2 = solve(r+1,rE,cS,cE);
				if (s1+s2 == 0 || s1*s2>0)
					res += cE-cS+1;
			}
		}
		for (int c=cS; c<=cE; c++) {
			boolean isLegal = true;
			for (int r=rS; r<=rE && isLegal; r++)
				if (matrix[r][c] == '#')
					isLegal = false;
			if (isLegal) {
				int s1 = solve(rS,rE,cS,c-1);
				int s2 = solve(rS,rE,c+1,cE);
				if (s1+s2==0 || s1*s2>0)
					res += rE-rS+1;
			}
		}
		
		// update data
		states[rS][rE][cS][cE] = res;
		return res;
	}
	
}
