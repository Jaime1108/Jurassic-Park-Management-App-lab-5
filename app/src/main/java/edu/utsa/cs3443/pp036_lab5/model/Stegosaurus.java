package edu.utsa.cs3443.pp036_lab5.model;

import android.app.Activity;

/**
 * The Stegosaurus class represents a specific type of Stegosaur dinosaur.
 * Author: Khoa Nguyen (ppy036)
 * CS3443
 */
public class Stegosaurus extends Stegosaur {

	/**
	 * Constructor to initialize the name and dietary preference of the Stegosaurus.
	 * @param name, the name of the Stegosaurus (String)
	 * @param isVegetarian, the Stegosaurus diet's preference (boolean)
	 */
	public Stegosaurus(String name, boolean isVegetarian) {
		super(name, isVegetarian);
	}
	/**
	 * Constructor to initialize the name and dietary preference of the Stegosaurus.
	 * @param name The name of the Stegosaurus.
	 * @param activity The activity instance calling this method.
	 */
	public Stegosaurus(String name, Activity activity) {
		super(name, activity);
	}

	/**
	 * Gets the subtype of the dinosaur.
	 * @return the subtype of the dinosaur
	 */
	@Override
	public String getSubType() {
		return "Stegosaurus";
	}
}