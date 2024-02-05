package loader;

import java.io.FileNotFoundException;
import java.util.List;
import dom2app.IMeasurementVector;

public interface ILoaderFromFile {

	List<IMeasurementVector> load(String filename, String delimiter) throws FileNotFoundException;
}
