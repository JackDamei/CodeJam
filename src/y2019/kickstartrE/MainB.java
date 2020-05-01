package y2019.kickstartrE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class MainB {

	public static class Slot {
		public double C;
		public double E;
		public Slot (int c, int e) {
			C = c;
			E = e;
		}
		public double getRatio () {
			return E != 0 ? C/E : Double.POSITIVE_INFINITY;
		}
	}
	public static class SlotComparator implements Comparator<Slot> {
		public int compare (Slot a, Slot b) {
			return Double.compare(a.getRatio(),b.getRatio());
		}
	}

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintStream out = System.out;

		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int D = in.nextInt();
			int S = in.nextInt();

			ArrayList<Slot> slots = new ArrayList<Slot>(S);
			int[] A = new int[D];
			int[] B = new int[D];
			for (int i=0; i<S; i++)
				slots.add(new Slot(in.nextInt(),in.nextInt()));
			for (int i=0; i<D; i++) {
				A[i] = in.nextInt();
				B[i] = in.nextInt();
			}

			Collections.sort(slots, new SlotComparator());
			double baseC=0, baseE=0;
			for (Slot s : slots) {
				if (s.getRatio() > 1)
					baseC += s.C;
				else if (s.getRatio() < 1)
					baseE += s.E;
				else {
					baseC += s.C/2;
					baseE += s.E/2;
				}
			}

			String res = "";
			for (int d=0; d<D; d++)
				res += solve(slots,baseC,baseE,A[d],B[d]);

			out.println(String.format("Case #%d: %s",t+1,res));
		}

		in.close();
	}

	private static char solve(ArrayList<Slot> slots, double baseC, double baseE, int targetC, int targetE) {
		if (baseC>=targetC && baseE>=targetE) return 'Y';
		if (baseC<targetC && baseE<targetE)	return 'N';
		int S = slots.size();
		double tmpC=baseC, tmpE=baseE;
		if (baseC < targetC) {
			for (int i=0; i<S; i++) {
				Slot s = slots.get(i);
				double ratio = s.getRatio();
				if (ratio > 1)
					continue;
				if (ratio == 1) {
					if (tmpE-s.E/2 < targetE) {
						double x = 2*(tmpE-targetE)/s.E;
						tmpC += s.C/x;
						return tmpC>=targetC ? 'Y' : 'N';
					} else {
						tmpE -= s.E/2;
						tmpC += s.C/2;
						if (tmpC >= targetC)
							return 'Y';
					}
				} else {
					if (tmpE-s.E < targetE) {
						double x = (tmpE-targetE)/s.E;
						tmpC += s.C/x;
						return tmpC>=targetC ? 'Y' : 'N';						
					} else {
						tmpE -= s.E;
						tmpC += s.C;
						if (tmpC >= targetC)
							return 'Y';
					}
				}
			}
		} else {
			for (int i=S-1; i>=0; i--) {
				Slot s = slots.get(i);
				double ratio = s.getRatio();
				if (ratio < 1)
					continue;
				if (ratio == 1) {
					if (tmpC-s.C/2 < targetC) {
						double x = 2*(tmpC-targetC)/s.C;
						tmpE += s.E/x;
						return tmpE>=targetE ? 'Y' : 'N';
					} else {
						tmpC -= s.C/2;
						tmpE += s.E/2;
						if (tmpE >= targetE)
							return 'Y';
					}
				}
			}
		}
		return 'N';
	}

}
