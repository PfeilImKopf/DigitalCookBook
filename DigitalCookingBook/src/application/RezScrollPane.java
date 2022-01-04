package application;

import CustomStuff.CustomRezListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import recipeAndCategoryPackage.Recipe;

public class RezScrollPane extends ScrollPane {
	private ListView<Recipe> aktList;
	private Recipe akt;
	private CatScrollPane catScrollPane;
	public RezScrollPane(CatScrollPane catScrollPane) {
		this.catScrollPane=catScrollPane;
		setPrefWidth(180);
		setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		setConfig();

	}
	public Recipe getRez() {
		return akt;
	}
	public ListView<Recipe> getRecipeList() {
		return aktList;
	}
	public void setRecipeList(ListView<Recipe> list) {
		aktList=list;
		setConfig();
	}
	private void setConfig() {
		ListView<Recipe> recL = new ListView<Recipe>();
		recL.getItems().addAll(catScrollPane.getCatList().getItems().get(catScrollPane.getSelectedIndex()).getRezList());
		aktList= recL;
		aktList.getSelectionModel().selectFirst();
		aktList.setId("recList");
		akt = aktList.getItems().get(aktList.getSelectionModel().getSelectedIndex());
		aktList.setCellFactory(e -> new CustomRezListCell());
		aktList.prefHeightProperty().bind(prefHeightProperty());
		setContent(aktList);
		
	}
}
