package application;


import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class CatPane extends BorderPane {
	ListView<String> catList;
	Button catButton;
public CatPane() {
		catList=new ListView<>();
		catList.getItems().addAll("Kat1","Kat2","Kat3");
		setCenter(catList);
		catButton = new Button("Neue Kategorie hinzuf�gen");
		setBottom(new StackPane(catButton));
	}
}
