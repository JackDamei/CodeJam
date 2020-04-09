package y2015qualif.xominos;

public class TestXominos {

	private int X;
	private int R;
	private int C;

	public TestXominos(int x, int r, int c) {
		X = x;
		R = r;
		C = c;
	}

	public String getResult() {

		if ((X<7)&&((C*R)%X == 0) && (((R>=X)&&(C>=X-1)) || ((R>=X-1)&&(C>=X))))
			return "GABRIEL";
		
		return "RICHARD";
	}

	public String test(int X, int R, int C) {

		if (X >= 7 || (R * C) % X != 0) {
			return "RICHARD";
		} else {
			if (X == 1 || X == 2 || (X == 3 && (R != 1 && C != 1)) || (X == 4 && (R >= 4 && C > 2 || C >= 4 && R > 2))
					|| (X == 5 && ((R >= 4 && C >= 4) || (R == 3 && C >= 10 || R >= 10 && C == 3)))
					|| (X == 6 && (R >= 4 && C >= 4 && (R >= 6 || C >= 6)))) {
				return("GABRIEL");
			} else {
				return("RICHARD");
			}

		}
	}

		/*
	public String test() {

		if ((C*R)%X != 0)
			return "RICHARD";
		if (X >= R*C)
			return "RICHARD";
		if (X < 3)
			return "GABRIEL";
		if (X > 6)
			return "RICHARD";
		if ((X > R) && (X > C)) {
			return "RICHARD";
		}
		if ((R == 1) || (C == 1))
			return "RICHARD";
		if ((X >= 4) && ((R == 2) || (C == 2)))
			return "RICHARD";


		return "GABRIEL";

	}
*/
}
