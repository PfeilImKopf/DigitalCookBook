package application;

public class Category {
	private String name;
	public Category() {
		this("----");
	}
	public Category(String str) {
		this.name=str;
	}
	public String getName() {
		return name;
	}
}
