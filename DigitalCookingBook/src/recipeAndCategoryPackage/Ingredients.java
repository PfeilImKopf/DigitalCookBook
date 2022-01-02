package recipeAndCategoryPackage;

import java.io.Serializable;

public class Ingredients implements Serializable {
	private double menge;
	private String einheit;
	private String name;
	public Ingredients() {
		this(0.0,"","");
	}
	public Ingredients(double menge, String einheit, String name) {
		this.menge=menge;
		this.einheit=einheit;
		this.name=name;
	}
	public double getMenge() {
		return menge;
	}
	public void setMenge(double menge) {
		this.menge = menge;
	}
	public String getEinheit() {
		return einheit;
	}
	public void setEinheit(String einheit) {
		this.einheit = einheit;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return menge+" "+einheit+" "+name;
	}
}
