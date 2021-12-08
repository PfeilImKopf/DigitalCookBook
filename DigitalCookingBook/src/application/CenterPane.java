package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import recipeAndCategoryPackage.Recipe;

public class CenterPane extends BorderPane {
	private Recipe recipe;
	public CenterPane(Recipe recipe,Stage parent) {
		TopControlPane topControl = new TopControlPane();
		setTop(topControl);
		//centerRez = new RezMainPane(rez,topControl,parent);
		setCenter(recipe);
	}
	public void setRecipe(Recipe recipe) {
		this.recipe=recipe;
		setCenter(this.recipe);
	}
}
