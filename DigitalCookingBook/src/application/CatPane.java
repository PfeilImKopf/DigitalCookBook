package application;


import CustomStuff.CustomButton;
import CustomStuff.CustomCatListCell;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class CatPane extends GridPane {
	ListView<Category> catList;
	Button catButton;
	public CatPane() {
		catList=new ListView<Category>();
		catList.getItems().addAll(new Category("Tee"),new Category("Suppen"),new Category("Süßspeisen"));
		catList.setCellFactory(e-> new CustomCatListCell());
		
		
		add(catList.getItems().get(0).getRezList(),0,1);
		add(catList, 1, 1,4,1);
		catButton = new CustomButton("Neue Kategorie hinzufügen");
		catButton.setAlignment(Pos.BOTTOM_CENTER);
		add(new StackPane(catButton),1,2);
	}
}
