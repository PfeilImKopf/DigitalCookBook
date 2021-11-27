package application;


import java.io.File;
import java.net.URL;

import CustomStuff.CustomButton;
import CustomStuff.CustomCatListCell;
import javafx.beans.binding.Bindings;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class CatPane extends GridPane {
	ListView<Category> catList;
	ScrollPane catScrollPane;
	Button catButton;
	Label currentCat;
	public CatPane(Stage parent) {
		catScrollPane = new ScrollPane();
	    catScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	    catScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		catList=new ListView<Category>();
		catList.setPrefWidth(220);
		catList.getItems().addAll(new Category("Tee"),new Category("Suppen"),new Category("Süßspeisen"));
		catList.setCellFactory(e-> new CustomCatListCell());
		catList.setMaxHeight(Double.MAX_VALUE);
		catList.setId("catList");

	    Bindings.bindBidirectional(catScrollPane.prefHeightProperty(), catList.prefHeightProperty());
		parent.heightProperty().addListener((obs,oldH,newH) -> catList.setPrefHeight(newH.doubleValue()));
		parent.showingProperty().addListener((obs,oldH,newH) -> catList.setPrefHeight(parent.getHeight()));

		catScrollPane.setContent(catList);
		
		currentCat = new Label("Hallo ich bin ein TEST");
		getRowConstraints().add(new RowConstraints(48));
		add(currentCat,0,0);
		add(catScrollPane,1,0,1,17);
		add(catList.getItems().get(0).getRezList(),0,1,1,5);
		catButton = new CustomButton("Neue Kategorie");
		catButton.setAlignment(Pos.BOTTOM_CENTER);
		add(catButton,0,7);
	}
}
