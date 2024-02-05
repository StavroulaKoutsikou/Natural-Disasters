package engine;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public class ReportToFileTest {
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
	public void textTest() throws IOException {
		int rows = controller.reportToFile("src/test/resources/output/test1.txt", "GR-TOT", "text");
		
		File f = new File("src/test/resources/output/test1.txt");
		
		assertEquals(rows, 43);
		assertEquals(f.exists(), true);
	}
	
	@Test
	public void mdTest() throws IOException {
		int rows = controller.reportToFile("src/test/resources/output/test1.md", "GR-TOT", "md");
		
		File f = new File("src/test/resources/output/test1.md");
		
		assertEquals(rows, 43);
		assertEquals(f.exists(), true);
	}
	
	@Test
	public void htmlTest() throws IOException {
		int rows = controller.reportToFile("src/test/resources/output/test1.html", "GR-TOT", "html");
		
		File f = new File("src/test/resources/output/test1.html");
		
		assertEquals(rows, 43);
		assertEquals(f.exists(), true);
	}
	
	@Test(expected = IOException.class)
  	public void catchFailToReport() throws FileNotFoundException, IOException {
  		controller.load("src/test/resources/input/gre.tsv", "\t");
  		controller.findSingleCountryIndicator("GR-TOT", "Greece", "TOTAL");
  	
  		controller.reportToFile("src/test/resources/", "GR-TOT", "text");
  	}
}
