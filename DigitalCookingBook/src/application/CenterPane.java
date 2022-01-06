package application;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import recipeAndCategoryPackage.Recipe;


public class CenterPane extends BorderPane {
	private RecipePane recPane;
	private TopControlPane topControl;
	public CenterPane(Recipe recipe,Stage parent) {
		topControl = new TopControlPane();
		setTop(topControl);
		recPane = new RecipePane(recipe);
		setCenter(recPane);
	}
	public void setRecipe(Recipe recipe) {
		recPane.setRecipe(recipe);
	}
	public Button getFullScreen() {
		return recPane.getFullScreen();
	}
	public RecipePane getRecPane() {
		return recPane;
	}
	public void setFull() {
		setTop(null);	
	}
	public void setNormal() {
		setTop(topControl);
		setCenter(recPane);
	}
}
