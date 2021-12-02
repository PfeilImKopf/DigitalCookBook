package application;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class CenterPane extends BorderPane {
	private RezMainPane centerRez;

	public CenterPane(Rezept rez) {
		TopControlPane topControl = new TopControlPane();
		setTop(topControl);
		centerRez = new RezMainPane(rez);
		setCenter(centerRez);

	}
}
