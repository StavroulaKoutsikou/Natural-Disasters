package analysis;

public class ISingleCountryIndicatorFactory {

	public enum RequestType {DEFAULT};
	
	public ISingleCountryIndicator createISingleCountryIndicator(RequestType type) {
	
		if (type == RequestType.DEFAULT) {
			return new SingleCountryIndicatorImpl();
		}
		
		return null;
	}
}



