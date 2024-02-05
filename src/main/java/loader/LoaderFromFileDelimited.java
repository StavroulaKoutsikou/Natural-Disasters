package loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.math3.util.Pair;
import dom.MeasurementVectorImpl;
import dom2app.IMeasurementVector;

public class LoaderFromFileDelimited implements ILoaderFromFile {
	List<IMeasurementVector> measVectors = new ArrayList<IMeasurementVector>();
	
	@Override
	public List<IMeasurementVector> load(String fileName, String delimiter) throws FileNotFoundException {
		
		Scanner myReader = new Scanner(new File(fileName));
		
		int [] years = new int[43];
		
		for (int i=0; i<43; i++) 
			years[i] = 1980 + i;
		
		while (myReader.hasNextLine()) {
			String input = myReader.nextLine();
			String [] inputArr = input.split(delimiter);
			
			List<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();

			if (!input.startsWith("ObjectId")) {
				String country = inputArr[1];
				String indicator = inputArr[4];
				
				String [] st = Arrays.copyOfRange(inputArr, 5, 48);
				
				for (int i=0; i<st.length; i++) {
					int pl;
					if (st[i] == null || st[i].contentEquals(""))
						pl = 0;
					else
						pl = Integer.parseInt(st[i]);
										
					pairs.add(new Pair<Integer, Integer>(years[i], pl));
				}
				
				IMeasurementVector vector = new MeasurementVectorImpl(country, indicator, pairs);
				measVectors.add(vector);
			}
		}
		
		myReader.close();
		return measVectors;
	}
}
