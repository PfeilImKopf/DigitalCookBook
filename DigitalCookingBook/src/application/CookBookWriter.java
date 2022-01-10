package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import recipeAndCategoryPackage.Category;
import recipeAndCategoryPackage.Ingredients;
import recipeAndCategoryPackage.Instructions;
import recipeAndCategoryPackage.Recipe;

public class CookBookWriter extends Stage {
	public CookBookWriter(ArrayList<Category> allCats) {
		try {
			int taCounter = 1;
			ArrayList<TextArea> taList = new ArrayList<TextArea>();
			ArrayList<TextArea> naList = new ArrayList<TextArea>();
			BorderPane root = new BorderPane();
			GridPane gp = new GridPane();
			GridPane taPane = new GridPane();
			VBox fld = new VBox();
			VBox des = new VBox();
			HBox fieldBox = new HBox();
			HBox areaBox = new HBox();
			HBox listBox = new HBox();
			HBox buttonBox = new HBox();
			Scene scene = new Scene(root,1280,720);
			ArrayList<String> al = new ArrayList<String>();
			for (int i = 0; i < allCats.size(); i++) {
				al.add(allCats.get(i).getName());
			}
			setScene(scene);
			setMinWidth(1280);
			setMinHeight(720);
			setTitle("Write Recipe");
			show();
			
			Button save = new Button("Speichern");
			Button back = new Button("Zurueck");
			Button gotoList = new Button("Rezeptliste");
			
			TextArea na = new TextArea("1");
			na.setMaxHeight(20);
			na.setMaxWidth(20);
			TextArea ta = new TextArea();
			na.setEditable(false);
			
			TextField headField = new TextField();
			ComboBox<String> cateField = new ComboBox<String>(FXCollections.observableArrayList(al));
			cateField.setEditable(true);
			cateField.setTooltip(new Tooltip("Waehle eine Kategorie aus oder erstelle eine neue."));
			TextField duraField = new TextField();
			TextField persField = new TextField();
			TextField diffField = new TextField();
			TextField typeField = new TextField();
			TextField measField = new TextField();
			
			ListView<Ingredients> IngeView = new ListView<Ingredients>();
			IngeView.setEditable(true);
			
			taPane.add(na, 0, 0);
			taPane.add(ta, 1, 0);
			
			fld.getChildren().add(headField);
			fld.getChildren().add(cateField);
			fld.getChildren().add(duraField);
			fld.getChildren().add(persField);
			fld.getChildren().add(diffField);
			fld.getChildren().add(typeField);
			fld.getChildren().add(measField);
			fld.getChildren().add(taPane);
			fld.getChildren().add(IngeView);
			fld.setSpacing(8);
			
			des.getChildren().add(new Label("Rezeptname: "));
			des.getChildren().add(new Label("Kategorie: "));
			des.getChildren().add(new Label("Dauer: "));
			des.getChildren().add(new Label("Personenzahl: "));
			des.getChildren().add(new Label("Schwierigkeit: "));
			des.getChildren().add(new Label("Typ: "));
			des.getChildren().add(new Label("Einheit: "));
			des.getChildren().add(new Label("Rezeptbeschreibung: "));
			des.getChildren().add(new Label(" "));
			des.getChildren().add(new Label(" "));
			des.getChildren().add(new Label("Zutaten: "));
			des.setSpacing(16);
			
			fieldBox.getChildren().add(des);
			fieldBox.getChildren().add(fld);
			fieldBox.setSpacing(37);
			fieldBox.setAlignment(Pos.BASELINE_LEFT);
			
//			areaBox.getChildren().add(new Label("Rezeptbeschreibung: "));
//			areaBox.getChildren().add(ta);
			
//			listBox.getChildren().add(new Label("Zutaten: "));
//			listBox.getChildren().add(IngeView);
			
			buttonBox.getChildren().add(save);
			buttonBox.getChildren().add(back);
			buttonBox.getChildren().add(gotoList);
			buttonBox.setAlignment(Pos.CENTER);
			
			taList.add(ta);
			naList.add(na);
			ta.setOnKeyTyped(e -> {
				String s = ta.getText();
				if (s.length() == 1) {
					taList.add(0, new TextArea());
					naList.add(new TextArea(""+(naList.size()+1)));
					naList.get(naList.size()-1).setEditable(false);
					naList.get(naList.size()-1).setMaxHeight(20);
					naList.get(naList.size()-1).setMaxWidth(20);
					for (int i = 0; i < taList.size()-1; i++) {
						taList.get(i).setText(taList.get(i+1).getText());
						taList.get(i+1).setText("");
					}
					taPane.getChildren().clear();
					for (int i = 0; i < taList.size(); i++) {
						taPane.add(naList.get(i), 0, i);
						taPane.add(taList.get(i), 1, i);
					}
					
					taList.get(taList.size()-2).requestFocus();
					taList.get(taList.size()-2).selectEnd();
					taList.get(taList.size()-2).deselect();
				}
			});
			 
			save.setOnAction(e -> {
				try {
					String name = new String(headField.getText());
					Category c = new Category(cateField.getValue());
					String time = new String(duraField.getText());
					String type = new String(typeField.getText());
					int people = Integer.parseInt(persField.getText());
					String measure = new String(measField.getText());
					String difficulty = new String(diffField.getText());
					ArrayList<Ingredients> ingList = new ArrayList<Ingredients>();
					ArrayList<Instructions> instList = new ArrayList<Instructions>();
					String image = new String();
					
					for (int i = 0; i < taList.size();i++) {
						if (taList.get(i).getText().trim() != "") {
							instList.add(new Instructions(Integer.parseInt(naList.get(i).getText()), taList.get(i).getText()));
						}
					}
					Recipe r = new Recipe(name, time, type, people, measure, difficulty, ingList, instList, image);
					
					boolean check = true;
					for (int i = 0; i < allCats.size(); i++) {
						if (allCats.get(i).getName() == c.getName()) {
							check = false;
							allCats.get(i).addRec(r);
						}
					}
					if(check) {
						c.addRec(r);
						allCats.add(c);
					}

				} catch (Exception ex) {
					System.out.println(ex);
				}
			});
			
			gotoList.setOnAction(e -> {
				try {
					new CookBook(allCats);
				} catch (Exception e2) {
					System.out.println(e2);
				}
			});
			
			gp.setVgap(10);
			gp.add(fieldBox, 0, 0);
			gp.add(areaBox, 0, 1);
			gp.add(listBox, 0, 2);
			gp.add(buttonBox, 0, 3);

			gp.setPadding(new Insets(1,1,1,1));
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

