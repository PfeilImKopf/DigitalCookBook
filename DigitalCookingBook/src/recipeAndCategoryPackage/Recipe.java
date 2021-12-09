package recipeAndCategoryPackage;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Recipe extends BorderPane {
	private String name;
	private ListView<Ingredients> zutList;
	private ListView<Instructions> beschList;
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
		zutList.getItems().add(new Ingredients(0, "ml", "Wasser"));
		beschList = new ListView<Instructions>();
		beschList.setMaxWidth(400);
		beschList.getItems().add(new Instructions(1,"Wasser in Kanne kippen"));
		  URL url = this.getClass().getResource("Tee.png");
		    if (url == null) {
		        System.out.println("Resource (png) not found. Aborting.");
		        System.exit(-1);
		    }
		    String png = url.toExternalForm(); 
		   image = new Image(png);
		imView = new ImageView(image);
		info = new HBox();
		info.setId("info");
		GridPane.setMargin(info, new Insets(20,20,20,20));
		infoL = new VBox();
		infoR = new VBox();
		
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

        leftGrid = new GridPane();
		RowConstraints row1 = new RowConstraints();
		//row1.setPercentHeight(38.2);
		row1.setMaxHeight(200);
		row1.setMinHeight(200);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(61.8);
		leftGrid.getRowConstraints().addAll(row1,row2);
        leftGrid.add(info, 0, 0);
        leftGrid.add(zutList, 0, 1);
        leftGrid.setId("recipeLeftGrid");
        GridPane.setMargin(zutList, new Insets(5,20,5,20));
		setLeft(leftGrid);
		centerPane = new BorderPane();
		titleBox = new StackPane();
		titleBox.getChildren().add(title);
		titleBox.setId("titleBox");
        centerPane.setTop(titleBox);
        recScroll = new ScrollPane();
        recScroll.setId("recipeScrollPane");
        imPane = new StackPane();
        imPane.getChildren().add(imView);
        recScroll.setFitToWidth(true);
        recScroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        recScroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        recBorder = new BorderPane();
        recBorder.setTop(imPane);
        recBorder.setId("recipeBorder");
        recBorder.setCenter(this.beschList);
        BorderPane.setMargin(beschList, new Insets(50,5,50,5));
        recScroll.setContent(recBorder);
        centerPane.setCenter(recScroll);
        setCenter(centerPane);
		
		
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
	public ListView<Instructions> getBeschList() {
		return beschList;
	}
	public HBox getInfo() {
		return info;
	}

	
}
