package application;

import java.util.ArrayList;

import CustomStuff.CustomCatListCell;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import recipeAndCategoryPackage.Category;

public class CatScrollPane extends ScrollPane {
	private ListView<Category> catList;
public CatScrollPane(ArrayList<Category> allCats) {
	//Category List 
	setId("catListScroll");
	setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	catList=new ListView<Category>();
	catList.setId("catList");
	catList.setPrefWidth(220);
	catList.getItems().addAll(allCats);
	catList.setCellFactory(e-> new CustomCatListCell());
	catList.setMaxHeight(Double.MAX_VALUE);
	//Height Binding for catList and catPane and catlist to the parent Stage
    catList.prefHeightProperty().bind(prefHeightProperty());
	catList.getSelectionModel().selectFirst();
	setContent(catList);
}
public ListView<Category> getCatList() {
	return catList;
}
public int getSelectedIndex() {
	return getCatList().getSelectionModel().getSelectedIndex();
}
}
