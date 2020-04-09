package y2015qualif.houseofpancakes;

public class TestPancakes {

	private int[] stats;
	private int max;

	public TestPancakes(int D, int[] s) {
		max = 0;
		stats = new int[1001];
		for (int i=0; i<1001; i++)
			stats[i] = 0;
		for (int i=0; i<D; i++) {
			max = Math.max(max, s[i]);
			stats[s[i]]++;
		}
	}
/*
	private static void test3(final Scanner sc, final PrintWriter pw) {
		final int D = sc.nextInt();
		List<Integer> nums = new ArrayList<Integer>();
		for (int i = 0; i < D; i++) {
			nums.add(sc.nextInt());
		}
		int max = Collections.max(nums);
		int bt = max;
		for (int m = 1; m <= max; m++) {
			System.out.println("for m = " + m);
			int t = m;
			for (int k : nums) {
				if (k != 0)
					t += (k % m == 0) ? (k / m) - 1 : k / m;
			}
			System.out.println("t = " + t);
			if (t < bt) {
				bt = t;
			}
		}
		pw.print(bt);
	}
*/
	
	public int getResult() {

		int res = max;
		for (int i=1; i<=max; i++) {
			int tmp=i;
			for (int j=1; j<=max; j++) {
				tmp += stats[j]*((j-1)/i);
			}
			res = Math.min(res,tmp);
		}
		
		return res;
	}
	
}