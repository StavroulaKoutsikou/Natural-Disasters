package analysis;

import java.util.List;

import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public interface ISingleCountryIndicator {

	ISingleMeasureRequest find(String requestName, String countryName, String indicatorString, List<IMeasurementVector> measVectors);
	
	ISingleMeasureRequest findWithYearRange(String requestName, String countryName, String indicatorString, int startYear, int endYear, List<IMeasurementVector> measVectors);
}



