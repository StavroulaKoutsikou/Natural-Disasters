package reporter;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;
import engine.MainControllerImpl;

public class ReportToFileHTMLTest {
	MainControllerImpl controller = null;
	List<IMeasurementVector> measVectors = null;
	ISingleMeasureRequest request = null;
	
	@Before
	public void setUp() throws FileNotFoundException, IOException {
		controller = new MainControllerImpl();
		measVectors = controller.load("src/test/resources/input/gre.tsv", "\t");
		request = controller.findSingleCountryIndicator("GR-TOT", "Greece", "TOTAL");
	}
	
	@Test
	public void htmlTest() throws IOException {
		IReportToFileFactory factory = new IReportToFileFactory();
		int rows = factory.createReportToFile("html").report("src/test/resources/output/test.html", request);
	
		File f = new File("src/test/resources/output/test.html");
		
		assertEquals(rows, 43);
		assertEquals(f.exists(), true);
	}
}
