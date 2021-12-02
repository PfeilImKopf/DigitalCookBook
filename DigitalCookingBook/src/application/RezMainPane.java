package application;

import javafx.scene.layout.FlowPane;

public class RezMainPane extends FlowPane {
	public RezMainPane(Rezept rez) {
		getChildren().addAll(rez.getBeschList(),rez.getZutList());
	}
}
