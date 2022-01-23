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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import recipeAndCategoryPackage.Category;
import recipeAndCategoryPackage.Ingredients;
import recipeAndCategoryPackage.Instructions;
import recipeAndCategoryPackage.Recipe;

public class CookBookWriter extends Stage {
	public CookBookWriter(ArrayList<Category> allCats) {
		try {
			
			ArrayList<String> im = new ArrayList<String>();
			ArrayList<TextArea> taList = new ArrayList<TextArea>();
			ArrayList<TextArea> naList = new ArrayList<TextArea>();
			
			ArrayList<TextArea> iaList = new ArrayList<TextArea>();
			ArrayList<TextArea> niaList = new ArrayList<TextArea>();
			ArrayList<TextArea>	unitList = new ArrayList<TextArea>();
			
			BorderPane root = new BorderPane();
			GridPane gp = new GridPane();
			GridPane taPane = new GridPane();
			GridPane iaPane = new GridPane();
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
			Button pic = new Button("Bild hochladen");
			
			TextArea na = new TextArea("1");
			na.setMaxHeight(20);
			na.setMaxWidth(20);
			na.setEditable(false);
			TextArea ta = new TextArea();
			
			
			TextArea nia = new TextArea();
			nia.setMaxHeight(20);
			nia.setMaxWidth(20);
			TextArea ia = new TextArea();
			TextArea unit = new TextArea();
			unit.setMaxHeight(20);
			unit.setMaxWidth(20);

			
			TextField headField = new TextField();
			ComboBox<String> cateField = new ComboBox<String>(FXCollections.observableArrayList(al));
			cateField.setEditable(true);
			cateField.setTooltip(new Tooltip("Waehle eine Kategorie aus oder erstelle eine neue."));
			TextField duraField = new TextField();
			TextField persField = new TextField();
			TextField diffField = new TextField();
			TextField typeField = new TextField();
			TextField measField = new TextField();
			
			
			
			taPane.add(na, 0, 0);
			taPane.add(ta, 1, 0);
			
			iaPane.add(nia, 1, 0);
			iaPane.add(ia, 0, 0);
			iaPane.add(unit, 2, 0);
			
			fld.getChildren().add(headField);
			fld.getChildren().add(cateField);
			fld.getChildren().add(duraField);
			fld.getChildren().add(persField);
			fld.getChildren().add(diffField);
			fld.getChildren().add(typeField);
			fld.getChildren().add(measField);
			fld.getChildren().add(taPane);
			fld.getChildren().add(iaPane);
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
			buttonBox.getChildren().add(pic);
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
			
			iaList.add(ia);
			niaList.add(nia);
			unitList.add(unit);
			ia.setOnKeyTyped(e -> {
				String s = ia.getText();
				if (s.length() == 1) {
					
					iaList.add(0, new TextArea());
					niaList.add(new TextArea());
					unitList.add(new TextArea());

					unitList.get(unitList.size()-1).setMaxHeight(20);
					unitList.get(unitList.size()-1).setMaxWidth(20);

					niaList.get(niaList.size()-1).setMaxHeight(20);
					niaList.get(niaList.size()-1).setMaxWidth(20);
					
					for (int i = 0; i < iaList.size()-1; i++) {
						iaList.get(i).setText(iaList.get(i+1).getText());
						iaList.get(i+1).setText("");
					}
					iaPane.getChildren().clear();
					for (int i = 0; i < iaList.size(); i++) {
						iaPane.add(niaList.get(i), 1, i);
						iaPane.add(iaList.get(i), 0, i);
						iaPane.add(unitList.get(i), 2, i);
					}
					
					iaList.get(iaList.size()-2).requestFocus();
					iaList.get(iaList.size()-2).selectEnd();
					iaList.get(iaList.size()-2).deselect();
				}
			});
			 
			save.setOnAction(e -> {
				try {
					boolean checkRec = true;
					
					String name = new String(headField.getText());
					Category c = new Category(cateField.getValue());
					String time = new String(duraField.getText());
					String type = new String(typeField.getText());
					int people = Integer.parseInt(persField.getText());
					String measure = new String(measField.getText());
					String difficulty = new String(diffField.getText());
					ArrayList<Ingredients> ingList = new ArrayList<Ingredients>();
					ArrayList<Instructions> instList = new ArrayList<Instructions>();
					String image = new String(im.get(0));
					
					for (int i = 0; i < taList.size()-1;i++) {
//						if (taList.get(i).getText().trim() != "") {
							instList.add(new Instructions(Integer.parseInt(naList.get(i).getText()), taList.get(i).getText()));
//						}
					}
					for (int i = 0; i < iaList.size()-1;i++) {
//						if ((iaList.get(i).getText().trim() != "") && (naList.get(i).getText().trim() != "") && (unitList.get(i).getText().trim() != "")){
							ingList.add(new Ingredients(Double.parseDouble(niaList.get(i).getText()), unitList.get(i).getText(), iaList.get(i).getText()));
//						}
					}
//					if (checkRec) {
						Recipe r = new Recipe(name, time, type, people, measure, difficulty, ingList, instList, image);
//					}
					
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
					ex.printStackTrace(System.out);
				}
			});
			
			gotoList.setOnAction(e -> {
				try {
					new CookBook(allCats);
				} catch (Exception e2) {
					System.out.println(e2);
				}
			});
			pic.setOnAction(e -> {
				FileChooser fc = new FileChooser();
				fc.setTitle("Bild hochladen");
				fc.getExtensionFilters().addAll(
					new FileChooser.ExtensionFilter("All Images", "*.jpg", "*.png"),
					new FileChooser.ExtensionFilter("JPG", "*.jpg"),
					new FileChooser.ExtensionFilter("PNG", "*.png")					
				);
				File picture = fc.showOpenDialog(getOwner());
				if (picture != null) {
					im.clear();
					im.add(picture.getAbsolutePath());
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

