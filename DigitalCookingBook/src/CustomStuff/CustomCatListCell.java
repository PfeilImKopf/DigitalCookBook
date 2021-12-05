package CustomStuff;

import application.Category;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

public class CustomCatListCell extends ListCell<Category> {
	private Circle circle;
	private Label labelName;
	private GridPane gridPane;
	public CustomCatListCell() {
		circle = new Circle(20,Color.WHITE);
		circle.setStroke(Color.BLACK);
		labelName = new Label();
		labelName.setFont(new Font(20));
		gridPane = new GridPane();
		gridPane.add(circle,0,0);
		gridPane.add(labelName,1,0);
		gridPane.setHgap(15);
		//setStyle("-fx-background-color:green;");
	}
	@Override
	protected void updateItem(Category cat, boolean empty) {
		super.updateItem(cat, empty);

		if(empty || cat == null) {
			setText(null);
			setGraphic(null);
		} else {
			setText(null);
			labelName.setText(cat.getName());
			setGraphic(gridPane);
		}
	}
}
