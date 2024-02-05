package analysis;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import analysis.ISingleCountryIndicatorFactory.RequestType;

public class ISingleCountryIndicatorFactoryTest {

	@Test
	public void test() {
		ISingleCountryIndicatorFactory factory = new ISingleCountryIndicatorFactory();
		
		assertEquals(factory.createISingleCountryIndicator(RequestType.DEFAULT) instanceof ISingleCountryIndicator, true);
	}
}
