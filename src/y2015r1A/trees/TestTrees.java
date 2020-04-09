package y2015r1A.trees;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestTrees {

	private int N;
	private Point[] s;

	public TestTrees(int n, Point[] s) {
		N = n;
		this.s = s;
	}

	public int[] getResult_small () {
		int[] res = new int[N];
		for (int i=0; i<N; i++)
			res[i] = 0;

		if (N < 4)
			return res;

		for (int i=0; i<N; i++) {
			// pour chaque arbre, partir de chaque arbre et regarder à 180° à gauche et à droite
			Point current = s[i];
			int min = Integer.MAX_VALUE;
			for (int j=0; j<N; j++) {
				if (i==j) continue;
				Point target = s[j];
				Point line = new Point(target.x-current.x, target.y-current.y);
				int left = 0;
				int right = 0;
				for (int k=0; k<N; k++) {
					if (k==i || k==j) continue;
					Point looking = s[k];
					Point vector = new Point(looking.x-current.x, looking.y-current.y);
					long det = this.det(line,vector);
					if (det > 0)
						left++;
					if (det < 0)
						right++;
				}
				min = Math.min(min, Math.min(left, right));
			}
			res[i] = min;
		}

		return res;
	}

	public int[] getResult_large () {
		int[] res = new int[N];
		for (int i=0; i<N; i++)
			res[i] = 0;

		if (N < 4)
			return res;

		for (int i=0; i<N; i++) { 
			System.out.println(i);
//		int i=2;
			// pour chaque arbre, partir de chaque arbre et regarder à 180° à gauche et à droite
			Point current = s[i];
			Point line = null;
			ArrayList<AngleInfo> list = new ArrayList<AngleInfo>(N-1);
			int min = Integer.MAX_VALUE;
			//			System.out.println("NEW");
			boolean first = true;
			for (int j=0; j<N; j++) {
				if (i==j) continue;
				Point p = s[j];
				if (first) {
					first = false;
					line = new Point(p.x-current.x, p.y-current.y);
					list.add(new AngleInfo(line,0));
					continue;
				}
				Point vector = new Point(p.x-current.x, p.y-current.y);
				double angle = getAngle(line, vector);
//								System.out.println(angle/Math.PI);
				list.add(new AngleInfo(vector,angle));
			}
			Collections.sort(list, new AngleComparator());

			//effectuer la recherche
			int s_left = -1, e_left = -1, s_right = -1, e_right = -1;
			for (int j=0; j<N-1; j++) {

				AngleInfo ai = list.get(j);
//								System.out.println(ai.p+" "+ai.angle);
//							System.out.println("AI: "+ai.p+" "+det(ai.p,ai.p));
//				for (int bla=1; bla<N-1; bla++)
//								System.out.println(list.get((j+bla)%(N-1)).p+" "+det(ai.p,list.get((j+bla)%(N-1)).p));

				if (s_left == -1) s_left = incr(j, N-1);
				while (det(ai.p,list.get(s_left).p) == 0
						&& (list.get(s_left).angle - ai.angle + 2*Math.PI)%(2*Math.PI) < Math.PI/2.) {
					s_left = incr(s_left, N-1);
					if (s_left == j) break; // cas où ils sont alignés
				}
//								System.out.println("s_left = "+s_left);
//								System.out.println(det(ai.p,list.get(s_left).p));

				if (e_left == -1) e_left = s_left;
				while (det(ai.p,list.get(e_left).p) > 0) {
					e_left = incr(e_left, N-1);
				}
//								System.out.println("e_left = "+e_left);
//								System.out.println(det(ai.p,list.get(e_left).p));

				if (s_right == -1)	s_right = e_left;
				while (det(ai.p,list.get(s_right).p) >= 0
						&& (list.get(s_right).angle - ai.angle - 2*Math.PI)%(2*Math.PI) < -Math.PI/2.) {
					s_right = incr(s_right, N-1);
				}
//								System.out.println("s_right = "+s_right);
//								System.out.println(det(ai.p,list.get(s_right).p));

				if (e_right == -1) e_right = s_right;
				while (det(ai.p,list.get(e_right).p) < 0) {
					e_right = incr(e_right, N-1);
				}
//				System.out.println("e_right = "+e_right);
//				System.out.println(det(ai.p,list.get(e_right).p));

				min = Math.min(min, Math.min((e_left-s_left+N-1)%(N-1), (e_right-s_right+N-1)%(N-1)));
//								System.out.println("MIN = "+min);
			}
			res[i] = min;
		}

		return res;
	}

	public int incr (int prec, int end) {
		int res = prec+1;
		if (res == end)
			res = 0;
		return res;
	}

	public int getN() {
		return N;
	}

	public double getAngle (Point a, Point b) {
		double nA = Math.sqrt(Math.pow(a.x,2)+Math.pow(a.y,2));
		double nB = Math.sqrt(Math.pow(b.x,2)+Math.pow(b.y,2));
//		System.out.println(nA+" "+nB);
		double aNormX = ((double)a.x)/nA;
		double aNormY = ((double)a.y)/nA;
		double bNormX = ((double)b.x)/nB;
		double bNormY = ((double)b.y)/nB;
//		System.out.println(aNormX+" "+aNormY+" "+bNormX+" "+bNormY);
		double scalProd = aNormX*bNormX + aNormY*bNormY;
		if (scalProd > 1) scalProd = 1;
		if (scalProd < -1) scalProd = -1;
//		System.out.println(scalProd);
		long det = this.det(a, b);
		double angle = Math.acos(scalProd);
		if (Math.signum(det) != 0)
			angle *= Math.signum(det);
		return angle;
	}

	private long det (Point a, Point b) {
		return (long)a.x*(long)b.y - (long)a.y*(long)b.x;
	}

	private class AngleInfo {
		public final Point p;
		public final double angle;
		public AngleInfo (Point p, double angle) {
			this.p = p;
			this.angle = angle;
		}
	}

	private class AngleComparator implements Comparator<AngleInfo> {
		@Override
		public int compare(AngleInfo a1, AngleInfo a2) {
			if (a1.angle > a2.angle)
				return 1;
			if (a1.angle < a2.angle)
				return -1;
			return 0;
		}
	}

}