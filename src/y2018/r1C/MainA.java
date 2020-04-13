package y2018.r1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int L = in.nextInt();

			ArrayList<HashSet<Character>> letters = new ArrayList<HashSet<Character>>(L);
			for (int i=0; i<L; i++)
				letters.add(new HashSet<Character>());
			Trie dico = new Trie('\0');
			for (int i=0; i<N; i++) {
				String s = in.next();
				dico.addWord(s);
				for (int j=0; j<L; j++)
					letters.get(j).add(s.charAt(j));
			}

			String res = solve(N,L,letters,dico);

			System.out.println(String.format("Case #%d: %s",t+1, res));
		}

		in.close();
	}


	private static String solve(int N, int L, ArrayList<HashSet<Character>> letters, Trie dico) {

		long[] poss = new long[L+1];
		poss[L] = 1;
		for (int i=L-1; i>=0; i--)
			poss[i] = poss[i+1] * letters.get(i).size();

		if (N == poss[0])
			return "-";

		String res = "";

		Trie tmp = dico;
		for (int i=0; i<L; i++) {
			for (Character c : letters.get(i)) {
				if (tmp.children.containsKey(c) &&
						tmp.children.get(c).cpt < poss[i+1]) {
					tmp = tmp.children.get(c);
					res += c;
					break;
				}
				if (!tmp.children.containsKey(c)) {
					res += c;
					for (i++;i<L;i++)
						res += letters.get(i).iterator().next();
					return res;					
				}
			}
		}

		return res;
	}





	public static class Trie {
		char label;
		int cpt;
		HashMap<Character, Trie> children;

		public Trie(char label) {
			this.label = label;
			cpt = 0;
			children = new HashMap<Character, Trie>();
		}
		void addWord (String s) {
			Trie tmp = this;
			cpt++;
			for (int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				if (!tmp.children.containsKey(c))
					tmp.children.put(c, new Trie(c));
				tmp = tmp.children.get(c);
				tmp.cpt++;
			}
		}
	}


}
