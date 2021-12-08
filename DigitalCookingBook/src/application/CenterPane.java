package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CenterPane extends BorderPane {
	private RezMainPane centerRez;

	public CenterPane(Rezept rez,Stage parent) {
		TopControlPane topControl = new TopControlPane();
		setTop(topControl);
		//centerRez = new RezMainPane(rez,topControl,parent);
		setCenter(rez);

	}
}
