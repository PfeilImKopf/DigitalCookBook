package application;

import java.net.URL;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CookBookWriter extends Stage {
	public CookBookWriter() {

		try {
			BorderPane root = new BorderPane();
			GridPane gp = new GridPane();
			VBox fld = new VBox();
			VBox des = new VBox();
			HBox fieldBox = new HBox();
			HBox areaBox = new HBox();
			HBox buttonBox = new HBox();
			Scene scene = new Scene(root,1280,720);
			setScene(scene);
			setMinWidth(1280);
			setMinHeight(720);
			setTitle("Write Recipe");
			show();
			
			Button save = new Button("Speichern");
			Button back = new Button("Zurueck");
			
			TextArea ta = new TextArea();
			
			TextField headField = new TextField();

			TextField duraField = new TextField();
			TextField persField = new TextField();
			TextField diffField = new TextField();
			TextField typeField = new TextField();
			

			
			fld.getChildren().add(headField);
			fld.getChildren().add(duraField);
			fld.getChildren().add(persField);
			fld.getChildren().add(diffField);
			fld.getChildren().add(typeField);
			fld.setSpacing(8);
			
			des.getChildren().add(new Label("Rezeptname: "));
			des.getChildren().add(new Label("Dauer: "));
			des.getChildren().add(new Label("Personenzahl: "));
			des.getChildren().add(new Label("Schwierigkeit: "));
			des.getChildren().add(new Label("Typ: "));
			des.setSpacing(16);
			
			fieldBox.getChildren().add(des);
			fieldBox.getChildren().add(fld);
			fieldBox.setSpacing(37);
			fieldBox.setAlignment(Pos.BASELINE_LEFT);
			
			areaBox.getChildren().add(new Label("Rezeptbeschreibung: "));
			areaBox.getChildren().add(ta);
			
			buttonBox.getChildren().add(save);
			buttonBox.getChildren().add(back);
			buttonBox.setAlignment(Pos.CENTER);
			
			gp.setVgap(10);
			gp.add(fieldBox, 0, 0);
			gp.add(areaBox, 0, 1);
			gp.add(buttonBox, 0, 2);

			gp.setPadding(new Insets(2,2,2,2));
			gp.setAlignment(Pos.CENTER);
			root.setCenter(gp);
			root.setPadding(new Insets(2,2,2,2));
			
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
}

