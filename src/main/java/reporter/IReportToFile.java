package reporter;

import java.io.IOException;
import dom2app.ISingleMeasureRequest;

public interface IReportToFile {
	int report(String outputFilePath, ISingleMeasureRequest request) throws IOException;
}
