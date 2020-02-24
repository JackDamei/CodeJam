package y2016r1B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class MainB {

	public static void main(String[] args) {

		//String filename = "src/y20161B/B-test";
		String filename = "src/y20161B/B-small-practice";
		//String filename = "src/y20161B/B-large-practice";

		FileInputStream file;
		int T;

		try {
			file = new FileInputStream(filename+".in");

			BufferedReader in = new BufferedReader(new InputStreamReader(file));

			T = Integer.parseInt(in.readLine());

			BufferedWriter bw = new BufferedWriter(new FileWriter(filename+".out"));

			for (int i=0; i<T; i++) {
				int ind = i+1;
				// parser
				String buff[] = in.readLine().split(" ");
				String C = buff[0];
				String J = buff[1];
				
				// calcul
				String res = solve(C, J);
				
				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	@SuppressWarnings("unused")
	static String solve (String C, String J) {
		String res = "";

		int len = C.length();
		long diff1 = 0;
		long diff2 = 0;
		long diff3 = 0;
		String resC1 = "";
		String resJ1 = "";
		String resC2 = "";
		String resJ2 = "";
		//flemme de faire par dessous
		String resC3 = "";
		String resJ3 = "";
		
		int i=0;
		while (i < len && (C.charAt(i) == J.charAt(i) || C.charAt(i) == '?' || J.charAt(i) == '?')) {
			if (C.charAt(i) == J.charAt(i)) {
				if (C.charAt(i) == '?') {
					resC1 += "0";
					resJ1 += "0";
				} else {
					resC1 += C.charAt(i);
					resJ1 += J.charAt(i);
				}
			} else {
				if (C.charAt(i) == '?') {
					resC1 += J.charAt(i);
					resJ1 += J.charAt(i);
				} else {
					resC1 += C.charAt(i);
					resJ1 += C.charAt(i);
				}
			}
			i++;
			//System.out.println(resC1+" "+resJ1);
		}
		
		if (i == len) {
			res = resC1+" "+resJ1;
			return res;
		}
		
		if (C.charAt(i) > J.charAt(i)) {
			//System.out.println("C>J");
			//sol1
			for (int j=i; j<len; j++) {
				if (C.charAt(j) == '?')
					resC1 += "0";
				else
					resC1 += C.charAt(j);
				if (J.charAt(j) == '?')
					resJ1 += "9";
				else
					resJ1 += J.charAt(j);
				//System.out.println("1: "+resC1+" "+resJ1);
			}
			diff1 = Long.parseLong(resC1) - Long.parseLong(resJ1);
			//sol2
			int j=i-1; boolean b = false;
			while (j>=0 && !b) {
				if (J.charAt(j) == '?') {
					if (resJ1.charAt(j) != '9') {
						resJ2 = resJ1.substring(0, j)+(char)(resJ1.charAt(j)+1);
						resC2 = resC1.substring(0, j+1);
						b = true;
					}
				}
				j--;
			}
			if (b) j++;
			if (j<0) diff2 = Long.MAX_VALUE;
			else {
				for (j=j+1; j<len; j++) {
					if (C.charAt(j) == '?')
						resC2 += "9";
					else
						resC2 += C.charAt(j);
					if (J.charAt(j) == '?')
						resJ2 += "0";
					else
						resJ2 += J.charAt(j);
				}
				diff2 = Long.parseLong(resJ2) - Long.parseLong(resC2);
			}
			if (diff2 < diff1)
				res = resC2+" "+resJ2;
			else
				res = resC1+" "+resJ1;
		} else {
			//System.out.println("J>C");
			//sol1
			for (int j=i; j<len; j++) {
				if (C.charAt(j) == '?')
					resC1 += "9";
				else
					resC1 += C.charAt(j);
				if (J.charAt(j) == '?')
					resJ1 += "0";
				else
					resJ1 += J.charAt(j);
				//System.out.println("1: "+resC1+" "+resJ1);
			}
			diff1 = Long.parseLong(resJ1) - Long.parseLong(resC1);
			//sol2
			int j=i-1; boolean b = false;
			while (j>=0 && !b) {
				if (C.charAt(j) == '?') {
					if (resC1.charAt(j) != '9') {
						resC2 = resC1.substring(0, j)+(char)(resC1.charAt(j)+1);
						resJ2 = resJ1.substring(0, j+1);
						b = true;
					}
				}
				j--;
			}
			if (b) j++;
			if (j<0) diff2 = Long.MAX_VALUE;
			else {
				for (j=j+1; j<len; j++) {
					if (C.charAt(j) == '?')
						resC2 += "0";
					else
						resC2 += C.charAt(j);
					if (J.charAt(j) == '?')
						resJ2 += "9";
					else
						resJ2 += J.charAt(j);
				}
				diff2 = Long.parseLong(resC2) - Long.parseLong(resJ2);
			}
			if (diff2 < diff1)
				res = resC2+" "+resJ2;
			else
				res = resC1+" "+resJ1;			
		}
		
		return res;
	}
	
}
