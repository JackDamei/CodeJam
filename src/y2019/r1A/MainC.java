package y2019.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class MainC {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();

			Trie dico = new Trie('\0');
			for (int i=0; i<N; i++)
				addWord(dico,in.next());

			int res = solve(dico);

			System.out.println(String.format("Case #%d: %d",t+1,res));
		}
		in.close();
	}
	
	public static int solve (Trie t) {
		if (t.cpt == 2 && t.c!='\0')
			return 2;
		if (t.cpt < 2)
			return 0;
		int res = 0;
		Set<Character> keys = t.children.keySet();
		for (char c : keys) {
			res += solve(t.children.get(c));
		}
		res += t.cpt-res>1 && t.c!='\0' ? 2 : 0;
		return res;
	}

	
	public static class Trie {
		public final char c;
		public int cpt;
		public HashMap<Character,Trie> children;
		public Trie (char c) {
			this.c = c;
			cpt = 0;
			children = new HashMap<Character,Trie>();
		}
	}
	
	public static void addWord (Trie t, String s) {
		t.cpt++;
		Trie tmp = t;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(s.length()-1-i);
			if (!tmp.children.containsKey(c))
				tmp.children.put(c, new Trie(c));
			tmp = tmp.children.get(c);
			tmp.cpt++;
		}
	}
	
}
