package application;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rezept {
	private String name;
	private ListView<Zutaten> zutList;
	private ListView<Beschreibung> beschList;
	private Image image;
	private ImageView imView;
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
	
}
