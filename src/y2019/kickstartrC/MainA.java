package y2019.kickstartrC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainA {

	public static class Interval {
		long left;
		long right;
		public Interval (long l, long r) {
			left = l;
			right = r;
		}
	}
	
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
			
			ArrayList<Interval> vertical = new ArrayList<Interval>();
			ArrayList<Interval> horizontal = new ArrayList<Interval>();
			
			int ri = Sr-1;
			int ci = Sc-1;
			
			int indV = add(R,C,vertical,true,ri,ci);
			int indH = add(R,C,horizontal,false,ri,ci);
			
			for (int i=0; i<N; i++) {
				char dir = instructions.charAt(i);
				ArrayList<Interval> l = null;
				boolean se = false;
				int start = 0;
				long val = 0;
				switch (dir) {
				case 'N':
					l = vertical;
					start = indV;
					val = ci*R+ri;
					se = false;
					break;
				case 'S':
					l = vertical;
					start = indV;
					val = ci*R+ri;
					se = true;
					break;
				case 'W':
					l = horizontal;
					start = indH;
					val = ri*C+ci;
					se = false;
					break;
				case 'E':
					l = horizontal;
					start = indH;
					val = ri*C+ci;
					se = true;
					break;
				}
				int offset = getOffset(l, se, start, val);
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

	private static int add(int R, int C, ArrayList<Interval> list, boolean isV, int ri, int ci) {
		long val = isV ? (long)ci*R+ri : (long)ri*C+ci;
		int ind, size=list.size();
		if (list.size() == 0 || val<list.get(0).left)
			ind = 0;
		else if (val>list.get(size-1).right)
			ind = size;
		else {
			int left=0, right=size-1;
			while (left<right) {
				int mid = (left+right)/2;
				long tmp = list.get(mid).left;
				if (val<tmp)
					right = mid;
				else
					left = mid+1;
			}
			ind = left;
		}
		list.add(ind,new Interval(val,val));
		return checkNb(list,ind);
	}
	
	private static int checkNb (ArrayList<Interval> list, int ind) {
		int tmp = ind;
		if (ind > 0 && list.get(tmp-1).right == list.get(tmp).left-1) {
			list.get(tmp-1).right = list.get(tmp).right;
			list.remove(tmp);
			tmp--;
		}
		if (ind < list.size()-1 && list.get(tmp+1).left == list.get(tmp).right+1) {
			list.get(tmp).right = list.get(tmp+1).right;
			list.remove(tmp+1);
		}
		return tmp;
	}
	
	private static int getOffset (ArrayList<Interval> list, boolean se, int start, long val) {
		Interval tmp = list.get(start);
		return (int) (se ? tmp.right-val+1 : tmp.left-val-1);
	}
	
}
