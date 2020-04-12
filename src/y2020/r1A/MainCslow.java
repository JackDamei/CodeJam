package y2020.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainCslow {

	public static class Dancer {
		final int x;
		final int y;
		final int skill;
		Dancer north;
		Dancer south;
		Dancer west;
		Dancer east;

		public Dancer (int x, int y, int skill) {
			this.x = x;
			this.y = y;
			this.skill = skill;
		}

		public boolean willEliminate () {
			int sum = 0;
			sum += north == null ? skill : north.skill;
			sum += south == null ? skill : south.skill;
			sum += west == null ? skill : west.skill;
			sum += east == null ? skill : east.skill;
			return sum > 4*skill;
		}

		public void updateNb() {
			if (north != null)
				north.south = south;
			if (south != null)
				south.north = north;
			if (west != null)
				west.east = east;
			if (east != null)
				east.west = west;
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int R = in.nextInt();
			int C = in.nextInt();

			int[][] S = new int[R][C];
			for (int i=0; i<R; i++)
				for (int j=0; j<C; j++)
					S[i][j] = in.nextInt();

			ArrayList<Dancer> list = new ArrayList<Dancer>();
			Dancer[][] matrix = new Dancer[R][C];
			for (int i=0; i<R; i++)
				for (int j=0; j<C; j++) {
					Dancer d = new Dancer(i,j,S[i][j]);
					list.add(d);
					matrix[i][j] = d;
				}
			for (int i=0; i<R; i++)
				for (int j=0; j<C; j++) {
					Dancer d = matrix[i][j];
					d.north = i==0 ? null : matrix[i-1][j];
					d.south = i==R-1 ? null : matrix[i+1][j];
					d.west = j==0 ? null : matrix[i][j-1];
					d.east = j==C-1 ? null : matrix[i][j+1];
				}

			long interest = 0;
			boolean[][] isEliminated = new boolean[R][C];
			for (int i=0; i<R; i++)
				for (int j=0; j<C; j++)
					isEliminated[i][j] = false;
			int cpt;
			do {
				cpt = 0;
				for (Dancer d : list) {
					interest += d.skill;
					isEliminated[d.x][d.y] = d.willEliminate();
				}
				for (int i=0; i<list.size(); i++){
					Dancer d = list.get(i);
					if (isEliminated[d.x][d.y]) {
						cpt++;
						d.updateNb();
						list.remove(i);
						i--;
					}
				}
			} while (cpt > 0);

			System.out.println("Case #"+(t+1)+": "+interest);
		}
		in.close();
	}

	public static void printDF (int[][] S, boolean[][] isEliminated) {
		int R = S.length;
		int C = S[0].length;
		for (int i=0; i<R; i++) {
			String s = "";
			for (int j=0; j<C; j++)
				if (isEliminated[i][j])
					s += ". ";
				else
					s += S[i][j]+" ";
			System.out.println(s);
		}
	}

}
