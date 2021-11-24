package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CenterPane extends GridPane{
	HBox topOfCenterRoot;
public CenterPane() {
	topOfCenterRoot = new HBox();
	topOfCenterRoot.getChildren().addAll(new TextField(),new Button("Zurueck"),new Button("Bearbeiten"),new Button("?"));
	for (Node child : topOfCenterRoot.getChildren()) {
		HBox.setMargin(child, new Insets(15,100,15,100));
	}
	add(topOfCenterRoot,0,0);
}
}
