package application;


import CustomStuff.CustomButton;
import CustomStuff.CustomCatListCell;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

public class CatPane extends BorderPane {
	ListView<Category> catList;
	Button catButton;
	public CatPane() {
		catList=new ListView<Category>();
		catList.getItems().addAll(new Category(),new Category("Suppen"),new Category("Süßspeisen"));
		catList.setCellFactory(e-> new CustomCatListCell());
		setCenter(catList);
		catButton = new CustomButton("Neue Kategorie hinzufügen");
		setBottom(new StackPane(catButton));
	}
}
