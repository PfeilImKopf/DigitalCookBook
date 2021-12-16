package recipeAndCategoryPackage;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.Callable;

import CustomStuff.CustomCatListCell;
import CustomStuff.CustomIngListCell;
import javafx.beans.binding.Bindings;
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

public class Recipe extends BorderPane {
	private String name;
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
	public Recipe() {
		this("....");
	}
	public Recipe(String name) {
		this.name = name;
		zutList = new ListView<Ingredients>();
		zutList.setId("zutList");
		zutList.setMaxWidth(200);
		for (int i=0;i<20;i++) {
		zutList.getItems().add(new Ingredients(i, "ml", "Wasser"));
		}
		zutList.setCellFactory(e-> new CustomIngListCell());
		beschList = new GridPane();
		ColumnConstraints bCol1 = new ColumnConstraints();
		bCol1.setMinWidth(30);
		bCol1.setMaxWidth(30);
		ColumnConstraints bCol2 = new ColumnConstraints();
		bCol2.setPercentWidth(90);
		beschList.getColumnConstraints().addAll(bCol1,bCol2);
		beschList.setVgap(120);
		for (int i = 0; i<10;i++) {
			RowConstraints bRow = new RowConstraints();
			beschList.getRowConstraints().add(bRow);
			Label lCount = new Label(i+1+".");
			lCount.setId("IngLabel");
			GridPane.setValignment(lCount,VPos.TOP);
			beschList.add(lCount,0,i);
			Label lInst = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing elit,"
					+ " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut "
					+ "enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut"
					+ " aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit"
					+ " in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur"
					+ " sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"
					+ " mollit anim id est laborum.");
			lInst.setId("IngLabel");
					lInst.setWrapText(true);

			beschList.add(lInst,1, i);
		}
		URL url = this.getClass().getResource("Tee.png");
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
		infoR.getChildren().addAll(new Label("30 min"), new Label("4"), new Label("Leicht"), new Label("Vegan"));
		for (Node child : infoR.getChildren()) {
			VBox.setMargin(child, new Insets(5,5,5,5));	
		}
		infoR.setAlignment(Pos.CENTER_RIGHT);
		info.getChildren().addAll(infoL, infoR);
		for (Node child : info.getChildren()) {
			HBox.setMargin(child, new Insets(10,10,10,10));	
		}
		info.setAlignment(Pos.CENTER);

		title = new Label(this.name);
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
		imPane.getChildren().add(imView);
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
		//end of Recipe Contructor
	}
	public ImageView getImView() {
		return imView;
	}
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return name;
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


}
