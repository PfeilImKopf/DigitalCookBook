package CustomStuff;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import recipeAndCategoryPackage.Recipe;

public class CustomRezListCell extends ListCell<Recipe> {
	private StackPane stack1;
	private Text text1;
	private Circle circle1;
	private Circle circle2;
	private Circle circle3;
	private Label labelName;
	private GridPane gridPane;
	public CustomRezListCell() {
		circle1 = new Circle(11,Color.WHITE);
		circle1.setStroke(Color.BLACK);
		circle2 = new Circle(11,Color.WHITE);
		circle2.setStroke(Color.BLACK);
		circle3 = new Circle(11,Color.WHITE);
		circle3.setStroke(Color.BLACK);
		stack1 = new StackPane();
		text1 = new Text();
		stack1.getChildren().addAll(circle1,text1);
		labelName = new Label();
		GridPane.setHalignment(labelName, HPos.CENTER);
		labelName.setFont(new Font(15));
		
		gridPane = new GridPane();
		gridPane.add(stack1, 1, 0);
		gridPane.add(circle2, 3, 0);
		gridPane.add(circle3, 5, 0);
		gridPane.add(labelName,0,1,6,1);
		gridPane.setHgap(12);
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
			text1.setText(rez.getTime().replaceAll("[^0-9]",""));
			setGraphic(gridPane);
		}
	}
}
