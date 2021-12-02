package application;

import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class Rezept {
	private String name;
	private ListView<Zutaten> zutList;
	private ListView<Beschreibung> beschList;
	private ImageView imView;
	public Rezept() {
		this("....");
	}
	public Rezept(String name) {
		this.name = name;
		zutList = new ListView<Zutaten>();
		zutList.getItems().add(new Zutaten(0, "ml", "Wasser"));
		beschList = new ListView<Beschreibung>();
		beschList.getItems().add(new Beschreibung(1,"Wasser in Kanne kippen"));
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
