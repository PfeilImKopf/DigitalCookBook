package application;

import java.net.URL;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
			primaryStage.setTitle("Digitales Kochbuch");
			//category and recipe list on the right
			CatPane catPane = new CatPane(primaryStage);
			StackPane stackCatPane = new StackPane();
			stackCatPane.getChildren().add(catPane);
			stackCatPane.setId("stackCatPane");
			root.setRight(stackCatPane);
			
			// everything else on the left/center
			CenterPane centerRoot = new CenterPane(catPane.getRecipe(),primaryStage);
			catPane.getRecList().setOnMouseClicked(e-> {
				centerRoot.setRecipe(catPane.getRecList().getSelectionModel().getSelectedItem());
			});
			root.setCenter(centerRoot);
			
			// make it visible
			primaryStage.show();
			
			// include stylesheet
			URL url = this.getClass().getResource("CustCss.css");
			if (url == null) {
				System.out.println("Resource not found. Aborting.");
				System.exit(-1);
			}
			String css = url.toExternalForm(); 
			scene.getStylesheets().add(css);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}