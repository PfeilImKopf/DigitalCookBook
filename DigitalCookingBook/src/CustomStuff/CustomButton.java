package CustomStuff;

import javafx.scene.control.Button;

public class CustomButton extends Button{
	public CustomButton() {
		this("");
	}
	public CustomButton(String str) {
		super(str);
		setStyle("-fx-effect: dropshadow(one-pass-box, blue, 10, 0.5, 2, 0.0);"
				+ "-fx-font: bold italic 10pt Arial;"
				+ "-fx-background-radius: 20");
	}
}
