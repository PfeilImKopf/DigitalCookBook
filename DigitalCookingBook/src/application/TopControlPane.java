package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TopControlPane extends HBox {
	public TopControlPane() {
		setId("topControl");
		getChildren().addAll(new TextField(),new Button("Zurueck"),new Button("Bearbeiten"),new Button("?"));
		for (Node child : getChildren()) {
			HBox.setMargin(child, new Insets(10,50,0,50));	
		}
		setMinHeight(48);
		setMaxHeight(48);
	}
}
