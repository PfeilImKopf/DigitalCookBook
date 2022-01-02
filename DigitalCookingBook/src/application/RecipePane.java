package application;

import java.io.File;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.Callable;

import CustomStuff.CustomCatListCell;
import CustomStuff.CustomIngListCell;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import recipeAndCategoryPackage.Ingredients;
import recipeAndCategoryPackage.Instructions;
import recipeAndCategoryPackage.Recipe;

public class RecipePane extends BorderPane {
	private ListView<Ingredients> zutList;
	private GridPane beschList;
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
	private StackPane titleBox;
	private int counter;

	public RecipePane(Recipe recipe) {
		setId("recipe");
		zutList = new ListView<Ingredients>();
		zutList.getItems().addAll(recipe.getIngList());
		zutList.setId("zutList");
		zutList.setMaxWidth(200);
		zutList.setCellFactory(e-> new CustomIngListCell());
		beschList = new GridPane();
		beschList.setId("beschList");
		ColumnConstraints bCol1 = new ColumnConstraints();
		bCol1.setMinWidth(50);
		bCol1.setMaxWidth(50);
		ColumnConstraints bCol2 = new ColumnConstraints();
		bCol2.setPercentWidth(90);
		beschList.getColumnConstraints().addAll(bCol1,bCol2);
		beschList.setVgap(120);
		counter=1;
 
		
		URL url = this.getClass().getResource(recipe.getImage());
		if (url == null) {
			System.out.println("Resource (png) not found. Aborting.");
			System.exit(-1);
		}
		String png = url.toExternalForm(); 
		image = new Image(png);
		imView = new ImageView(image);
		
		
		//leftTop InfoBox for informations of the recipe
		info = new HBox();
		info.setId("info");
		GridPane.setMargin(info, new Insets(20,20,20,20));
		infoL = new VBox();
		infoR = new VBox();
		//Info in the InfoBox
		infoL.getChildren().addAll(new Label("Dauer: "), new Label("Personen: "), new Label("Schwierigkeit: "), new Label("Typ: "));
		for (Node child : infoL.getChildren()) {
			VBox.setMargin(child, new Insets(5,5,5,5));	
		}
		infoL.setAlignment(Pos.CENTER_LEFT);
		infoR.getChildren().addAll(new Label(recipe.getTime()), new Label(Integer.toString(recipe.getPeople())),
				new Label(recipe.getDifficulty()), new Label(recipe.getType()));
		for (Node child : infoR.getChildren()) {
			VBox.setMargin(child, new Insets(5,5,5,5));	
		}
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
		titleBox = new StackPane();
		titleBox.getChildren().add(title);
		titleBox.setId("titleBox");
		centerPane.setTop(titleBox);
		//ScrollPane for the center of the centerPane, so that you can see the image first and scroll
		//down for all instructions. Title will stay visable but the not so important 
		//Image will vanish
		recScroll = new ScrollPane();
		recScroll.setId("recipeScrollPane");
		recScroll.setFitToWidth(true);
		recScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
		recScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		//StackPane to better center the image
		imPane = new StackPane();
		imPane.setId("ImPane");
		imPane.getChildren().add(imView);
		imPane.setMargin(imView, new Insets(15,0,0,0));
		//BorderPane on the ScrollPane for the effect described above
		recBorder = new BorderPane();
		recBorder.setId("recipeBorder");
		recBorder.setTop(imPane);
		recBorder.setCenter(this.beschList);
		BorderPane.setMargin(beschList, new Insets(50,5,50,5));
		//adding everything
		recScroll.setContent(recBorder);
		centerPane.setCenter(recScroll);
		setCenter(centerPane);
		setLeft(leftGrid);
		StackPane filler = new StackPane();
		filler.setId("filler");
		filler.setPrefWidth(20);
		setRight(filler);
		//end of Recipe Contructor
	}

	public ImageView getImView() {
		return imView;
	}


	public ListView<Ingredients> getZutList() {
		return zutList;
	}
	public GridPane getBeschList() {
		return beschList;
	}
	public HBox getInfo() {
		return info;
	}

	public void addIngredient(Ingredients ing) {
		zutList.getItems().add(ing);
	}
	public void addInstruction(Instructions inst) {
		RowConstraints bRow = new RowConstraints();
		beschList.getRowConstraints().add(bRow);
		Label lCount = new Label(Integer.toString(inst.getSchrittNum()));
		lCount.setId("IngLabel");
		GridPane.setValignment(lCount,VPos.TOP);
		beschList.add(lCount,0,counter);
		Label lInst = new Label(inst.getText());
		lInst.setId("IngLabel");
				lInst.setWrapText(true);

		beschList.add(lInst,1, counter++);
	}
}