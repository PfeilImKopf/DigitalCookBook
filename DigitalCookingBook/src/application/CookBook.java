package application;

import java.net.URL;
import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import recipeAndCategoryPackage.Category;
import recipeAndCategoryPackage.Recipe;


public class CookBook extends Stage {
	private CatPane catPane;
	private StackPane stackCatPane;
	private CenterPane centerRoot;
	public CookBook(ArrayList<Category> allCats) {	
		try {
			BorderPane root = new BorderPane();
			root.setId("root");
			Scene scene = new Scene(root,1280,720);
			setScene(scene);
			setMinWidth(1280);
			setMinHeight(720);
			setTitle("Digitales Kochbuch");

			//category and recipe list on the right
			catPane = new CatPane(allCats);
			stackCatPane = new StackPane();
			stackCatPane.getChildren().add(catPane);
			stackCatPane.setId("stackCatPane");
			root.setRight(stackCatPane);
			
			// everything else on the left/center
			centerRoot = new CenterPane(catPane.getRecipe(),this);


			//Listener for updating the current label
			catPane.getCatList().setOnMouseClicked(e-> {
				catPane.getCurrentCat().setText("Rezepte aus der Kategorie:\n"
						+catPane.getCatList().getSelectionModel().getSelectedItem().getName());
				ListView<Recipe> recL = new ListView<Recipe>();
				recL.getItems().addAll(catPane.getCatList().getSelectionModel().getSelectedItem().getRezList());
				catPane.getRezScrollPane().setRecipeList(recL);
				centerRoot.setRecipe(catPane.getRecList().getSelectionModel().getSelectedItem());
				catPane.getRecList().setOnMouseClicked(ev-> {
					centerRoot.setRecipe(catPane.getRecList().getSelectionModel().getSelectedItem());
				});
				root.setCenter(centerRoot);
			});


			//Listener for stage property to scale the Catlist and rezList
			heightProperty().addListener((obs,oldH,newH) -> {
				catPane.getCatScrollPane().setPrefHeight(newH.doubleValue());
				catPane.getRezScrollPane().setPrefHeight(newH.doubleValue()-catPane.getControlBox().getHeight()-48);
			});
			showingProperty().addListener((obs,oldH,newH) -> {
				catPane.getCatScrollPane().setPrefHeight(getHeight());
				catPane.getRezScrollPane().setPrefHeight(getHeight()-catPane.getControlBox().getHeight()-48);
				catPane.getRecList().setOnMouseClicked(e-> {
					centerRoot.setRecipe(catPane.getRecList().getSelectionModel().getSelectedItem());
				});
				root.setCenter(centerRoot);
			});

			// make it visible
			show();

			// include stylesheet
			URL url = this.getClass().getResource("CustCss.css");
			if (url == null) {
				System.out.println("Resource not found. Aborting.");
				System.exit(-1);
			}
			String css = url.toExternalForm(); 
			scene.getStylesheets().add(css);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

