package application;


import CustomStuff.CustomButton;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import recipeAndCategoryPackage.Recipe;


public class CatPane extends GridPane {
	private CatScrollPane catScrollPane;
	private RezScrollPane rezScrollPane;
	private Button catButton;
	private Label currentCat;
	private HBox controlBox ;
	private StackPane labelPane;
	public CatPane(Stage parent) {
		setId("catPane");
		catScrollPane = new CatScrollPane();
		GridPane.setMargin(catScrollPane, new Insets(15,15,15,15));

		currentCat = new Label("Rezepte aus der Kategorie:\n"+catScrollPane.getCatList()
								.getSelectionModel().getSelectedItem().getName());
		catScrollPane.getCatList().setOnMouseClicked(e->currentCat.setText("Rezepte aus der Kategorie:\n"
								+catScrollPane.getCatList().getSelectionModel().getSelectedItem().getName()));

		//Recipe List
		rezScrollPane = new RezScrollPane(catScrollPane);
		GridPane.setMargin(rezScrollPane, new Insets(0,0,0,10));
		

		controlBox = new HBox();
		controlBox.setId("recipeControlBox");
		controlBox.setMaxHeight(100);
		catButton = new CustomButton("Neue Kategorie");
		controlBox.getChildren().addAll(catButton);
		for (Node child : controlBox.getChildren()) {
			HBox.setMargin(child, new Insets(5,5,5,5));
		}
		GridPane.setMargin(controlBox, new Insets(0,0,10,10));
		//Listener for stage property to scale the Catlist and rezList
		parent.heightProperty().addListener((obs,oldH,newH) -> {
			catScrollPane.setPrefHeight(newH.doubleValue());
			rezScrollPane.setPrefHeight(newH.doubleValue()-controlBox.getHeight()-48);
		});
		parent.showingProperty().addListener((obs,oldH,newH) -> {
			catScrollPane.setPrefHeight(parent.getHeight());
			rezScrollPane.setPrefHeight(parent.getHeight()-controlBox.getHeight()-48);
		});
		labelPane = new StackPane();
		labelPane.setId("labelPane");
		labelPane.getChildren().add(currentCat);
		GridPane.setMargin(labelPane, new Insets(10,0,0,10));
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setMaxWidth(180);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setMaxWidth(220);
		RowConstraints row1 = new RowConstraints();
		row1.setPrefHeight(48);
		row1.setMaxHeight(48);
		row1.setMinHeight(48);
		RowConstraints row2 = new RowConstraints();
		row2.setPrefHeight(48);
		row2.setMaxHeight(48);
		row2.setMinHeight(48);
		RowConstraints row3 = new RowConstraints();
		Bindings.bindBidirectional(row3.prefHeightProperty(),rezScrollPane.prefHeightProperty());
		RowConstraints row4 = new RowConstraints();
		row4.setPrefHeight(48);
		row4.setMaxHeight(48);
		row4.setMinHeight(48);
		RowConstraints row5 = new RowConstraints();
		row5.setPrefHeight(48);
		row5.setMaxHeight(48);
		row5.setMinHeight(48);
		getColumnConstraints().addAll(col1,col2);
		getRowConstraints().addAll(row1,row2,row3,row4,row5);
		add(labelPane,0,1,1,1);
		add(catScrollPane,1,0,1,5);
		add(rezScrollPane,0,2,1,1);
		add(controlBox,0,3,1,1);
	}
	public Recipe getRecipe() {
		return rezScrollPane.getRez();
	}
	public ListView<Recipe> getRecList() {
		return rezScrollPane.getRecipeList();
	}

}
