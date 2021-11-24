package CustomStuff;

import application.Category;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class CustomCatListCell extends ListCell<Category> {
	private Circle circle;
	private Label labelName;
	private GridPane gridPane;
	public CustomCatListCell() {
		circle = new Circle(15,Color.WHITE);
		circle.setStroke(Color.BLACK);
		labelName = new Label();
		gridPane = new GridPane();
		gridPane.add(circle,0,0);
		gridPane.add(labelName,1,0);
		gridPane.setHgap(25);
	}
	@Override
	protected void updateItem(Category cat, boolean empty) {
		super.updateItem(cat, empty);

		if(empty || cat == null) {
			setText(null);
			setGraphic(null);
		} else {
			labelName.setText(cat.getName());
			setGraphic(gridPane);
		}
	}
}
