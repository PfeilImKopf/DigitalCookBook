package application;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import recipeAndCategoryPackage.Recipe;


public class CenterPane extends BorderPane {
	private RecipePane recPane;
	public CenterPane(Recipe recipe,Stage parent) {
		TopControlPane topControl = new TopControlPane();
		setTop(topControl);
		recPane = new RecipePane(recipe);
		setCenter(recPane);
	}
	public void setRecipe(Recipe recipe) {

		setCenter(new RecipePane(recipe));
	}
}
