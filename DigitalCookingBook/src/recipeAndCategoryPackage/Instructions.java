package recipeAndCategoryPackage;

import java.io.Serializable;

public class Instructions implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public Instructions(int schrittNum,String text) {
		this.schrittNum=schrittNum;
		this.text=text;
	}
	@Override
	public String toString() {
		return schrittNum+". "+text;
	}
}
