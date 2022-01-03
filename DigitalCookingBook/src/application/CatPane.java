package application;


import java.net.URL;
import java.util.ArrayList;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import recipeAndCategoryPackage.Category;
import recipeAndCategoryPackage.Recipe;


public class CatPane extends GridPane {
	private CatScrollPane catScrollPane;
	private RezScrollPane rezScrollPane;
	private Label currentCat;
	private HBox controlBox ;
	private HBox controlBoxCat ;
	private StackPane labelPane;
	private StackPane labelPaneCat;
	
	public CatPane(ArrayList<Category> allCats) {
		setId("catPane");
		//Category list
		catScrollPane = new CatScrollPane(allCats);
		//Recipe List
		rezScrollPane = new RezScrollPane(catScrollPane);
		
		//labelPane on top of the recipe List
		currentCat = new Label("Rezepte aus der Kategorie:\n"+catScrollPane.getCatList()
		.getSelectionModel().getSelectedItem().getName());

		//finishing the labelPane
		labelPane = new StackPane();
		labelPane.setId("labelPane");
		labelPane.getChildren().add(currentCat);
		
		//finishing labelPaneCat
		labelPaneCat = new StackPane();
		labelPaneCat.setId("labelPane");
		labelPaneCat.getChildren().add(new Label("Wählen sie eine Kategorie"));
		
		




		
		//finishing the controlBox on the bottom of rezList
		controlBox = new HBox();
		controlBox.setId("recipeControlBox");
		controlBox.setMaxHeight(100);
//		catButton = new CustomButton("Neue Kategorie");
//		controlBox.getChildren().addAll(catButton);
//		for (Node child : controlBox.getChildren()) {
//			HBox.setMargin(child, new Insets(5,5,5,5));
//		}
		
		//finishing the controlBoxCat on the bottom of catList
		controlBoxCat = new HBox();
		controlBoxCat.setId("recipeControlBox");
		controlBoxCat.setMaxHeight(100);


		//infoIconBox
		GridPane infoIconBox = new GridPane();
		infoIconBox.setId("infoIconBox");
		infoIconBox.setHgap(14);

		
		RowConstraints rinfo1 = new RowConstraints();
		rinfo1.setPrefHeight(24);
		RowConstraints rinfo2 = new RowConstraints();
		rinfo2.setPrefHeight(24);
//		infoIconBox.getColumnConstraints().addAll(cinfo1,cinfo2,cinfo3);
		infoIconBox.getRowConstraints().addAll(rinfo1,rinfo2);
		URL url1 = this.getClass().getResource("time.png");
		URL url2 = this.getClass().getResource("heavy.png");
		URL url3 = this.getClass().getResource("food.png");
		if (url1 == null || url2 == null || url3 ==null) {
			System.out.println("Resource (png) not found. Aborting.");
			System.exit(-1);
		}
		String png1 = url1.toExternalForm(); 
		String png2 = url2.toExternalForm(); 
		String png3 = url3.toExternalForm();
		Image image1 = new Image(png1);
		ImageView imView1 = new ImageView(image1);
		Image image2 = new Image(png2);
		ImageView imView2 = new ImageView(image2);
		Image image3 = new Image(png3);
		ImageView imView3 = new ImageView(image3);
		imView1.setFitWidth(24);
		imView1.setFitHeight(24);

		infoIconBox.add(imView1, 1, 1);
		imView2.setFitWidth(24);
		imView2.setFitHeight(24);

		infoIconBox.add(imView2, 3, 1);
		imView3.setFitWidth(24);
		imView3.setFitHeight(24);

		infoIconBox.add(imView3, 5, 1);
		infoIconBox.add(new Label("Icon"), 0, 0,6,1);
		

		//setting Insets of all the elements of the CatPane
		GridPane.setMargin(catScrollPane, new Insets(0,15,0,15));
		GridPane.setMargin(labelPaneCat, new Insets(10,15,0,15));
		GridPane.setMargin(controlBoxCat, new Insets(0,15,10,15));
		GridPane.setMargin(rezScrollPane, new Insets(0,0,0,10));
		GridPane.setMargin(controlBox, new Insets(0,0,0,10));
		GridPane.setMargin(labelPane, new Insets(0,0,0,10));
		GridPane.setMargin(infoIconBox,new Insets(0,0,0,10));
		
		//all Constraints for the GridPane of the CatPane itself
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setMaxWidth(180);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setMaxWidth(220);
		RowConstraints row1 = new RowConstraints();
		row1.setPrefHeight(48);
		row1.setMaxHeight(48);
		row1.setMinHeight(48);
		RowConstraints row2 = new RowConstraints();
		row2.setPrefHeight(48);
		row2.setMaxHeight(48);
		row2.setMinHeight(48);
		RowConstraints row3 = new RowConstraints();
		row3.setPrefHeight(48);
		row3.setMaxHeight(48);
		row3.setMinHeight(48);
		RowConstraints row4 = new RowConstraints();
		Bindings.bindBidirectional(row4.prefHeightProperty(),rezScrollPane.prefHeightProperty());
		RowConstraints row5 = new RowConstraints();
		row5.setPrefHeight(48);
		row5.setMaxHeight(48);
		row5.setMinHeight(48);
		RowConstraints row6 = new RowConstraints();
		row6.setPrefHeight(48);
		row6.setMaxHeight(48);
		row6.setMinHeight(48);
		getColumnConstraints().addAll(col1,col2);
		getRowConstraints().addAll(row1,row2,row3,row4,row5,row6);
		add(labelPane,0,1,1,1);
		add(labelPaneCat,1,0,1,1);
		add(infoIconBox,0,2,1,1);
		add(catScrollPane,1,1,1,4);
		add(rezScrollPane,0,3,1,1);
		add(controlBox,0,4,1,1);
		add(controlBoxCat,1,5,1,1);
		

	}
	public HBox getControlBox() {
		return controlBox;
	}
	public CatScrollPane getCatScrollPane() {
		return catScrollPane;
	}
	public ListView<Category> getCatList() {
		return catScrollPane.getCatList();
	}
	public Label getCurrentCat() {
		return currentCat;
	}
	public RezScrollPane getRezScrollPane() {
		return rezScrollPane;
	}
	public Recipe getRecipe() {
		return rezScrollPane.getRez();
	}
	public ListView<Recipe> getRecList() {
		return rezScrollPane.getRecipeList();
	}

}
