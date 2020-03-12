package DataLab;

import java.util.ArrayList;

/**
 * Cereal Class
 */

public class Cereal {
	
	// Attributes
	private String name;
	private int carbs;
	private int protein;
	
	// Constructor
	public Cereal (String nameIn, int carbsIn, int proteinIn) {
		name = nameIn;
		carbs = carbsIn;
		protein = proteinIn;
	}

	//accessors
	public String getName() {
		return name;
	}

	public int getCarbs() {
		return carbs;
	}

	public int getProtein() {
		return protein;
	}

	//modifiers
	public void setName(String name) {
		this.name = name;
	}

	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}

	public void setProtein(int protein) {
		this.protein = protein;
	}
	
	public int LowCarbHighProteinRating () {
		return this.carbs - this.protein;
	}
	
	public String toString() {
		return "Name:: " + name + "\n" + "Carbohydrates:: " + carbs + "\n" + "Protein:: " + protein + "\n----------------";
	}
	
	//Main Method
	public static void main(String[] args) {
		Cereal bran100Percent = new Cereal ("100% Bran", 5, 4);
		Cereal appleJacks = new Cereal ("Apple Jacks", 11, 2);
		Cereal cheerios = new Cereal ("Cheerios", 17, 6);
		Cereal cinnamonToastCrunch = new Cereal ("Cinnamon Toast Crunch", 13, 1);
		Cereal cornFlakes = new Cereal ("Corn Flakes", 21, 2);
		
		System.out.println(bran100Percent);
		System.out.println(appleJacks);
		System.out.println(cheerios);
		System.out.println(cinnamonToastCrunch);
		System.out.println(cornFlakes);
		
		ArrayList<Cereal> cereals = new ArrayList<Cereal>();
		cereals.add(bran100Percent);
		cereals.add(appleJacks);
		cereals.add(cheerios);
		cereals.add(cinnamonToastCrunch);
		cereals.add(cornFlakes);
		
		Cereal lchp = cereals.get(0);
		for (Cereal cereal : cereals) {
			if (cereal.LowCarbHighProteinRating() < lchp.LowCarbHighProteinRating())
				lchp = cereal;
		}
		
		System.out.println("The best Cereal for a low carb high protein diet is:: " + lchp.getName());

	}
}