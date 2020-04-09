package y2009_1C.A;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {

		//String filename = "src/y2009_1C/input-A";
		//String filename = "src/y2009_1C/A-small-practice";
		String filename = "src/y2009_1C/A-large-practice";

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
				char[] str = in.readLine().toCharArray();
				int[] value = new int[str.length];

				ArrayList<Character> list = new ArrayList<Character>();
				for (int j=0; j<str.length; j++) {
					if (!list.contains(str[j]))
						list.add(str[j]);
					for (int k=0; k<list.size(); k++) {
						if (list.get(k) == str[j]) {
							if (k == 0)
								value[j] = 1;
							else if (k == 1)
								value[j] = 0;
							else
								value[j] = k;
							break;
						}
					}
				}

/*				for (int j=0; j<value.length; j++) {
					System.out.print(value[j]+" ");
				}
				System.out.println(); */
				
				int coef = Math.max(list.size(),2);
				System.out.println(coef);
				long tmp = 1;
				long res = 0;
				for (int j=value.length-1; j>=0; j--) {
					res += value[j]*tmp;
					tmp *= coef;
				}

				System.out.println("Result "+i+": "+res);
				bw.write("Case #"+ind+": "+res+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
