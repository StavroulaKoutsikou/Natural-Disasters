package dom;

import dom2app.IMeasurementVector;
import dom2app.ISingleMeasureRequest;

public class SingleMeasureRequestImpl implements ISingleMeasureRequest {

	String name;
	String filter;
	boolean flag;
	IMeasurementVector vector;
	
	public SingleMeasureRequestImpl(String name, String filter, boolean flag, IMeasurementVector vector) {
		this.name = name;
		this.filter = filter;
		this.flag = flag;
		this.vector = vector;
	}

	@Override
	public String getRequestName() {
		return name;
	}

	@Override
	public String getRequestFilter() {
		return filter;
	}

	@Override
	public boolean isAnsweredFlag() {
		return flag;
	}

	@Override
	public IMeasurementVector getAnswer() {
		return vector;
	}

	@Override
	public String getDescriptiveStatsString() {
		return vector.getDescriptiveStatsAsString();
	}

	@Override
	public String getRegressionResultString() {
		return vector.getRegressionResultAsString();
	}
}
