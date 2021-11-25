package application;

import javafx.scene.control.ListView;

public class Category {
	private String name;
	private ListView<Rezept> rezList;
	public Category() {
		this("----");
	}
	public Category(String name) {
		this.name=name;
		rezList = new ListView<Rezept>();
		rezList.getItems().addAll(new Rezept("Rindergulasch"),new Rezept(),new Rezept("Bratapfel"));
	}
	public String getName() {
		return this.name;
	}
	public ListView<Rezept> getRezList() {
		return rezList;
	}
	public void setName(String name) {
		this.name = name;
	}
}
