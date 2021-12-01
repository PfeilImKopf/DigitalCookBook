package application;

import CustomStuff.CustomCatListCell;
import javafx.beans.binding.Bindings;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

public class CatScrollPane extends ScrollPane {
	private ListView<Category> catList;
public CatScrollPane() {
	//Category List 
	setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
    setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	catList=new ListView<Category>();
	catList.setId("catList");
	catList.setPrefWidth(220);
	catList.getItems().addAll(new Category("Tee"),new Category("Suppen"),new Category("Süßspeisen"));
	catList.setCellFactory(e-> new CustomCatListCell());
	catList.setMaxHeight(Double.MAX_VALUE);
	//Height Binding for catList and catPane and catlist to the parent Stage
    Bindings.bindBidirectional(prefHeightProperty(), catList.prefHeightProperty());
	catList.getSelectionModel().selectFirst();
	setContent(catList);
}
public ListView<Category> getCatList() {
	return catList;
}
}
