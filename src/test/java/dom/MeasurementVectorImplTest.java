package dom;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.util.Pair;
import org.junit.Before;
import org.junit.Test;
import dom2app.IMeasurementVector;

public class MeasurementVectorImplTest {
	IMeasurementVector vector; 
	List<Pair<Integer, Integer>> pairs;
	
	@Before
	public void setUp() {
		pairs = new ArrayList<Pair<Integer, Integer>>();
		pairs.add(new Pair<Integer, Integer>(1980, 0));
		pairs.add(new Pair<Integer, Integer>(1981, 4));
		pairs.add(new Pair<Integer, Integer>(1982, 0));
		pairs.add(new Pair<Integer, Integer>(1983, 1));
		pairs.add(new Pair<Integer, Integer>(1984, 3));
		
		vector = new MeasurementVectorImpl("Greece", "TOTAL", pairs);
	}
	
	@Test
	public void getCountryNameTest() {
		assertEquals(vector.getCountryName(), "Greece");
	}
	
	@Test
	public void getIndicatorStringTest() {
		assertEquals(vector.getIndicatorString(), "TOTAL");
	}
	
	@Test
	public void getMeasurementsTest() {
		assertEquals(vector.getMeasurements(), pairs);
	}
	
	@Test
	public void getDescriptiveStatsAsStringTest() {
		assertEquals(vector.getDescriptiveStatsAsString(), "DescriptiveStatsResult[count:5, \n"
				+ "min:0.0, \n"
				+ "gMean:0.0, \n"
				+ "mean:1.6, \n"
				+ "median:1.0, \n"
				+ "max:4.0, \n"
				+ "kurtosis:-2.2314049586776843, \n"
				+ "stdev:1.816590212458495, \n"
				+ "sum:8.0]");
	}
	
	@Test
	public void getRegressionResultAsStringTest() {
		assertEquals(vector.getRegressionResultAsString(), "RegressionResult[intercept:-593.0, \n"
				+ "slope:0.3, \n"
				+ "slope error:0.6403124237432849, \n"
				+ "trend: increased tendency]");
	}
}
