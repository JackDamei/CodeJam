package y2010_1B.B;

public class Test {
	
	private int N;
	private int K;
	private int B;
	private int T;
	private int[] X;
	private int[] V;

	public Test(int n, int k, int b, int t, int[] x, int[] v) {
		N = n;
		K = k;
		B = b;
		T = t;
		X = x;
		V = v;
	}

	public int getResult () {
		
		int res = 0;
		int good = 0;
		int current = N;
		
		while (good < K && current > 0) {
			current--;
			if ((double)(B-X[current])/V[current] <= T) {
				good++;
			} else {
				res += K-good;
			}						
		}
		
		if (good < K) {
			return -1;
		}		
		return res;
	}
	
}