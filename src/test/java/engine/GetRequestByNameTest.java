package engine;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public class GetRequestByNameTest {
	MainControllerImpl controller = null;
	List<IMeasurementVector> measVectors = null;
	ISingleMeasureRequest request1 = null;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		controller = new MainControllerImpl();
		measVectors = controller.load("src/test/resources/input/gre.tsv", "\t");
		request1 = controller.findSingleCountryIndicator("GR-TOT", "Greece", "TOTAL");
	}
	
	@Test
	public void test() {
		assertEquals(request1, controller.getRequestByName("GR-TOT"));
	}
}
