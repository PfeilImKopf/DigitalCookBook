package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CookBook extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			//category list on the right
			ListView<String> catList = new ListView<>();
			catList.getItems().addAll("Kat1","Kat2","Kat3");
			BorderPane catPane = new BorderPane();
			catPane.setCenter(catList);
			Button catButton = new Button("Neue Kategorie hinzufügen");
			catPane.setBottom(new StackPane(catButton));
			root.setRight(catPane);
			// everything else on the left
			GridPane centerRoot = new GridPane();
			HBox topOfCenterRoot = new HBox();
			topOfCenterRoot.getChildren().addAll(new TextField(),new Button("Zurueck"),new Button("Bearbeiten"),new Button("?"));
			for (Node child : topOfCenterRoot.getChildren()) {
				HBox.setMargin(child, new Insets(15,100,15,100));
			}
			centerRoot.addColumn(0, topOfCenterRoot);
			root.setCenter(centerRoot);
			// make it visible
			Scene scene = new Scene(root,1500,1000);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}