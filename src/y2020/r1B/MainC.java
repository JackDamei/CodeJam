package y2020.r1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class MainC {

	public static class Card {
		int r;
		int s;
		public Card(int r, int s) {
			this.r = r;
			this.s = s;
		}		
	}
	public static class Stack {
		LinkedList<Card> cards;
		final int R;
		final int S;
		public Stack (int r, int s) {
			R = r;
			S = s;
			cards = new LinkedList<Card>();
			for (int i=1; i<=S; i++)
				for (int j=1; j<=R; j++)
					cards.addLast(new Card(j,i));
		}
		public void operate (int a, int b) {
			LinkedList<Card> sa = new LinkedList<Card>();
			LinkedList<Card> sb = new LinkedList<Card>();
			for (int i=0; i<a; i++)
				sa.addLast(cards.pollFirst());
			for (int i=0; i<b; i++)
				sb.addLast(cards.pollFirst());
			for (int i=0; i<a; i++)
				cards.addFirst(sa.pollLast());
			for (int i=0; i<b; i++)
				cards.addFirst(sb.pollLast());
		}
		public boolean isValid () {
			int prev = 1;
			for (Card c : cards) {
				if (c.r<prev) return false;
				prev = c.r;
			}
			return true;
		}
	}


	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int R = in.nextInt();
			int S = in.nextInt();

			/**/
			Stack stack = new Stack(R,S);
			/**/

			String res = "";
			int cpt = 0;
			int adj = R*S-1;

			while (adj > R) {
				Iterator<Card> it = stack.cards.iterator();
				Card c = it.next();
				int X = c.r;
				int a=0;
				while (c.r==X) {
					a++;
					c = it.next();
				}
				while (c.r==X%R+1) {
					a++;
					c = it.next();
				}

				int b=0;
				while (c.r!=X) {
					b++;
					c = it.next();
				}
				while (c.r==X) {
					b++;
					c = it.next();
				}
				res += String.format("\n%d %d",a,b);
				stack.operate(a,b);
				cpt++;
				adj -= 2;
			}
			if (adj == R) {
				Iterator<Card> it = stack.cards.iterator();
				Card c = it.next();
				int X = c.r;
				int a=0;
				while (c.r==X) {
					a++;
					c = it.next();
				}
				res += String.format("\n%d %d",a,R*S-a);
				stack.operate(a,R*S-a);
				cpt++;				
			}	
			
			if (!stack.isValid()) {
				System.out.println("FALSE");
				in.close();
				return;
			}

			System.out.println(String.format("Case #%d: %d%s",t+1,cpt,res));
		}

		in.close();
	}

}
