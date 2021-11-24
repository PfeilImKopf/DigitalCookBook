package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CookBook extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			//category list on the right		
			CatPane catPane = new CatPane();
			root.setRight(catPane);
			// everything else on the left
			CenterPane centerRoot = new CenterPane();
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