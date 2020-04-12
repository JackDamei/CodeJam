package y2020.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainB {
	
	public static class Position {
		int x;
		int y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return x+" "+y;
		}
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();

			// find last line
			int rank = 0;
			while (N >= Math.pow(2, rank+1)+rank+1)
				rank++;
			
			// select lines
			ArrayList<Position> path = new ArrayList<Position>();
			boolean side = true; // true=left, false=right
			int remainder = N-(rank+1);
			for (int i=rank; i>=0; i--) {
				if (side)
					path.add(new Position(i+1, 1));
				else
					path.add(new Position(i+1, i+1));
				if (remainder >= Math.pow(2,i)-1) {
					remainder -= Math.pow(2,i)-1;
					if (side)
						for (int j=2; j<=i+1; j++)
							path.add(new Position(i+1,j));
					else
						for (int j=i; j>0; j--)
							path.add(new Position(i+1,j));
					side = !side;
				}
			}
			Collections.reverse(path);
			// add remainder
			for (int i=0; i<remainder; i++)
				// we are in the left
				path.add(new Position(rank+2+i, 1));
			
			System.out.println("Case #"+(t+1)+":");
			for (Position p : path)
				System.out.println(p);
		}
		in.close();
	}
}
