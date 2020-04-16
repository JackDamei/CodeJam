package y2020.kickstartrA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class MainD {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			int N = in.nextInt();
			int K = in.nextInt();
			
			String[] list = new String[N];
			for (int i=0; i<N; i++)
				list[i] = in.next();

			Dico dico = new Dico('\0');
			for (int i=0; i<N; i++)
				dico.add(list[i]);
			
			int res = dico.getScore(K);
			
			System.out.println("Case #"+(t+1)+": "+res);
		}
	
		in.close();
	}
	
	public static class Dico {
		char c;
		int cpt;
		HashMap<Character, Dico> children;
		
		public Dico (char c) {
			this.c = c;
			cpt = 0;
			children = new HashMap<Character, Dico>();
		}
		
		public void add (String s) {
			Dico tmp = this;
			for (int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if (!tmp.children.containsKey(c))
					tmp.children.put(c, new Dico(c));
				tmp = tmp.children.get(c);
				tmp.cpt++;
			}
		}
		
		public int getScore (int K) {
			int sum = cpt/K;
			if (sum > 0 || this.c == '\0') {
				for (Dico d : children.values())
					sum += d.getScore(K);
			}
			return sum;
		}
		
	}
	
	
	
}
