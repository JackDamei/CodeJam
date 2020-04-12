package y2020.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class MainC {

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

			long sum = 0;
			LinkedList<Dancer> candidates = new LinkedList<Dancer>();
			Dancer[][] matrix = new Dancer[R][C];
			for (int i=0; i<R; i++)
				for (int j=0; j<C; j++) {
					Dancer d = new Dancer(i,j,S[i][j]);
					candidates.add(d);
					matrix[i][j] = d;
					sum += d.skill;
				}
			for (int i=0; i<R; i++)
				for (int j=0; j<C; j++) {
					Dancer d = matrix[i][j];
					d.north = i==0 ? null : matrix[i-1][j];
					d.south = i==R-1 ? null : matrix[i+1][j];
					d.west = j==0 ? null : matrix[i][j-1];
					d.east = j==C-1 ? null : matrix[i][j+1];
				}

			boolean[][] eliminated = new boolean[R][C];
			for (int i=0; i<R; i++)
				Arrays.fill(eliminated[i], false);
			
			long interest = 0;
			while (!candidates.isEmpty()) {
				interest += sum;

				LinkedList<Dancer> eliminations = new LinkedList<Dancer>();
				while (!candidates.isEmpty()) {
					Dancer d = candidates.poll();
					if(d.willEliminate())
						eliminations.add(d);
				}
				
				while (!eliminations.isEmpty()) {
					Dancer d = eliminations.poll();
				
					if (eliminated[d.x][d.y])
						continue;
					eliminated[d.x][d.y] = true;
					
					sum -= d.skill;
					
					if (d.north != null) {
						d.north.south = d.south;
						candidates.add(d.north);
					}
					if (d.south != null) {
						d.south.north = d.north;
						candidates.add(d.south);
					}
					if (d.west != null) {
						d.west.east = d.east;
						candidates.add(d.west);
					}
					if (d.east != null) {
						d.east.west = d.west;
						candidates.add(d.east);
					}
				}
			}

			System.out.println("Case #"+(t+1)+": "+interest);
		}
		in.close();
	}
	
}
