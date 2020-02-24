package y2015qualif.dijkstra;

public class DijkstraTools {


	public static Quat getOpposite (Quat q) {		
		switch (q) {
		case one:
			return Quat.mone;
		case i:
			return Quat.mi;
		case j:
			return Quat.mj;
		case k:
			return Quat.mk;
		case mone:
			return Quat.one;
		case mi:
			return Quat.i;
		case mj:
			return Quat.j;
		case mk:
			return Quat.k;
		default:
			return null;
		}
	}

	public static boolean isPositive (Quat q) {
		return (q==Quat.one)||(q==Quat.i)||(q==Quat.j)||(q==Quat.k);
	}

	public static Quat mult (Quat q1, Quat q2) {
		if (!isPositive(q2)) {
			if (isPositive(q1))
				return getOpposite(mult(q1,getOpposite(q2)));
			if (!isPositive(q1))
				return mult(getOpposite(q1),getOpposite(q2));
		}
		switch (q1) {
		case one:
			return q2;
		case i:
			switch (q2) {
			case one:
				return Quat.i;
			case i:
				return Quat.mone;
			case j:
				return Quat.k;
			case k:
				return Quat.mj;
			default:
				break;
			}
		case j:
			switch (q2) {
			case one:
				return Quat.j;
			case i:
				return Quat.mk;
			case j:
				return Quat.mone;
			case k:
				return Quat.i;
			default:
				break;
			}
		case k:
			switch (q2) {
			case one:
				return Quat.k;
			case i:
				return Quat.j;
			case j:
				return Quat.mi;
			case k:
				return Quat.mone;
			default:
				break;
			}
		default:
			return getOpposite(mult(getOpposite(q1),q2)); 
		}
	}

	public static Quat toQuat (char c) {
		switch (c) {
		case 'i':
			return Quat.i;
		case 'j':
			return Quat.j;
		case 'k':
			return Quat.k;
		default:
			return null;
		}
	}
	
}
