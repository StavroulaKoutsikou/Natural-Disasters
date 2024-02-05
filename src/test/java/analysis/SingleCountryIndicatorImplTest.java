package analysis;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import analysis.ISingleCountryIndicatorFactory.RequestType;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;
import engine.MainControllerImpl;

public class SingleCountryIndicatorImplTest {
	MainControllerImpl controller = null;
	List<IMeasurementVector> measVectors = null;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		controller = new MainControllerImpl();
		measVectors = controller.load("src/test/resources/input/gre.tsv", "\t");
	}
	
	@Test
	public void test() {
		ISingleCountryIndicatorFactory factory = new ISingleCountryIndicatorFactory();
		ISingleCountryIndicator indicator = factory.createISingleCountryIndicator(RequestType.DEFAULT);
		
		ISingleMeasureRequest request = indicator.find("GR-TOT", "Greece", "TOTAL", measVectors);
		
		assertEquals(request.getRequestFilter(), "GR-TOT-TOTAL");
		assertEquals(request.getRequestName(), "GR-TOT");
	}
	
	@Test
	public void testYearRange() {
		ISingleCountryIndicatorFactory factory = new ISingleCountryIndicatorFactory();
		ISingleCountryIndicator indicator = factory.createISingleCountryIndicator(RequestType.DEFAULT);
		
		ISingleMeasureRequest request = indicator.findWithYearRange("GR-TOT", "Greece", "TOTAL", 1990, 1999, measVectors);
				
		assertEquals((int) request.getAnswer().getMeasurements().get(0).getValue(), 2);
		assertEquals((int) request.getAnswer().getMeasurements().get(1).getValue(), 1);
		assertEquals((int) request.getAnswer().getMeasurements().get(2).getValue(), 0);
		assertEquals((int) request.getAnswer().getMeasurements().get(3).getValue(), 0);
		assertEquals((int) request.getAnswer().getMeasurements().get(4).getValue(), 1);
		assertEquals((int) request.getAnswer().getMeasurements().get(5).getValue(), 1);
		assertEquals((int) request.getAnswer().getMeasurements().get(6).getValue(), 0);
		assertEquals((int) request.getAnswer().getMeasurements().get(7).getValue(), 1);
		assertEquals((int) request.getAnswer().getMeasurements().get(8).getValue(), 2);
		assertEquals((int) request.getAnswer().getMeasurements().get(9).getValue(), 0);
	}	
}
