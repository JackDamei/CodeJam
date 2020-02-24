package y2010_1B.A;

public class TestA {
	
	private int N;
	private int M;
	private String[] s;

	public TestA(int n, int m, String[] s) {
		N = n;
		M = m;
		this.s = s;
	}

	public int getResult () {
		
		int res = 0;
		Node root = new Node("root");
		
		for (int i=0; i<N; i++) {
			String[] buff = s[i].split("/");
			Node current = root;
			for (int j=1; j<buff.length; j++) {
				int indice = current.contains(buff[j]);
				if (indice == -1)
					current = current.addSon(buff[j]);
				else
					current = current.getSons().get(indice);
			}
		}
		for (int i=N; i<N+M; i++) {
			String[] buff = s[i].split("/");
			Node current = root;
			for (int j=1; j<buff.length; j++) {
				int indice = current.contains(buff[j]);
				if (indice == -1) {
					current = current.addSon(buff[j]);
					res++;
				} else
					current = current.getSons().get(indice);
			}
		}
		
		return res;
	}
	
}