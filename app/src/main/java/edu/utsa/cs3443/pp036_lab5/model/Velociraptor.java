package edu.utsa.cs3443.pp036_lab5.model;

import android.app.Activity;

/**
 * The Velociraptor class represents a specific type of Theropod dinosaur.
 * @author Khoa Nguyen (ppy036)
 * CS3443
 */
public class Velociraptor extends Theropod {
	/**
     * Constructor to initialize the name and dietary preference of the Velociraptor.
     * @param name, the name of the Velociraptor (String)
     * @param isVegetarian, the Velociraptor diet's preference (boolean)
     */
	public Velociraptor(String name, boolean isVegetarian) {
		super(name, isVegetarian);
	}
	/**
	 * Constructor to initialize the name and dietary preference of the Velociraptor.
	 * @param name The name of the Velociraptor.
	 * @param activity The activity instance calling this method.
	 */
	public Velociraptor(String name, Activity activity) {
		super(name, activity);
	}
	/**
     * Gets the subtype of the dinosaur.
     * @return the subtype of the dinosaur
     */
	@Override
	public String getSubType() {
		return "Velociraptor";
	}
}
