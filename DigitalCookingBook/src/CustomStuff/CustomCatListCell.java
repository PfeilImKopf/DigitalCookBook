package CustomStuff;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import recipeAndCategoryPackage.Category;

public class CustomCatListCell extends ListCell<Category> {
//	private Circle circle;
	private Label labelName;
	private GridPane gridPane;
	public CustomCatListCell() {
		labelName = new Label();
		labelName.setFont(new Font(20));
		gridPane = new GridPane();
		gridPane.add(labelName,0,0);
		gridPane.setHgap(15);
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
