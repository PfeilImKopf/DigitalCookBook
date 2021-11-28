package application;


import java.io.File;
import java.net.URL;

import CustomStuff.CustomButton;
import CustomStuff.CustomCatListCell;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class CatPane extends GridPane {
	ListView<Category> catList;
	ScrollPane catScrollPane;
	ScrollPane rezScrollPane;
	Button catButton;
	Label currentCat;
	HBox controlBox ;
	public CatPane(Stage parent) {
		//Category List 
		catScrollPane = new ScrollPane();
	    catScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	    catScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		catList=new ListView<Category>();
		catList.setPrefWidth(220);
		catList.getItems().addAll(new Category("Tee"),new Category("Suppen"),new Category("Süßspeisen"));
		catList.setCellFactory(e-> new CustomCatListCell());
		catList.setMaxHeight(Double.MAX_VALUE);
		catList.setId("catList");
		//Height Binding for catList and catPane and catlist to the parent Stage
	    Bindings.bindBidirectional(catScrollPane.prefHeightProperty(), catList.prefHeightProperty());


		catScrollPane.setContent(catList);
		
		currentCat = new Label("Hallo ich bin ein TEST");
		
		catList.getSelectionModel().selectFirst();
		//Recipe List
		rezScrollPane = new ScrollPane();
		rezScrollPane.setPrefWidth(180);
		Bindings.bindBidirectional(rezScrollPane.prefHeightProperty(), catList.getItems().get(catList.getSelectionModel().getSelectedIndex()).getRezList().prefHeightProperty());
	    rezScrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	    rezScrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	    rezScrollPane.setContent(catList.getItems().get(catList.getSelectionModel().getSelectedIndex()).getRezList());

	    
	    controlBox = new HBox();
	    controlBox.setMaxHeight(100);
		catButton = new CustomButton("Neue Kategorie");
		catButton.setAlignment(Pos.BOTTOM_CENTER);
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
        getRowConstraints().addAll(row1,row2,row3);
		add(currentCat,0,0,1,1);
		add(catScrollPane,1,0,1,3);
		add(rezScrollPane,0,1,1,1);
		add(controlBox,0,2,1,1);
	}
}
