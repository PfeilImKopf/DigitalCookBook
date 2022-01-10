package recipeAndCategoryPackage;


import java.io.Serializable;

import java.util.ArrayList;


public class Recipe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String time;
	private String type;
	private int people;
	private String measure;
	private String difficulty;

	private ArrayList<Ingredients> ingList;
	private ArrayList<Instructions> instList;
	private String image;

	public Recipe() {
		this("....","---","---",0,"---","---",null,null,"");
	}
	public Recipe(String name,String time,String type,
			int people,String measure,String difficulty,
			ArrayList<Ingredients> ingList,
			ArrayList<Instructions> instList,String image) {
		this.name = name;
		this.ingList = new ArrayList<Ingredients>();
		this.instList = new ArrayList<Instructions>();
		this.image="tee.png";
		this.time=time;
		this.difficulty=difficulty;
		this.people=people;
		this.measure=measure;
		this.type=type;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getName() {
		return this.name;
	}
	@Override
	public String toString() {
		return name;
	}
	public ArrayList<Ingredients> getIngList() {
		return ingList;
	}
	public ArrayList<Instructions> getInstList() {
		return instList;
	}
	public String getTime() {
		return time;
	}
	public void addIngredient(Ingredients ing) {
		ingList.add(ing);
	}
	public void addInstruction(Instructions inst) {
		instList.add(inst);
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public String getMeasure() {
		return measure;
	}
	public void setMeasure(String measure) {
		this.measure = measure;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setIngList(ArrayList<Ingredients> ingList) {
		this.ingList = ingList;
	}
	public void setInstList(ArrayList<Instructions> instList) {
		this.instList = instList;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}
