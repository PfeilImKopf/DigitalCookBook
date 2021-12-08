package application;


import CustomStuff.CustomButton;
import RecipePackage.Rezept;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class CatPane extends GridPane {
	CatScrollPane catScrollPane;
	RezScrollPane rezScrollPane;
	Button catButton;
	Label currentCat;
	HBox controlBox ;
	public CatPane(Stage parent) {
		catScrollPane = new CatScrollPane();


		currentCat = new Label("Rezepte aus der Kategorie:\n"+catScrollPane.getCatList()
								.getSelectionModel().getSelectedItem().getName());
		catScrollPane.getCatList().setOnMouseClicked(e->currentCat.setText("Rezepte aus der Kategorie:\n"
								+catScrollPane.getCatList().getSelectionModel().getSelectedItem().getName()));

		//Recipe List
		rezScrollPane = new RezScrollPane(catScrollPane);


		controlBox = new HBox();
		controlBox.setMaxHeight(100);
		catButton = new CustomButton("Neue Kategorie");
		controlBox.getChildren().addAll(catButton);
		for (Node child : controlBox.getChildren()) {
			HBox.setMargin(child, new Insets(5,5,5,5));
		}

		//Listener for stage property to scale the Catlist and rezList
		parent.heightProperty().addListener((obs,oldH,newH) -> {
			catScrollPane.setPrefHeight(newH.doubleValue());
			rezScrollPane.setPrefHeight(newH.doubleValue()-controlBox.getHeight()-48);
		});
		parent.showingProperty().addListener((obs,oldH,newH) -> {
			catScrollPane.setPrefHeight(parent.getHeight());
			rezScrollPane.setPrefHeight(parent.getHeight()-controlBox.getHeight()-48);
		});
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setMaxWidth(180);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setMaxWidth(220);
		RowConstraints row1 = new RowConstraints();
		row1.setPrefHeight(48);
		row1.setMaxHeight(48);
		row1.setMinHeight(48);
		RowConstraints row2 = new RowConstraints();
		Bindings.bindBidirectional(row2.prefHeightProperty(),rezScrollPane.prefHeightProperty());
		RowConstraints row3 = new RowConstraints();
		row3.setPrefHeight(48);
		row3.setMaxHeight(48);
		row3.setMinHeight(48);
		getColumnConstraints().addAll(col1,col2);
		getRowConstraints().addAll(row1,row2,row3);
		add(currentCat,0,0,1,1);
		add(catScrollPane,1,0,1,3);
		add(rezScrollPane,0,1,1,1);
		add(controlBox,0,2,1,1);
	}
	public Rezept getRez() {
		return rezScrollPane.getRez();
	}

}
