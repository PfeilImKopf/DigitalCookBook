package application;

import java.net.URL;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CookBook extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//CustomStage primaryStage = new CustomStage();
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,1280,720);
			primaryStage.setScene(scene);
			primaryStage.setMinWidth(1280);
			primaryStage.setMinHeight(720);
			//category list on the right		
			CatPane catPane = new CatPane(primaryStage);
			root.setRight(catPane);
			// everything else on the left

			CenterPane centerRoot = new CenterPane(catPane.getRez(),primaryStage);
			root.setCenter(centerRoot);
			// make it visible
			  URL url = this.getClass().getResource("CustCss.css");
			    if (url == null) {
			        System.out.println("Resource not found. Aborting.");
			        System.exit(-1);
			    }
			    String css = url.toExternalForm(); 
			   scene.getStylesheets().add(css);
		
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}