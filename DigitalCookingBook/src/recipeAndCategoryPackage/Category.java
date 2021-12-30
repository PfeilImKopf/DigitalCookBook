package recipeAndCategoryPackage;

import javafx.scene.control.ListView;

public class Category {
	private String name;
	private ListView<Recipe> rezList;
	public Category() {
		this("----");
	}
	public Category(String name) {
		this.name=name;
		rezList = new ListView<Recipe>();
		rezList.setPrefWidth(180);
		rezList.getItems().addAll(new Recipe(name),new Recipe(),new Recipe("Bratapfel"));
	}
	public String getName() {
		return this.name;
	}
	public ListView<Recipe> getRezList() {
		return rezList;
	}
	public void setName(String name) {
		this.name = name;
	}
}
