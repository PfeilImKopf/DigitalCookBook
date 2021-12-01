package application;

import javafx.beans.binding.Bindings;
import javafx.scene.control.ScrollPane;

public class RezScrollPane extends ScrollPane {

	public RezScrollPane(CatScrollPane catScrollPane) {
		setPrefWidth(180);
		Bindings.bindBidirectional(prefHeightProperty(), catScrollPane.getCatList().getItems().get(catScrollPane.getCatList().getSelectionModel().getSelectedIndex()).getRezList().prefHeightProperty());
	    setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
	    setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
	    setContent(catScrollPane.getCatList().getItems().get(catScrollPane.getCatList().getSelectionModel().getSelectedIndex()).getRezList());
	}

}
