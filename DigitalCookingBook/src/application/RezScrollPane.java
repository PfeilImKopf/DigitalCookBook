package application;

import CustomStuff.CustomRezListCell;
import RecipePackage.Rezept;
import javafx.beans.binding.Bindings;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;

public class RezScrollPane extends ScrollPane {
	private ListView<Rezept> aktList;
	private Rezept akt;
	public RezScrollPane(CatScrollPane catScrollPane) {
		setPrefWidth(180);
		aktList= catScrollPane.getCatList().getItems().get(catScrollPane.getSelectedIndex()).getRezList();
		aktList.getSelectionModel().selectFirst();
		akt = aktList.getItems().get(aktList.getSelectionModel().getSelectedIndex());
		aktList.setCellFactory(e -> new CustomRezListCell());
		Bindings.bindBidirectional(prefHeightProperty(), catScrollPane.getCatList().getItems().get(catScrollPane.getCatList().getSelectionModel().getSelectedIndex()).getRezList().prefHeightProperty());
		setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		setContent(aktList);

	}
	public Rezept getRez() {
		return akt;
	}
	public ListView<Rezept> getRecipeList() {
		return aktList;
	}
}
