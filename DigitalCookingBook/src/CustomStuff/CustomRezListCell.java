package CustomStuff;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import recipeAndCategoryPackage.Recipe;

public class CustomRezListCell extends ListCell<Recipe> {
	private Circle circle1;
	private Circle circle2;
	private Circle circle3;
	private Label labelName;
	private GridPane gridPane;
	public CustomRezListCell() {
		circle1 = new Circle(7,Color.WHITE);
		circle1.setStroke(Color.BLACK);
		circle2 = new Circle(7,Color.WHITE);
		circle2.setStroke(Color.BLACK);
		circle3 = new Circle(7,Color.WHITE);
		circle3.setStroke(Color.BLACK);
		
		labelName = new Label();
		labelName.setFont(new Font(10));
		
		gridPane = new GridPane();
		gridPane.add(circle1, 0, 0);
		gridPane.add(circle2, 1, 0);
		gridPane.add(circle3, 2, 0);
		gridPane.add(labelName,3,0);
		gridPane.setHgap(5);
	}
	@Override
	protected void updateItem(Recipe rez, boolean empty) {
		super.updateItem(rez, empty);
		
		if (empty || rez == null) {
			setText(null);
			setGraphic(null);
		}
		else {
			setText(null);
			labelName.setText(rez.getName());
			setGraphic(gridPane);
		}
	}
}
