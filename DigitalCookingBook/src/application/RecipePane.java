package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;

import CustomStuff.CustomIngListCell;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import recipeAndCategoryPackage.Ingredients;
import recipeAndCategoryPackage.Instructions;
import recipeAndCategoryPackage.Recipe;

public class RecipePane extends BorderPane {
	private ListView<Ingredients> zutList;
	private GridPane instructList;
	private Image image;
	private ImageView imView;
	private HBox info;
	private VBox infoL;
	private VBox infoR;
	private Label title;
	private GridPane leftGrid;
	private BorderPane centerPane;
	private ScrollPane recScroll;
	private BorderPane recBorder;
	private StackPane imPane;
	private GridPane titleBox;
	private int counter;
	private StackPane filler;
	private StackPane filler2;
	private Button fullScreen;

	public RecipePane(Recipe recipe) {
		setId("recipe");
		zutList = new ListView<Ingredients>();
		infoL = new VBox();
		infoR = new VBox();
		instructList = new GridPane();
		imPane = new StackPane();
		setRecipe(recipe);	
		instructList.setId("beschList");
		zutList.setId("zutList");
		zutList.setMaxWidth(200);
		zutList.setCellFactory(e-> new CustomIngListCell());
		RowConstraints bRow = new RowConstraints();
		instructList.getRowConstraints().add(bRow);
		ColumnConstraints bCol1 = new ColumnConstraints();
		bCol1.setMinWidth(50);
		bCol1.setMaxWidth(50);
		ColumnConstraints bCol2 = new ColumnConstraints();
		bCol2.setPercentWidth(90);
		instructList.getColumnConstraints().addAll(bCol1,bCol2);
		instructList.setVgap(120);

 
		
		
		//leftTop InfoBox for informations of the recipe
		info = new HBox();
		info.setId("info");
		GridPane.setMargin(info, new Insets(20,20,20,20));

		//Info in the InfoBox
		infoL.getChildren().addAll(new Label("Dauer: "), new Label("Personen: "), new Label("Schwierigkeit: "), new Label("Typ: "));
		for (Node child : infoL.getChildren()) {
			VBox.setMargin(child, new Insets(5,5,5,5));	
		}
		infoL.setAlignment(Pos.CENTER_LEFT);
		
		
		infoR.setAlignment(Pos.CENTER_RIGHT);
		info.getChildren().addAll(infoL, infoR);
		for (Node child : info.getChildren()) {
			HBox.setMargin(child, new Insets(10,10,10,10));	
		}
		info.setAlignment(Pos.CENTER);

		title = new Label(recipe.getName());
		title.setId("recTitle");

		
		//gridPane for the left side with Info and Ingredients
		leftGrid = new GridPane();
		RowConstraints row1 = new RowConstraints();
		row1.setMaxHeight(200);
		row1.setMinHeight(200);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(61.8);
		leftGrid.getRowConstraints().addAll(row1,row2);
		//adding infoBox and IngredientList to the leftGrid
		leftGrid.add(info, 0, 0);
		leftGrid.add(zutList, 0, 1);
		leftGrid.setId("recipeLeftGrid");
		GridPane.setMargin(zutList, new Insets(5,20,5,20));

		
		
		//BorderPane for the center for title, Image and Instructions
		centerPane = new BorderPane();
		
		
		//title on the top
		titleBox = new GridPane();
		titleBox.setId("titleBox");
		ColumnConstraints titleCol1 = new ColumnConstraints();
		titleCol1.setPercentWidth(10);
		ColumnConstraints titleCol2 = new ColumnConstraints();
		titleCol2.setPercentWidth(80);
		ColumnConstraints titleCol3 = new ColumnConstraints();
		titleCol3.setPercentWidth(10);
		titleBox.getColumnConstraints().addAll(titleCol1,titleCol2,titleCol3);
		
		//Button for fullscreen
		fullScreen = new Button("TEST");
		
		titleBox.add(title, 1,0);
		titleBox.add(fullScreen, 2,0);
		GridPane.setHalignment(title, HPos.CENTER);
		GridPane.setHalignment(fullScreen, HPos.RIGHT);
		centerPane.setTop(titleBox);
		//ScrollPane for the center of the centerPane, so that you can see the image first and scroll
		//down for all instructions. Title will stay visable but the not so important 
		//Image will vanish
		recScroll = new ScrollPane();
		recScroll.setId("recipeScrollPane");
		recScroll.setFitToWidth(true);
		recScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		recScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		//BorderPane.setMargin(recScroll, new Insets(0,1,0,1));
		//StackPane to better center the image

		StackPane.setMargin(imView, new Insets(15,0,0,0));
		//BorderPane on the ScrollPane for the effect described above
		recBorder = new BorderPane();
		recBorder.setId("recipeBorder");
		recBorder.setTop(imPane);
		recBorder.setCenter(this.instructList);
		BorderPane.setMargin(instructList, new Insets(50,5,50,5));
		//adding everything
		recScroll.setContent(recBorder);
		centerPane.setCenter(recScroll);
		setCenter(centerPane);
		setLeft(leftGrid);
		filler = new StackPane();
		filler.setId("filler");
		filler.setPrefWidth(20);
		setRight(filler);
		filler2 = new StackPane();
		filler2.setId("filler");
		filler2.setPrefHeight(20);
		setBottom(filler2);
		//end of Recipe Contructor
	}

	public Button getFullScreen() {
		return fullScreen;
	}

	public ImageView getImView() {
		return imView;
	}


	public ListView<Ingredients> getZutList() {
		return zutList;
	}
	public GridPane getBeschList() {
		return instructList;
	}
	public HBox getInfo() {
		return info;
	}

	public void addIngredient(Ingredients ing) {
		zutList.getItems().add(ing);
	}
	private void setZutList(Recipe recipe) {
		zutList.getItems().clear();
		zutList.getItems().addAll(recipe.getIngList());
	}
	private void setInfos(Recipe recipe) {
		infoR.getChildren().clear();
		infoR.getChildren().addAll(new Label(recipe.getTime()), new Label(Integer.toString(recipe.getPeople())),
				new Label(recipe.getDifficulty()), new Label(recipe.getType()));
		for (Node child : infoR.getChildren()) {
			VBox.setMargin(child, new Insets(5,5,5,5));
		}
	}
	private void setImView(Recipe recipe) {
		try {
			imPane.getChildren().clear();
			if ( recipe.getImage().isEmpty()) {
				  URL url = this.getClass().getResource("Tee.png");
				  String png = url.toExternalForm(); 
			      image = new Image(png);
			} else {
				image = new Image(new FileInputStream(recipe.getImage()));
				
			}
			imView = new ImageView(image);
			imPane.setId("ImPane");
			imPane.getChildren().add(imView);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void setInstructions(Recipe recipe) {
		counter=1;
		instructList.getChildren().clear();
		for (Instructions inst : recipe.getInstList()) {

			Label lCount = new Label(Integer.toString(inst.getSchrittNum()));
			lCount.setId("IngLabel");
			GridPane.setValignment(lCount,VPos.TOP);
			instructList.add(lCount,0,counter);
			Label lInst = new Label(inst.getText());
			lInst.setId("IngLabel");
					lInst.setWrapText(true);

			instructList.add(lInst,1, counter++);
		}
	}
	public void setRecipe(Recipe recipe) {
		setZutList(recipe); 
		setInfos(recipe);
		setImView(recipe);
		setInstructions(recipe);
	}

}