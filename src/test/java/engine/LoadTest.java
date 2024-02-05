package engine;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import dom2app.IMeasurementVector;

public class LoadTest {
	@Test
	public void test() throws FileNotFoundException, IOException {	
		MainControllerImpl controller = new MainControllerImpl();
		List<IMeasurementVector> measVectors = controller.load("src/test/resources/input/gre.tsv", "\t");
		
		assertEquals(measVectors.get(0).getCountryName(), "Greece");
		assertEquals(measVectors.get(0).getIndicatorString(), "Drought");
	}
	
	@Test(expected = FileNotFoundException.class)
	public void catchWrongLoadFile() throws FileNotFoundException, IOException {
		MainControllerImpl controller = new MainControllerImpl();
		controller.load("src/test/resources/input/filenotfound.tsv", "\t");
	}
}
