package application;


import java.net.URL;

import CustomStuff.CustomButton;
import javafx.beans.binding.Bindings;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import recipeAndCategoryPackage.Recipe;


public class CatPane extends GridPane {
	private CatScrollPane catScrollPane;
	private RezScrollPane rezScrollPane;
	private Button catButton;
	private Label currentCat;
	private HBox controlBox ;
	private StackPane labelPane;
	public CatPane(Stage parent) {
		setId("catPane");
		//Category list
		catScrollPane = new CatScrollPane();
		//Recipe List
		rezScrollPane = new RezScrollPane(catScrollPane);
		//Controlbox at the bottom of the recipe list
		controlBox = new HBox();
		//labelPane on top of the recipe List
		currentCat = new Label("Rezepte aus der Kategorie:\n"+catScrollPane.getCatList()
		.getSelectionModel().getSelectedItem().getName());
		labelPane = new StackPane();
		

		
		
		//Listener for updating the current label
		catScrollPane.getCatList().setOnMouseClicked(e->currentCat.setText("Rezepte aus der Kategorie:\n"
								+catScrollPane.getCatList().getSelectionModel().getSelectedItem().getName()));



		
		//finishing the controlBox on the bottom of rezList
		controlBox.setId("recipeControlBox");
		controlBox.setMaxHeight(100);
		catButton = new CustomButton("Neue Kategorie");
		controlBox.getChildren().addAll(catButton);
		for (Node child : controlBox.getChildren()) {
			HBox.setMargin(child, new Insets(5,5,5,5));
		}

		//finishing the labelPane
		labelPane.setId("labelPane");
		labelPane.getChildren().add(currentCat);

		//infoIconBox
		GridPane infoIconBox = new GridPane();
		infoIconBox.setHgap(14);
//		ColumnConstraints cinfo1 = new ColumnConstraints();
//		cinfo1.setPercentWidth(30);
//		ColumnConstraints cinfo2 = new ColumnConstraints();
//		cinfo2.setPercentWidth(30);
//		ColumnConstraints cinfo3 = new ColumnConstraints();
//		cinfo3.setPercentWidth(30);
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
		
		//Listener for stage property to scale the Catlist and rezList
		parent.heightProperty().addListener((obs,oldH,newH) -> {
			catScrollPane.setPrefHeight(newH.doubleValue());
			rezScrollPane.setPrefHeight(newH.doubleValue()-controlBox.getHeight()-48);
		});
		parent.showingProperty().addListener((obs,oldH,newH) -> {
			catScrollPane.setPrefHeight(parent.getHeight());
			rezScrollPane.setPrefHeight(parent.getHeight()-controlBox.getHeight()-48);
		});
		//setting Insets of all the elements of the CatPane
		GridPane.setMargin(catScrollPane, new Insets(15,15,15,15));
		GridPane.setMargin(rezScrollPane, new Insets(0,0,0,10));
		GridPane.setMargin(controlBox, new Insets(0,0,10,10));
		GridPane.setMargin(labelPane, new Insets(10,0,0,10));
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
		Bindings.bindBidirectional(row3.prefHeightProperty(),rezScrollPane.prefHeightProperty());
		RowConstraints row4 = new RowConstraints();
		row4.setPrefHeight(48);
		row4.setMaxHeight(48);
		row4.setMinHeight(48);
		RowConstraints row5 = new RowConstraints();
		row5.setPrefHeight(48);
		row5.setMaxHeight(48);
		row5.setMinHeight(48);
		getColumnConstraints().addAll(col1,col2);
		getRowConstraints().addAll(row1,row2,row3,row4,row5);
		add(labelPane,0,0,1,1);
		add(infoIconBox,0,1,1,1);
		add(catScrollPane,1,0,1,5);
		add(rezScrollPane,0,2,1,1);
		add(controlBox,0,3,1,1);
	}
	public Recipe getRecipe() {
		return rezScrollPane.getRez();
	}
	public ListView<Recipe> getRecList() {
		return rezScrollPane.getRecipeList();
	}

}
