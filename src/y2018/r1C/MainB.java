package y2018.r1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MainB {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();

			Lollipop[] list = new Lollipop[N];
			for (int i=0; i<N; i++)
				list[i] = new Lollipop(i);

			ArrayList<Lollipop> rank = new ArrayList<Lollipop>();

			for (int i=0; i<N; i++) {
				// for each customer

				// D=-1 if error
				int D = in.nextInt();
				if (D == -1) {
					in.close();
					return;
				}
				
				rank.clear();
				for (int j=0; j<D; j++) {
					int x = in.nextInt();
					list[x].cpt++;
					if (!list[x].sold)
						rank.add(list[x]);
				}
				
				if (rank.size() > 0) {
					rank.sort(Lollipop.getComparator());
					int min = rank.get(0).cpt;
					int cpt=0;
					for (int j=0; j<rank.size(); j++) {
						if (rank.get(j).cpt == min)
							cpt++;
						else
							break;
					}
					int ind = (int) (Math.random()*cpt);
					int id = rank.get(ind).id;
					System.out.println(id);
					list[id].sold = true;
				} else {
					System.out.println(-1);					
				}				
			}

		}

		in.close();
	}

	public static class Lollipop {
		final int id;
		int cpt;
		boolean sold;
		public Lollipop(int id) {
			this.id = id;
			cpt = 0;
			sold = false;
		}
		public static class LComparator  implements Comparator<Lollipop> {
			@Override
			public int compare(Lollipop a, Lollipop b) {
				return a.cpt-b.cpt;
			}
		}
		public static LComparator getComparator() {
			return new LComparator();
		}
	}
}
