package application;


import CustomStuff.CustomButton;
import CustomStuff.CustomCatListCell;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;


public class CatPane extends GridPane {
	ListView<Category> catList;
	ScrollPane catPane;
	Button catButton;
	Label currentCat;
	public CatPane() {
		catPane = new ScrollPane();
		catList=new ListView<Category>();
		catList.getItems().addAll(new Category("Tee"),new Category("Suppen"),new Category("Süßspeisen"));
		catList.setCellFactory(e-> new CustomCatListCell());
		catList.setMaxHeight(Double.MAX_VALUE);
		
		ScrollBar sbVertical = new ScrollBar();
		sbVertical.setOrientation(Orientation.VERTICAL);
		catPane.setContent(catList);
	    catPane.prefWidthProperty().bind(catList.widthProperty());
	    catPane.prefHeightProperty().bind(catList.heightProperty());
	    catPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	    catPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	    catList.setMinHeight(USE_PREF_SIZE);
	    catList.setPrefHeight(10000);
		currentCat = new Label("Hallo ich bin ein TEST");
		getRowConstraints().add(new RowConstraints(50));
		add(currentCat,0,0);
		add(catPane,1,0,1,17);
		add(catList.getItems().get(0).getRezList(),0,1,1,5);
		catButton = new CustomButton("Neue Kategorie hinzufügen");
		catButton.setAlignment(Pos.BOTTOM_CENTER);
		add(catButton,0,7);
	}
}
