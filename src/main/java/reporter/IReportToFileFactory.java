package reporter;

public class IReportToFileFactory {
	public IReportToFile createReportToFile(String reportType) {
		if (reportType.contentEquals("text")) {
			return new IReportToFileText();
		}
		else if (reportType.contentEquals("md")) {
			return new IReportToFileMd();	
		}
		else if (reportType.contentEquals("html")) {
			return new IReportToFileHTML();
		}
		
		return null;
	}
}
