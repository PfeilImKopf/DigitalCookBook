package application;

import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class RezMainPane extends GridPane {
	public RezMainPane(Rezept rez,TopControlPane topControl) {
		
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setMinWidth(440);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setMinWidth(440);
		topControl.widthProperty().addListener((obs,oldH,newH) -> {
			col1.setMinWidth(newH.doubleValue()/3);
			col2.setMinWidth(newH.doubleValue()*2/3);
		});
		setVgap(45);
		getColumnConstraints().addAll(col1,col2);
		add(rez.getZutList(),0,1);
		add(rez.getImView(),0,0,2,1);
		add(rez.getBeschList(),1,1);
		setStyle("-fx-background-color: DAE6F3;");
		GridPane.setHalignment(rez.getImView(),HPos.CENTER);
		GridPane.setHalignment(rez.getZutList(),HPos.CENTER);
		GridPane.setHalignment(rez.getBeschList(),HPos.CENTER);
	}
}
