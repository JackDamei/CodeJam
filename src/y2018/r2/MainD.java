package y2018.r2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class MainD {

	public static class Pattern {
		int R, C;
		ArrayList<Integer> set;
		int north = Integer.MIN_VALUE;
		int south = Integer.MAX_VALUE;
		int west = Integer.MIN_VALUE;
		int east = Integer.MAX_VALUE;
		public Pattern(int R, int C) {
			set = new ArrayList<Integer>();
			this.R = R;
			this.C = C;
		}
		public void add (int cell) {
			set.add(cell);
			north = Math.min(north, cell/C);
			south = Math.max(south, cell/C);
			west = Math.min(west, cell%C);
			east = Math.max(east, cell%C);
		}
	}

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		PrintStream out = System.out;
		int T = in.nextInt();
			
		for (int t=0; t<T; t++) {
			
			int R = in.nextInt();
			int C = in.nextInt();
			char[][] start = new char[R][C];
			for (int i=0; i<R; i++)
				start[i] = in.next().toCharArray();
			
			int res = solve(R,C,start);
			out.println(String.format("Case #%d: %s", t+1, res));
		}
		
		in.close();
	}

	public static int solve (int R, int C, char[][] start) {
	
		ArrayList<Pattern> patterns = new ArrayList<Pattern>();
		
		// finding all patterns using depth-searching
		LinkedList<Integer> list = new LinkedList<Integer>();
		int[][] info = new int[R][C];
		for (int i=0; i<R*C; i++)
			list.add(i);
		
		int cptB=0, cptW=0;
		while (!list.isEmpty()) {
			int cell = list.pollLast();
			int r = cell/C;
			int c = cell%C;
			if (info[r][c] != 0)
				continue;
			
		}
		
		// adding W on at most 2 adjacent edges or on a corner

		
		
		// same with inverted colors
		return 0;
	}
	
}
