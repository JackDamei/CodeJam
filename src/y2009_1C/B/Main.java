package y2009_1C.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) {

		//String filename = "src/y2009_1C/input-B";
		//String filename = "src/y2009_1C/B-small-practice";
		String filename = "src/y2009_1C/B-large-practice";

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
				int N = Integer.parseInt(in.readLine());

				double vX=0, vY=0, vZ=0;
				double posX=0, posY=0, posZ=0;

				for (int j=0; j<N; j++) {
					String[] data = in.readLine().split(" ");
					posX += Integer.parseInt(data[0]);
					posY += Integer.parseInt(data[1]);
					posZ += Integer.parseInt(data[2]);
					vX += Integer.parseInt(data[3]);
					vY += Integer.parseInt(data[4]);
					vZ += Integer.parseInt(data[5]);
				}
				vX /= N;
				vY /= N;
				vZ /= N;
				posX /= N;
				posY /= N;
				posZ /= N;

				double prodScal = -posX*vX + -posY*vY + -posZ*vZ;

				double distance, time;

				if (prodScal <= 0) {
					distance = Math.sqrt(posX*posX + posY*posY + posZ*posZ);
					time = 0;
				} else {

					double vectX = -posY*vZ - -posZ*vY;
					double vectY = -posZ*vX - -posX*vZ;
					double vectZ = -posX*vY - -posY*vX;

					double normeV = Math.sqrt(vX*vX + vY*vY + vZ*vZ);
					double vect = Math.sqrt(vectX*vectX + vectY*vectY + vectZ*vectZ);
					distance = vect/normeV;
					time = prodScal/(normeV*normeV);
				}

				System.out.println("Result "+i+": "+distance+" "+time);
				bw.write("Case #"+ind+": "+distance+" "+time+"\n");
			}
			bw.close();

			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
