package y2019.kickstartrC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainA {

	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {

			int N = in.nextInt();
			int R = in.nextInt();
			int C = in.nextInt();
			int Sr= in.nextInt();
			int Sc = in.nextInt();

			String instructions = in.next();
			
			ArrayList<Long> vertical = new ArrayList<Long>();
			ArrayList<Long> horizontal = new ArrayList<Long>();
			
			int ri = Sr-1;
			int ci = Sc-1;
			
			int indV = add(R,C,vertical,true,ri,ci);
			int indH = add(R,C,horizontal,false,ri,ci);
			
			for (int i=0; i<N; i++) {
				char dir = instructions.charAt(i);
				ArrayList<Long> l = null;
				boolean se = false;
				int start = 0;
				switch (dir) {
				case 'N':
					l = vertical;
					start = indV;
					se = false;
					break;
				case 'S':
					l = vertical;
					start = indV;
					se = true;
					break;
				case 'W':
					l = horizontal;
					start = indH;
					se = false;
					break;
				case 'E':
					l = horizontal;
					start = indH;
					se = true;
					break;
				}
				int offset = getOffset(l, se, start);
				if (l==vertical)
					ri += offset;
				else
					ci += offset;
				indV = add(R,C,vertical,true,ri,ci);
				indH = add(R,C,horizontal,false,ri,ci);
			}
			
			System.out.println(String.format("Case #%d: %d %d",t+1,ri+1,ci+1));
		}

		in.close();
	}

	private static int add(int R, int C, ArrayList<Long> list, boolean isV, int ri, int ci) {
		long val = isV ? (long)ci*R+ri : (long)ri*C+ci;
		int ind, size=list.size();
		if (list.size() == 0 || val<list.get(0))
			ind = 0;
		else if (val>list.get(size-1))
			ind = size;
		else {
			int left=0, right=size-1;
			while (left<right) {
				int mid = (left+right)/2;
				long tmp = list.get(mid);
				if (val<tmp)
					right = mid;
				else
					left = mid+1;
			}
			ind = left;
		}
		list.add(ind,val);
		return ind;
	}
	
	private static int getOffset (ArrayList<Long> list, boolean se, int start) {
		long tmp = list.get(start);
		int res;
		if (se) {
			res = 1;
			while (start+res < list.size() &&
					list.get(start+res) == tmp+res)
				res++;
		} else {
			res = -1;
			while (start+res >= 0 &&
					list.get(start+res) == tmp+res)
				res--;
		}
		return res;
	}
	
}
