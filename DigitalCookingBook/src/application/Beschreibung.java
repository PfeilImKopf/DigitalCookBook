package application;

public class Beschreibung {
	private final int schrittNum;
	private String text;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getSchrittNum() {
		return schrittNum;
	}
	public Beschreibung(int schrittNum,String text) {
		this.schrittNum=schrittNum;
		this.text=text;
	}
	@Override
	public String toString() {
		return schrittNum+". "+text;
	}
}
