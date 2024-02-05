package loader;

import static org.junit.Assert.assertEquals;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.Test;
import dom2app.IMeasurementVector;
import loader.ILoaderFromFileFactory.FileTypeEnum;

public class ILoaderFromFileDelimitedTest {
	@Test
	public void test() throws FileNotFoundException, IOException {	
		ILoaderFromFileFactory factory = new ILoaderFromFileFactory();
		
		List<IMeasurementVector> measVectors = factory.createLoadFromFile(FileTypeEnum.DELIMITED).load("src/test/resources/input/gre.tsv", "\t");
		
		assertEquals(measVectors.get(0).getCountryName(), "Greece");
		assertEquals(measVectors.get(0).getIndicatorString(), "Drought");
	}
}
