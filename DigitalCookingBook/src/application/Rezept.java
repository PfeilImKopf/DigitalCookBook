package application;

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

public class Rezept extends BorderPane {
	private String name;
	private ListView<Zutaten> zutList;
	private ListView<Beschreibung> beschList;
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
	public Rezept() {
		this("....");
	}
	public Rezept(String name) {
		this.name = name;
		zutList = new ListView<Zutaten>();
		zutList.setMaxWidth(200);
		zutList.getItems().add(new Zutaten(0, "ml", "Wasser"));
		beschList = new ListView<Beschreibung>();
		beschList.setMaxWidth(400);
		beschList.getItems().add(new Beschreibung(1,"Wasser in Kanne kippen"));
		  URL url = this.getClass().getResource("Tee.png");
		    if (url == null) {
		        System.out.println("Resource (png) not found. Aborting.");
		        System.exit(-1);
		    }
		    String png = url.toExternalForm(); 
		   image = new Image(png);
		imView = new ImageView(image);
		info = new HBox();
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
		row1.setPercentHeight(38.2);
		RowConstraints row2 = new RowConstraints();
		row2.setPercentHeight(61.8);
		leftGrid.getRowConstraints().addAll(row1,row2);
        leftGrid.add(info, 0, 0);
        leftGrid.add(zutList, 0, 1);
        leftGrid.setStyle("-fx-background-color:red;");
		setLeft(leftGrid);
		centerPane = new BorderPane();
        centerPane.setTop(title);
        BorderPane.setAlignment(title, Pos.CENTER);
        recScroll = new ScrollPane();
        imPane = new StackPane();
        imPane.getChildren().add(imView);
        recScroll.setFitToWidth(true);
        recBorder = new BorderPane();
        recBorder.setTop(imPane);
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
	public ListView<Zutaten> getZutList() {
		return zutList;
	}
	public ListView<Beschreibung> getBeschList() {
		return beschList;
	}
	public HBox getInfo() {
		return info;
	}

	
}
