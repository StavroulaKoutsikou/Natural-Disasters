package dom;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.commons.math3.util.Pair;
import dom2app.IMeasurementVector;

public class MeasurementVectorImpl implements IMeasurementVector {
	String country;
	String indicator;
	List<Pair<Integer, Integer>> measurements = new ArrayList<Pair<Integer, Integer>>();
		
	public MeasurementVectorImpl(String country, String indicator, List<Pair<Integer, Integer>> measurements) {
		this.country = country;
		this.indicator = indicator;
		this.measurements = measurements;
	}

	public MeasurementVectorImpl() {
		
	}

	@Override
	public String getCountryName() {
		return country;
	}

	@Override
	public String getIndicatorString() {
		return indicator;
	}

	@Override
	public List<Pair<Integer, Integer>> getMeasurements() {
		return measurements;
	}

	@Override
	public String getDescriptiveStatsAsString() {
		
		DescriptiveStatistics descrStats = new DescriptiveStatistics();
		for (int i=0; i<measurements.size(); i++) {
			descrStats.addValue(measurements.get(i).getValue());
		}
		
		List<String> stats = new ArrayList<String>();

		stats.add("count:" + descrStats.getN());
		stats.add("\nmin:" + descrStats.getMin());
		stats.add("\ngMean:" + descrStats.getGeometricMean());
		stats.add("\nmean:" + descrStats.getMean());
		stats.add("\nmedian:" + descrStats.getPercentile(50));
		stats.add("\nmax:" + descrStats.getMax());
		stats.add("\nkurtosis:" + descrStats.getKurtosis());
		stats.add("\nstdev:" + descrStats.getStandardDeviation());
		stats.add("\nsum:" + descrStats.getSum());
		
		return "DescriptiveStatsResult" + stats.toString();
	}

	@Override
	public String getRegressionResultAsString() {
		SimpleRegression regression = new SimpleRegression();
		for (int i=0; i<measurements.size(); i++) {
			regression.addData(measurements.get(i).getKey(), measurements.get(i).getValue());
		}
		
		List<String> regrResult = new ArrayList<String>();
		regrResult.add("intercept:" + regression.getIntercept());
		regrResult.add("\nslope:" + regression.getSlope());
		regrResult.add("\nslope error:" + regression.getSlopeStdErr());
		
		if (Double.isNaN(regression.getSlope())) {
			regrResult.add("\ntrend: tendency undefined");
		}
		else if (regression.getSlope() > 0.1) {
			regrResult.add("\ntrend: increased tendency");
		}
		else if (regression.getSlope() < -0.1) {
			regrResult.add("\ntrend: decreased tendency");
		}
		else {
			regrResult.add("\ntrend: tendency stable");
		}
		
		return "RegressionResult" + regrResult.toString();
	}
}
