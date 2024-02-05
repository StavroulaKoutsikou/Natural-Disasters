package engine;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public class GetAllRequestNamesTest {
	MainControllerImpl controller = null;
	List<IMeasurementVector> measVectors = null;
	ISingleMeasureRequest request1 = null;
	ISingleMeasureRequest request2 = null;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		controller = new MainControllerImpl();
		measVectors = controller.load("src/test/resources/input/gre.tsv", "\t");
		request1 = controller.findSingleCountryIndicator("GR-TOT", "Greece", "TOTAL");
		request2 = controller.findSingleCountryIndicatorYearRange("GR-TOT-90s", "Greece", "TOTAL", 1990, 1999);
	}
	
	@Test
	public void test() {
		Set<String> set = controller.getAllRequestNames();
		
		assertEquals(set.toArray()[0], "GR-TOT");
		assertEquals(set.toArray()[1], "GR-TOT-90s");
	}
}
