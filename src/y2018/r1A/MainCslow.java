package y2018.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MainCslow {


	public static void main (String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int P = in.nextInt();
			Cookie[] cookies = new Cookie[N];
			for (int i=0; i<N; i++) {
				int W = in.nextInt();
				int H = in.nextInt();
				cookies[i] = new Cookie(W,H);
			}

			// algo
			double res = solve (N,P,cookies);

			System.out.println(String.format("Case #%d: %6f",t+1,res));
		}
		in.close();
	}


	private static double solve(int N, int P, Cookie[] cookies) {

		double total = 0;
		for (int i=0; i<N; i++)
			total += cookies[i].getPerimeter();
		double target = P-total;

		ArrayList<Interval> S = new ArrayList<Interval>();
		S.add(new Interval(0,0));

		for (int i=0; i<N; i++) {
			Interval cur = cookies[i].getInterval();

			LinkedList<Interval> list = new LinkedList<Interval>();;
			for (Interval tmp : S) {
				Interval next = Interval.add(tmp,cur);
				if (next.R >= target) {
					if (next.L < target)
						return (double) P;
				} else
					list.add(next);
			}
			while (!list.isEmpty()) {
				Interval next = list.poll();
				boolean included = false;
				for (int j=0; j<S.size(); j++) {
					Interval old = S.get(j);
					if (included = next.isIncluded(old))
						break;
					if (old.isIncluded(next))
						S.remove(j--);
				}
				if (!included)
					S.add(next);
			}
		}
		double max = 0;
		for (Interval tmp : S)
			max = Math.max(max,tmp.R);
		return total+max;
	}





	public static class Interval {
		double L, R;
		public Interval(double l, double r) {
			L = l;
			R = r;
		}
		public boolean isIncluded (Interval other) {
			return L>=other.L && R<=other.L;
		}
		public void add (Interval i) {
			L += i.L;
			R += i.R;
		}
		public static Interval add (Interval a, Interval b) {
			return new Interval(a.L+b.L, a.R+b.R);
		}
	}


	public static class Cookie {
		final int W, H;
		public Cookie(int w, int h) {
			W = w;
			H = h;
		}
		public double getPerimeter () {
			return 2*(W+H);
		}
		public Interval getInterval() {
			return new Interval(
					2*Math.min(W,H),
					2*Math.sqrt(Math.pow(W,2)+Math.pow(H,2)));
		}
	}


}
