package beans;

public class MeasureType {

	private String measureName;

	public MeasureType(String measureName) {
		super();
		this.measureName = measureName;
	}

	public String getMeasureName() {
		return measureName;
	}
	
	public void setMeasureName(String measureName) {
		this.measureName = measureName;
	}
}