package application;

import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import recipeAndCategoryPackage.Recipe;


public class CenterPane extends BorderPane {

	public CenterPane(Recipe recipe,Stage parent) {
		TopControlPane topControl = new TopControlPane();
		setTop(topControl);
		setCenter(new RecipePane(recipe));
	}
	public void setRecipe(Recipe recipe) {

		setCenter(new RecipePane(recipe));
	}
}
