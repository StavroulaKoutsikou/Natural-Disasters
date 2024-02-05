package reporter;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IReportToFileFactoryTest {
	@Test
	public void test() {
		IReportToFileFactory factory = new IReportToFileFactory();
		
		assertEquals(factory.createReportToFile("text") instanceof IReportToFile, true);
	}
}
