package y2019.r1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static int[] prime = {4,9,5,7,11,13,17};
	
	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
		@SuppressWarnings("unused")
		int N = in.nextInt();
		int M = in.nextInt();

		
		for (int t=0; t<T; t++) {

			int[] mod = new int[prime.length];
			
			for (int n=0; n<prime.length; n++) {
				String s = "";
				for (int i=0; i<18; i++) {
					s += prime[n]+" ";
				}
				System.out.println(s);
				int sum = 0;
				for (int i=0; i<18; i++) {
					sum += in.nextInt();
				}
				mod[n] = sum%prime[n];
			}
			
			int res;
			for (res=1; res<= M; res++) {
				boolean b = true;
				for (int i=0; b && i<prime.length; i++)
					b = res%prime[i] == mod[i];
				if (b)
					break;
			}

			System.out.println(res);
			if (in.nextInt() == -1)
				break;
		}
		
		in.close();
	}
	
}
