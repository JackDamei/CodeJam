package y2016r1C;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("tests/A/A-small-attempt1.in"));
			PrintWriter pw = new PrintWriter(new File("tests/A/A-small-attempt1.out"));
			int nbTest =  Integer.parseInt(br.readLine());
			for(int i =0;i<nbTest;i++){
				String nbPart = br.readLine();
				String repart = br.readLine();
				pw.println("Case #"+(i+1)+": "+algo(nbPart, repart));
			}
			br.close();
			pw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String algo(String nbPart, String repart){
		ArrayList<String> senat = new ArrayList<String>(Arrays.asList(repart.split(" ")));
		ArrayList<Integer> data = new ArrayList<Integer>();
		String result = "";
		for(String s:senat){
			data.add(Integer.parseInt(s));
		}
		int max = 0;
		int max2 = 0;
		for(int i=0;i<data.size();i++){
			if(data.get(i)>data.get(max)){
				max2 = max;
				max = i;
			}
			else {
				if(data.get(i)>data.get(max2) || max2 == max){
					max2 = i;
				}
			}
		}
		while(data.get(max) != data.get(max2)){
			if(data.get(max) > data.get(max2)+2){
				result = result+(char)('A'+max)+(char)('A'+max)+" ";
				data.set(max, data.get(max)-2);
			}
			else {
				result = result+(char)('A'+max)+" ";
				data.set(max, data.get(max)-1);
			}
		}

		boolean sortie = true;
		while(sortie){
			for(int i=0;i<data.size();i++){
				if(data.get(i) >0 && (i != max2 && i!=max)){
					char c = (char) ('A'+i);
					if(data.get(i)>=2){
						result = result+c+c+" ";
						data.set(i, data.get(i)-2);
						continue;
					}
					else {
						result = result+c+" ";
						data.set(i, data.get(i)-1);
						continue;
					}
				}
				sortie = false;
			}
		}
		int cpt =data.get(max);
		while(cpt > 0){
			if(cpt == 1){
				result = result+(char)('A'+max)+(char)('A'+max2);
			}
			else {
				result = result+(char)('A'+max)+(char)('A'+max2)+" ";
			}
			if(max == max2){
				cpt=cpt-2;
			}
			else {
				cpt--;
			}
		}

		return result;
	}

}
