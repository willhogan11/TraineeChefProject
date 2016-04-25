package beans;

//Bean class that contains getters and setters used throughout the project
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