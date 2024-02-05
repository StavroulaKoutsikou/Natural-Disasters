package loader;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import loader.ILoaderFromFileFactory.FileTypeEnum;

public class ILoaderFromFileFactoryTest {
	@Test
	public void test() {
		ILoaderFromFileFactory factory = new ILoaderFromFileFactory();
				
		assertEquals(factory.createLoadFromFile(FileTypeEnum.DELIMITED) instanceof ILoaderFromFile, true);
	}
}
