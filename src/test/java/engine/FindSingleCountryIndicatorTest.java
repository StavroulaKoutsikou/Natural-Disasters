package engine;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public class FindSingleCountryIndicatorTest {
	MainControllerImpl controller = null;
	List<IMeasurementVector> measVectors = null;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		controller = new MainControllerImpl();
		measVectors = controller.load("src/test/resources/input/gre.tsv", "\t");
	}
	
	@Test
	public void test() {
		ISingleMeasureRequest request = controller.findSingleCountryIndicator("GR-TOT", "Greece", "TOTAL");
		
		assertEquals(request.getRequestFilter(), "GR-TOT-TOTAL");
		assertEquals(request.getRequestName(), "GR-TOT");
	}
	
	@Test
	public void rainyDayTest() {
		ISingleMeasureRequest request =  controller.findSingleCountryIndicator("WL-TOT-90s", "Wonderland", "TOTAL");
		assertEquals(request.getAnswer().getMeasurements().size(), 0);
	}
}
