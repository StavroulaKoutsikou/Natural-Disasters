package reporter;

import java.io.FileWriter;
import java.io.IOException;
import dom2app.ISingleMeasureRequest;

public class IReportToFileHTML implements IReportToFile {

	@Override
	public int report(String outputFilePath, ISingleMeasureRequest request) throws IOException {
		FileWriter writer = new FileWriter(outputFilePath);
		
		writer.write("<!doctype html>\n");
		writer.write("<html>\n");
		writer.write("<head>\n");
		writer.write("<meta http-equiv=\"Content-Type=\" content\"text/html; charset=windows-1253\">\n");
		writer.write("<title>Natural Disaster Data</title>\n");
		writer.write("</head>\n");
		writer.write("<body>\n\n");
		
		writer.write("<p><b>" + request.getRequestName() + "</p></b>");
		writer.write("<p><i>Country~" + request.getAnswer().getCountryName() + " Indicator: " + request.getAnswer().getIndicatorString() + "</i></p>\n");
		writer.write("<table>");
		writer.write("<tr><td>Year</td><td>Value</td></tr>\n");
		
		for (int i=0; i<request.getAnswer().getMeasurements().size(); i++) {
			writer.write("<tr><td>" + request.getAnswer().getMeasurements().get(i).getKey() + 
					"</td><td>" + request.getAnswer().getMeasurements().get(i).getValue() + "</td></tr>\n");
		}
		writer.write("</table>\n");
		
		writer.write("<p>" + request.getDescriptiveStatsString() + "</p>\n");
		writer.write("<p>" + request.getRegressionResultString() + "</p>\n");
		
		writer.write("</body>\n");
		writer.write("</html>\n");
		
		writer.close();
		
		return request.getAnswer().getMeasurements().size();
	}
}
