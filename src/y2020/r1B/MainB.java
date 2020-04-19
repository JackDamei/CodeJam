package y2020.r1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainB {

	public static class Point {
		final int x;
		final int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	
	public static long MAX = 1000000000;
	
	public static void main (String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();
		@SuppressWarnings("unused")
		int A = in.nextInt();
		@SuppressWarnings("unused")
		int B = in.nextInt();
		
		Point[] starts = {new Point(0,0),
				new Point(500000000,500000000),
				new Point(500000000,-500000000),
				new Point(-500000000,500000000),
				new Point(-500000000,-500000000)};
	
		for (int t=0; t<T; t++) {

			boolean found = false;
			
			Point start = null;
			for (int i=0; i<5; i++) {
				System.out.println(starts[i].x+" "+starts[i].y);
				String s = in.next();
				switch (s) {
				case "CENTER":
					found = true;
					break;
				case "HIT":
					start = starts[i];
					break;
				}
				if (found) break;
				if (start != null) break;
			}
			if (found) continue;
			
			// find left edge
			long a = -MAX;
			long b = start.x;
			while (a < b) {
				long mid = (a+b-1)/2;
				System.out.println(mid+" "+start.y);
				String s = in.next();
				switch (s) {
				case "CENTER":
					found = true;
					break;
				case "HIT":
					b = mid;
					break;
				case "MISS":
					a = mid+1;
					break;
				}
				if (found) break;
			}
			if (found) continue;
			Point left = new Point((int)a,start.y);
			
			// find right edge
			a = start.x;
			b = MAX;
			while (a < b) {
				long mid = (a+b+1)/2;
				System.out.println(mid+" "+start.y);
				String s = in.next();
				switch (s) {
				case "CENTER":
					found = true;
					break;
				case "HIT":
					a = mid;
					break;
				case "MISS":
					b = mid-1;
					break;
				}
				if (found) break;
			}
			if (found) continue;
			Point right = new Point((int)a,start.y);

			start = new Point((right.x+left.x)/2, right.y);
			
			// find bottom edge
			a = -MAX;
			b = start.y;
			while (a < b) {
				long mid = (a+b-1)/2;
				System.out.println(start.x+" "+mid);
				String s = in.next();
				switch (s) {
				case "CENTER":
					found = true;
					break;
				case "HIT":
					b = mid;
					break;
				case "MISS":
					a = mid+1;
					break;
				}
				if (found) break;
			}
			if (found) continue;
			Point bottom = new Point(start.x,(int)a);
			
			// find top edge
			a = start.y;
			b = MAX;
			while (a < b) {
				long mid = (a+b+1)/2;
				System.out.println(start.x+" "+mid);
				String s = in.next();
				switch (s) {
				case "CENTER":
					found = true;
					break;
				case "HIT":
					a = mid;
					break;
				case "MISS":
					b = mid-1;
					break;
				}
				if (found) break;
			}
			if (found) continue;
			Point top = new Point(start.x,(int)a);
			
			// get to center
			System.out.println(start.x+" "+(top.y+bottom.y)/2);
			
			in.next();
			
		}
		
		in.close();
	}

}
