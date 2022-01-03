package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import recipeAndCategoryPackage.Category;
import recipeAndCategoryPackage.Ingredients;
import recipeAndCategoryPackage.Instructions;
import recipeAndCategoryPackage.Recipe;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		ArrayList<Category> allCats = new ArrayList<>();
		for (int i=0;i<=22;i++) {
			Category cat = new Category("Kategorie"+i);
			int ran1 = (int)(Math.random()*10);
			for (int j =0;j<=ran1;j++) {
				Recipe rec = new Recipe();
				int ran2 = (int)(Math.random()*10);
				for(int k=0;k<=ran2;k++) {
					rec.addIngredient(new Ingredients(i+j,"kg","Wasser"+(j*i)));
				}
				int ran3 = (int)(Math.random()*10);
				for(int l=0;l<=ran3;l++) {
					rec.addInstruction(new Instructions(l,"Lorem ipsum dolor sit amet, consectetur adipiscing elit,"
							+ " sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut "
							+ "enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut"
							+ " aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit"
							+ " in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur"
							+ " sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt"
							+ " mollit anim id est laborum."));
				}
				cat.addRec(rec);
			}
			allCats.add(cat);
		}
		ArrayList<Category> allCats1 = new ArrayList<>();
		try {
			FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeInt(allCats.size());
			// Write objects to file
			for (Category cat : allCats) {
			o.writeObject(cat);
			}
			o.close();
			f.close();

			FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
			ObjectInputStream oi = new ObjectInputStream(fi);

			// Read objects
			int size = oi.readInt();
			while(size>0) {
				allCats1.add((Category)oi.readObject());
				size--;
			}


			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
			buttonWrite.setOnAction(event -> {
				Stage cbw = new CookBookWriter();
				primaryStage.hide();
			});
			buttonShow.setMinWidth(220);
			buttonShow.setFont(new Font("Arial", 20));
			buttonShow.setTextAlignment(TextAlignment.CENTER);
			buttonShow.setOnAction(event -> {
				Stage cb = new CookBook(allCats1);
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
