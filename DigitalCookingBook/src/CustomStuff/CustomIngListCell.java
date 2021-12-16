package CustomStuff;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import recipeAndCategoryPackage.Ingredients;

public class CustomIngListCell extends ListCell<Ingredients> {
	private Label labelName;
	private GridPane gridPane;
	private Label amount;
	private Label unit;
	public CustomIngListCell() {
		labelName = new Label();
		gridPane = new GridPane();
		amount = new Label();
		unit = new Label();
		ColumnConstraints col1 = new ColumnConstraints();
		ColumnConstraints col2 = new ColumnConstraints();
		ColumnConstraints col3 = new ColumnConstraints();
		col1.setPercentWidth(20);
		col2.setPercentWidth(20);
		col3.setPercentWidth(60);
		gridPane.getColumnConstraints().addAll(col1,col2,col3);
		gridPane.add(amount,0,0);
		gridPane.add(unit,1,0);
		gridPane.add(labelName,2,0);
		gridPane.setHgap(5);
		labelName.setFont(new Font(16));
		amount.setFont(new Font(16));
		unit.setFont(new Font(16));
	}
	@Override
	protected void updateItem(Ingredients ing, boolean empty) {
		super.updateItem(ing, empty);

		if(empty || ing == null) {
			setText(null);
			setGraphic(null);
		} else {
			setText(null);
			labelName.setText(ing.getName());
			amount.setText(Double.toString(ing.getMenge()));
			unit.setText(ing.getEinheit());
			setGraphic(gridPane);
		}
	}
}