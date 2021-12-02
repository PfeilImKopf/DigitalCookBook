package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TopControlPane extends HBox {
	public TopControlPane() {
		getChildren().addAll(new TextField(),new Button("Zurueck"),new Button("Bearbeiten"),new Button("?"));
		for (Node child : getChildren()) {
			HBox.setMargin(child, new Insets(15,50,15,50));	
		}
		setStyle("-fx-background-color:blue");
	}
}
