package edu.utsa.cs3443.pp036_lab5.model;

import android.app.Activity;

/**
 * The Apatosaurus class represents a specific type of Sauropod dinosaur.
 * @author Khoa Nguyen (ppy036)
 * CS3443
 */
public class Apatosaurus extends Sauropod {
	/**
     * Constructor to initialize the name and dietary preference of the Apatosaurus.
     * @param name, the name of the Apatosaurus (String)
     * @param isVegetarian, the Apatosaurus diet's preference (boolean)
     */
	public Apatosaurus(String name, boolean isVegetarian) {
		super(name, isVegetarian);
	}
	/**
	 * Constructor to initialize the name and dietary preference of the Apatosaurus.
	 *
	 * @param name The name of the Apatosaurus.
	 * @param activity The activity instance calling this method.
	 */
	public Apatosaurus(String name, Activity activity) {
		super(name, activity);
	}
	/**
     * Gets the subtype of the dinosaur.
     * @return the subtype of the dinosaur
     */
	@Override
	public String getSubType() {
		return "Apatosaurus";
	}
}
