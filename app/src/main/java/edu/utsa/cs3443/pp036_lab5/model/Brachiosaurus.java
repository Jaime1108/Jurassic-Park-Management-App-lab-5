package edu.utsa.cs3443.pp036_lab5.model;

import android.app.Activity;

/**
 * The Brachiosaurus class represents a specific type of Sauropod dinosaur.
 * @author Khoa Nguyen (ppy036)
 * CS3443
 */
public class Brachiosaurus extends Sauropod {
	/**
     * Constructor to initialize the name and dietary preference of the Brachiosaurus.
     * @param name, the name of the Brachiosaurus (String)
     * @param isVegetarian, the Brachiosaurus diet's preference (boolean)
     */
	public Brachiosaurus(String name,boolean isVegetarian) {
		super(name, isVegetarian);
	}
	/**
	 * Constructor to initialize the name and dietary preference of the Brachiosaurus.
	 *
	 * @param name The name of the Brachiosaurus.
	 * @param activity The activity instance calling this method.
	 */
	public Brachiosaurus(String name, Activity activity) {
		super(name, activity);
	}
	/**
     * Gets the subtype of the dinosaur.
     * @return the subtype of the dinosaur
     */
	@Override
	public String getSubType() {
		return "Brachiosaurus";
	}

}
