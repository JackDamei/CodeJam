package y2015qualif.standingovation;

public class TestStandingOvation {

	private int Smax;
	private int[] S;

	public TestStandingOvation(int smax, int[] s) {
		super();
		Smax = smax;
		S = s;
	}

	public int getSmax() {
		return Smax;
	}

	public void setSmax(int smax) {
		Smax = smax;
	}

	public int[] getS() {
		return S;
	}

	public void setS(int[] s) {
		S = s;
	}
	
	
	public int getNumberInvited() {
		int cpt = 0;
		int total = 0;
		
		for (int i=0; i<Smax+1; i++) {
			if (total < i) {
				cpt += i-total;
				total += i-total;
			}
			total += S[i];
		}
		
		return cpt;
	}
	
	
}
