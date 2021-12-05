package application;

import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class RezMainPane extends GridPane {
	public RezMainPane(Rezept rez,TopControlPane topControl,Stage parent) {
		setGridLinesVisible(true);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(38.2);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(61.8);
		RowConstraints row1 = new RowConstraints();
		row1.setPercentHeight(38.2);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(61.8);


		getColumnConstraints().addAll(col1,col2);
		getRowConstraints().addAll(row1,row2);
		add(rez.getInfo(),0,0);
		add(rez.getZutList(),0,1);
		add(rez.getImView(),1,0);
		add(rez.getBeschList(),1,1);
		setStyle("-fx-background-color: DAE6F3;");
		GridPane.setHalignment(rez.getInfo(),HPos.CENTER);
		GridPane.setHalignment(rez.getImView(),HPos.CENTER);
		GridPane.setHalignment(rez.getZutList(),HPos.CENTER);
		GridPane.setHalignment(rez.getBeschList(),HPos.CENTER);
	}
}
