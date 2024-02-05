package engine;

import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public class FindSingleCountryIndicatorYearRangeTest {
	MainControllerImpl controller = null;
	List<IMeasurementVector> measVectors = null;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		controller = new MainControllerImpl();
		measVectors = controller.load("src/test/resources/input/gre.tsv", "\t");
	}
		
	@Test
	public void findSingleCountryIndicatorYearRangeTest() {
		ISingleMeasureRequest request = controller.findSingleCountryIndicatorYearRange("GR-TOT-90s", "Greece", "TOTAL", 1990, 1999);
		
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
	
	@Test
	public void rainyDayTest() {
		ISingleMeasureRequest request =  controller.findSingleCountryIndicatorYearRange("WL-TOT-90s", "Wonderland", "TOTAL", 1990, 1999);
		assertEquals(request.getAnswer().getMeasurements().size(), 0);
	}
}
