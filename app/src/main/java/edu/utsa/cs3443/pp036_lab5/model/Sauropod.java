package edu.utsa.cs3443.pp036_lab5.model;

import android.app.Activity;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * The abstract Sauropod class represents Sauropod type of dinosaurs.
 * Author: Khoa Nguyen (ppy036)
 * CS3443
 */
public abstract class Sauropod implements Dinosaur, Serializable {
	private String name; // Store the name of the Sauropod
	private boolean isVegetarian; // Determine if the dinosaur is a predator

	/**
	 * Constructor to initialize the name and dietary preference of the Sauropod.
	 * @param name, the name of the Sauropod (String)
	 * @param isVegetarian, the Sauropod diet's preference (boolean)
	 */
	public Sauropod(String name, boolean isVegetarian) {
		this.name = name;
		this.isVegetarian = isVegetarian;
	}

	/**
	 * Constructor to initialize the name of the Sauropod and set its dietary preference based on data from a CSV file.
	 * @param name, the name of the Sauropod (String)
	 * @param activity, the activity instance calling this method
	 */
	public Sauropod(String name, Activity activity) {
		AssetManager manager = activity.getAssets();
		String fileName = "types.csv";

		try {
			// Open the CSV file from assets
			InputStream file = manager.open(fileName);
			Scanner scan = new Scanner(file);
			// Iterate through each line of the CSV file
			while (scan.hasNextLine()) {
				String[] dinoInfo = scan.nextLine().split(",");
				for (int i = 0; i < dinoInfo.length; i++) {
					dinoInfo[i] = dinoInfo[i].trim();
				}
				// Extract the type and dietary preference from the array
				String type = dinoInfo[0];
				boolean isVegetarian = Boolean.parseBoolean(dinoInfo[1]);
				if(type.equals(this.getType())){
					// Set the name and dietary preference for this Chasmosaurine
					this.name = name;
					this.isVegetarian = isVegetarian;
				}
			}
			scan.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
			// Handle error accessing assets
			Toast.makeText(activity, "Error accessing assets: " + e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}

	/**
	 * Checks if the Sauropod is vegetarian.
	 * @return true if the Sauropod is not carnivore, false otherwise
	 */
	@Override
	public boolean isVegetarian() {
		return isVegetarian;
	}

	/**
	 * Gets the name of the Sauropod.
	 * @return string, the name of the Sauropod
	 */
	@Override
	public String getName() {
		return name;
	}
	/**
	 * Sets the name of the dinosaur.
	 * @param name, the name of the Dinosaur(String)
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * sets the diet preference of the Dinosaur.
	 * @return boolean, the diet preference of the Dinosaur
	 */
	public void setVegetarian(boolean vegetarian) {
		isVegetarian = vegetarian;
	}
	/**
	 * Gets the type of the Sauropod, which includes its subtype.
	 * @return the type of the Sauropod
	 */
	@Override
	public String getType() {
		return "Sauropod";
	}

	/**
	 * Returns a string representation of the Sauropod.
	 * @return a string representation of the Sauropod
	 */
	@Override
	public String toString() {
		if (isVegetarian()) {
			return getType() + " named " + getName() + " (not carnivore)";
		} else {
			return getType() + " " + getSubType() + " named " + getName() + " (carnivore)";
		}
	}
	/**
	 * return a diet preference of the Sauropod
	 * @return a string diet preference of the Sauropod
	 */
	@Override
	public String getDietPreference(){
		if(!isVegetarian){
			return "carnivore";
		}
		else{
			return "not carnivore";
		}
	}
	/**
	 * Abstract method for subclasses to find the subtype of the Sauropod.
	 * @return String, the subtype of the Sauropod
	 */
	public abstract String getSubType();
}
