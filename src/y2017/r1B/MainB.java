package y2017.r1B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MainB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//String filename = "src/y2017r1B/B-test";
		//String filename = "src/y2017r1B/B-small-practice";
		String filename = "src/y2017r1B/B-large-practice";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int ind=1; ind<T+1; ind++) {
				// parser
				String buff[] = in.readLine().split(" ");
				int N, R, O, Y, G, B, V;
				N = Integer.parseInt(buff[0]);
				R = Integer.parseInt(buff[1]);
				O = Integer.parseInt(buff[2]);
				Y = Integer.parseInt(buff[3]);
				G = Integer.parseInt(buff[4]);
				B = Integer.parseInt(buff[5]);
				V = Integer.parseInt(buff[6]);

				// calcul
				String res = solve(N, R, O, Y, G, B, V);

				//System.out.println("Result "+ind+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static String solve (int N, int R, int O, int Y, int G, int B, int V) {
		String res = "";

		// one pattern case
		if (O+Y+B+V == 0) {
			if (R != G)
				return "IMPOSSIBLE";
			for (int i=0; i<R; i++)
				res += "RG";
			return res;
		}
		if (R+Y+G+V == 0) {
			if (O != B)
				return "IMPOSSIBLE";
			for (int i=0; i<O; i++)
				res += "OB";
			return res;
		}
		if (O+R+B+G == 0) {
			if (Y != V)
				return "IMPOSSIBLE";
			for (int i=0; i<Y; i++)
				res += "YV";
			return res;
		}

		// several patterns case

		if (((G >= R) && (G > 0)) || ((O >= B) && (O > 0)) || ((V >= Y) && (V > 0)))
			return "IMPOSSIBLE";

		int patR = R-G;
		int patY = Y-V;
		int patB = B-O;
		int patMax, patMed, patMin;
		int bicMax, bicMed, bicMin;
		boolean bMax, bMed, bMin;
		String sMax, sMed, sMin;
		String eMax, eMed, eMin;

		patMax = Math.max(patR, Math.max(patY, patB));
		patMin = Math.min(patR, Math.min(patY, patB));
		if (patMax == patR) {
			bicMax = G;
			sMax = "R";
			eMax = "GR";
			if (patMin == patY) {
				bicMin = V;
				sMin = "Y";
				eMin = "VY";
				patMed = patB;
				bicMed = O;
				sMed = "B";
				eMed = "OB";
			} else {
				bicMin = O;
				sMin = "B";
				eMin = "OB";
				patMed = patY;
				bicMed = V;
				sMed = "Y";
				eMed = "VY";
			}
		} else if (patMax == patY) {
			bicMax = V;
			sMax = "Y";
			eMax = "VY";
			if (patMin == patR) {
				bicMin = G;
				sMin = "R";
				eMin = "GR";
				patMed = patB;
				bicMed = O;
				sMed = "B";
				eMed = "OB";
			} else {
				bicMin = O;
				sMin = "B";
				eMin = "OB";
				patMed = patR;
				bicMed = G;
				sMed = "R";
				eMed = "GR";
			}
		} else {
			bicMax = O;
			sMax = "B";
			eMax = "OB";
			if (patMin == patY) {
				bicMin = V;
				sMin = "Y";
				eMin = "VY";
				patMed = patR;
				bicMed = G;
				sMed = "R";
				eMed = "GR";
			} else {
				bicMin = G;
				sMin = "R";
				eMin = "GR";
				patMed = patY;
				bicMed = V;
				sMed = "Y";
				eMed = "VY";
			}			
		}
		if (patMax > patMed+patMin)
			return "IMPOSSIBLE";
		bMax = false;
		bMed = false;
		bMin = false;
		while (patMax > patMed) {
			res += sMax;
			if (!bMax)
				for (int i=0; i<bicMax; i++)
					res += eMax;
			res += sMin;
			if (!bMin)
				for (int i=0; i<bicMin; i++)
					res += eMin;
			bMax = true;
			bMin = true;
			patMax--;
			patMin--;
		}
		while (patMax > patMin) {
			res += sMax;
			if (!bMax)
				for (int i=0; i<bicMax; i++)
					res += eMax;
			res += sMed;
			if (!bMed)
				for (int i=0; i<bicMed; i++)
					res += eMed;
			bMax = true;
			bMed = true;
			patMax--;
			patMed--;
		}
		while (patMax > 0) {
			res += sMax;
			if (!bMax)
				for (int i=0; i<bicMax; i++)
					res += eMax;
			res += sMed;
			if (!bMed)
				for (int i=0; i<bicMed; i++)
					res += eMed;
			res += sMin;
			if (!bMin)
				for (int i=0; i<bicMin; i++)
					res += eMin;
			bMax = true;
			bMed = true;
			bMin = true;
			patMax--;
			patMed--;
			patMin--;
		}

		return res;
	}

}