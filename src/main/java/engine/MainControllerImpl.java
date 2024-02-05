package engine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import analysis.ISingleCountryIndicator;
import analysis.ISingleCountryIndicatorFactory;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;
import loader.ILoaderFromFileFactory;
import loader.ILoaderFromFile;
import reporter.IReportToFile;
import reporter.IReportToFileFactory;

public class MainControllerImpl implements IMainController {
	List<IMeasurementVector> measVectors = new ArrayList<IMeasurementVector>();
	Map<String, ISingleMeasureRequest> measRequests = new HashMap<String, ISingleMeasureRequest>();
	
	@Override
	public List<IMeasurementVector> load(String fileName, String delimiter) throws FileNotFoundException, IOException {
		ILoaderFromFileFactory factory = new ILoaderFromFileFactory();
		ILoaderFromFile loader = factory.createLoadFromFile(ILoaderFromFileFactory.FileTypeEnum.DELIMITED);
		
		measVectors.addAll(loader.load(fileName, delimiter));
		return measVectors;
	}
	
	@Override
	public ISingleMeasureRequest findSingleCountryIndicator(String requestName, String countryName,
			String indicatorString) throws IllegalArgumentException {
		
		ISingleCountryIndicatorFactory factory = new ISingleCountryIndicatorFactory();
		ISingleCountryIndicator analyser = factory.createISingleCountryIndicator(ISingleCountryIndicatorFactory.RequestType.DEFAULT);
		ISingleMeasureRequest req = analyser.find(requestName, countryName, indicatorString, measVectors);
		
		if (req != null)
			measRequests.put(requestName, req);
		
		return req;
	}

	@Override
	public ISingleMeasureRequest findSingleCountryIndicatorYearRange(String requestName, String countryName,
			String indicatorString, int startYear, int endYear) throws IllegalArgumentException {

		ISingleCountryIndicatorFactory factory = new ISingleCountryIndicatorFactory();
		ISingleCountryIndicator analyser = factory.createISingleCountryIndicator(ISingleCountryIndicatorFactory.RequestType.DEFAULT);
		ISingleMeasureRequest req = analyser.findWithYearRange(requestName, countryName, indicatorString, startYear, endYear, measVectors);
		
		if (req != null)
			measRequests.put(requestName, req);
		
		return req;
	}

	@Override
	public Set<String> getAllRequestNames() {
		return measRequests.keySet();
	}

	@Override
	public ISingleMeasureRequest getRequestByName(String requestName) {
		return measRequests.get(requestName);
	}

	@Override
	public ISingleMeasureRequest getRegression(String requestName) {
		return measRequests.get(requestName);
	}

	@Override
	public ISingleMeasureRequest getDescriptiveStats(String requestName) {
		return measRequests.get(requestName);
	}
	
	@Override
	public int reportToFile(String outputFilePath, String requestName, String reportType) throws IOException {
		
		ISingleMeasureRequest request = getRequestByName(requestName);
		IReportToFileFactory factory = new IReportToFileFactory();
		IReportToFile reporter = factory.createReportToFile(reportType);
		
		return reporter.report(outputFilePath, request);
	}	
}
