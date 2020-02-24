package y2015qualif.dijkstra;

public class TestDijkstra {

	private int L;
	private long X;
	private char[] str;

	public TestDijkstra(int l, long x, char[] str) {
		super();
		L = l;
		X = x;
		this.str = str;
	}

	public String getResult() {

		long nbTours;
		
		if (X <= 12) {
			nbTours = X;
		} else {
			nbTours = ((X-12)%4 + 12);
		}
		
		int state = 0;

		Quat current = Quat.one;

		for (long i=0; i<nbTours; i++) {
			for (int j=0; j<L; j++) {
				current = DijkstraTools.mult(current,DijkstraTools.toQuat(str[j]));
				switch (state) {
				case 0:
					if (current == Quat.i) {
						state++;
						current = Quat.one;
					}
					break;
				case 1:
					if (current == Quat.j) {
						state++;
						current = Quat.one;
					}
					break;
				default:
				}
			}
		}
		
		if ((state == 2) && (current == Quat.k))
			return "YES";
		return "NO";
	}

}
