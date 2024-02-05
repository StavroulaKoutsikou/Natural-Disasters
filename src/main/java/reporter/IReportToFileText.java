package reporter;

import java.io.FileWriter;
import java.io.IOException;
import dom2app.ISingleMeasureRequest;

public class IReportToFileText implements IReportToFile {

	@Override
	public int report(String outputFilePath, ISingleMeasureRequest request) throws IOException {
		FileWriter writer = new FileWriter(outputFilePath);
		
		writer.write(request.getRequestName() + "\n");
		writer.write("Country~" + request.getAnswer().getCountryName() + " Indicator: " + request.getAnswer().getIndicatorString() + "\n");
		
		writer.write("Year\tValue\n");
		for (int i=0; i<request.getAnswer().getMeasurements().size(); i++) {
			writer.write(request.getAnswer().getMeasurements().get(i).getKey() + "\t" + request.getAnswer().getMeasurements().get(i).getValue() + "\n");
		}
		
		writer.write(request.getDescriptiveStatsString() + "\n");
		writer.write(request.getRegressionResultString() + "\n");
		
		writer.close();
		
		return request.getAnswer().getMeasurements().size();
	}
}
