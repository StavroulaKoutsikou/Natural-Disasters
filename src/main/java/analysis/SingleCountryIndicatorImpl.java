package analysis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.util.Pair;

import dom.MeasurementVectorImpl;
import dom.SingleMeasureRequestImpl;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public class SingleCountryIndicatorImpl implements ISingleCountryIndicator {
	
	
	
	@Override
	public ISingleMeasureRequest find(String requestName, String countryName, String indicatorString, List<IMeasurementVector> measVectors) {
		ISingleMeasureRequest req = null;
		
		for (int i=0; i<measVectors.size(); i++) {
			if (measVectors.get(i).getCountryName().contentEquals(countryName) && measVectors.get(i).getIndicatorString().contentEquals(indicatorString)) {
				req = new SingleMeasureRequestImpl(requestName, requestName + "-" + indicatorString, true, measVectors.get(i));
			}
		}
		
		if (req == null)
			req = new SingleMeasureRequestImpl(requestName, requestName + "-" + indicatorString, false, new MeasurementVectorImpl());
		
		return req;
	}
	
	@Override
	public ISingleMeasureRequest findWithYearRange(String requestName, String countryName, String indicatorString, int startYear, int endYear, List<IMeasurementVector> measVectors) {
		ISingleMeasureRequest req = null;
		
		for (int i=0; i<measVectors.size(); i++) {
			if (measVectors.get(i).getCountryName().contentEquals(countryName) && measVectors.get(i).getIndicatorString().contentEquals(indicatorString)) {
				List<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();
				
				for (int j=0; j<measVectors.get(i).getMeasurements().size(); j++) {
					if (measVectors.get(i).getMeasurements().get(j).getKey() >= startYear && measVectors.get(i).getMeasurements().get(j).getKey() <= endYear) {
						pairs.add(measVectors.get(i).getMeasurements().get(j));
					}
				}
				IMeasurementVector vector = new MeasurementVectorImpl(countryName, indicatorString, pairs);
				req = new SingleMeasureRequestImpl(requestName, requestName + "-" + indicatorString, true, vector);
			}
		}
		
		if (req == null)
			req = new SingleMeasureRequestImpl(requestName, requestName + "-" + indicatorString, false, new MeasurementVectorImpl());
		
		return req;
	}

}





