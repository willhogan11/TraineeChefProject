package beans;

//Bean class that contains getters and setters used throughout the project
public class Person {
	
	private String name;

	public Person(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}