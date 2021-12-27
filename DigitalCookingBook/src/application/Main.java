package application;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			GridPane root = new GridPane();
			
			Label labelHead = new Label("Digital Cook Book");
			labelHead.setAlignment(Pos.CENTER);
			labelHead.setTextAlignment(TextAlignment.CENTER);
			labelHead.setFont(new Font("Arial", 28));
			
			Button buttonWrite = new Button("Write Recipe");
			Button buttonShow = new Button("Show Recipe List");
			Button buttonQuit = new Button("Quit");
			buttonWrite.setMinWidth(220);
			buttonWrite.setFont(new Font("Arial", 20));
			buttonWrite.setTextAlignment(TextAlignment.CENTER);
			buttonShow.setMinWidth(220);
			buttonShow.setFont(new Font("Arial", 20));
			buttonShow.setTextAlignment(TextAlignment.CENTER);
			buttonShow.setOnAction(event -> {
				Stage cb = new CookBook();
				primaryStage.hide();
			});
			buttonQuit.setMinWidth(220);
			buttonQuit.setFont(new Font("Arial", 20));
			buttonQuit.setTextAlignment(TextAlignment.CENTER);
			buttonQuit.setOnAction(event -> System.exit(0));
			
			
			root.setPadding(new Insets(10, 10, 10, 10));
			root.setHgap(20);
			root.setVgap(20);
			root.add(labelHead, 1, 0, 1, 1);
			root.add((new Label()), 1, 1);
			root.add(buttonWrite, 1, 2, 1, 1);
			root.add(buttonShow, 1, 3, 1, 1);
			root.add(buttonQuit, 1, 4, 1, 1);
			root.setAlignment(Pos.CENTER);
		
			Scene scene = new Scene(root,1000,800);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("Digital Cook Book");
			primaryStage.setResizable(false);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
