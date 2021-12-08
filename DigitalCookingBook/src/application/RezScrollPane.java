package application;

import CustomStuff.CustomRezListCell;
import javafx.beans.binding.Bindings;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import recipeAndCategoryPackage.Recipe;

public class RezScrollPane extends ScrollPane {
	private ListView<Recipe> aktList;
	private Recipe akt;
	public RezScrollPane(CatScrollPane catScrollPane) {
		setPrefWidth(180);
		aktList= catScrollPane.getCatList().getItems().get(catScrollPane.getSelectedIndex()).getRezList();
		aktList.getSelectionModel().selectFirst();
		aktList.setId("recList");
		akt = aktList.getItems().get(aktList.getSelectionModel().getSelectedIndex());
		aktList.setCellFactory(e -> new CustomRezListCell());
		Bindings.bindBidirectional(prefHeightProperty(), catScrollPane.getCatList().getItems().get(catScrollPane.getCatList().getSelectionModel().getSelectedIndex()).getRezList().prefHeightProperty());
		setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		setContent(aktList);

	}
	public Recipe getRez() {
		return akt;
	}
	public ListView<Recipe> getRecipeList() {
		return aktList;
	}
}
