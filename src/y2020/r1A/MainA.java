package y2020.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainA {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();

			String[] P = new String[N];
			for (int i=0; i<N; i++)
				P[i] = in.next();

			String res = solve(N,P);

			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}

	public static String solve (int N, String[] P) {
		
		String debut = "";
		String milieu = "";
		String fin = "";
		
		for (int i=0; i<N; i++) {
		
			String[] s = P[i].split("\\*",-1);
			int size = s.length;
			
			if (!s[0].equals(""))
				if (debut.equals(""))
					debut = s[0];
				else
					if (debut.length() <= s[0].length())
						if (debut.equals(s[0].substring(0,debut.length())))
							debut = s[0];
						else
							return "*";
					else if (!debut.substring(0, s[0].length()).equals(s[0]))
						return "*";

			if (!s[size-1].equals(""))
				if (fin.equals(""))
					fin = s[size-1];
				else
					if (fin.length() <= s[size-1].length())
						if (fin.equals(s[size-1].substring(s[size-1].length()-fin.length())))
							fin = s[size-1];
						else
							return "*";
					else if (!fin.substring(fin.length()-s[size-1].length()).equals(s[size-1]))
						return "*";
			
			for (int j=1; j<size-1; j++)
				milieu += s[j];
		
		}
		
		return debut+milieu+fin;
	}
}
