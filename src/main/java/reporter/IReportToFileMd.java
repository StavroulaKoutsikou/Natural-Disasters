package reporter;

import java.io.FileWriter;
import java.io.IOException;
import dom2app.ISingleMeasureRequest;

public class IReportToFileMd implements IReportToFile {

	@Override
	public int report(String outputFilePath, ISingleMeasureRequest request) throws IOException {
		
		FileWriter writer = new FileWriter(outputFilePath);
		
		writer.write("**" + request.getRequestName() + "**" + "\n\n");
		writer.write("_Country~" + request.getAnswer().getCountryName() + " Indicator: " + request.getAnswer().getIndicatorString() + "_\n\n");
		
		writer.write("|*Year*|*Value*|\n");
		writer.write("|----|----|\n");
		for (int i=0; i<request.getAnswer().getMeasurements().size(); i++) {
			writer.write("|" + request.getAnswer().getMeasurements().get(i).getKey() + "\t|" + request.getAnswer().getMeasurements().get(i).getValue() + "|\n");
		}
		
		writer.write("\n" + request.getDescriptiveStatsString() + "\n\n");
		writer.write(request.getRegressionResultString() + "\n");
		
		writer.close();
		
		return request.getAnswer().getMeasurements().size();
	}
}
