package recipeAndCategoryPackage;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.ListView;

public class Category implements Serializable {
	private String name;
	private ArrayList<Recipe> rezList;
	public Category() {
		this("----");
	}
	public Category(String name) {
		this.name=name;
		rezList = new ArrayList<Recipe>();
		//rezList.setPrefWidth(180);
	}
	public String getName() {
		return this.name;
	}
	public ArrayList<Recipe> getRezList() {
		return rezList;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addRec(Recipe rec) {
		rezList.add(rec);
	}
	@Override
	public String toString() {
		return "\n"+name+"["+rezList.toString()+"]";
	}
}
