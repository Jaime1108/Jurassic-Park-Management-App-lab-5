package edu.utsa.cs3443.pp036_lab5.model;

import android.app.Activity; /**
 * The Tyrannosaurus class represents a specific type of Theropod dinosaur.
 * @author Khoa Nguyen (ppy036)
 * CS3443
 */
public class Tyrannosaurus extends Theropod {
	/**
     * Constructor to initialize the name and dietary preference of the Tyrannosaurus.
     * @param name, the name of the Tyrannosaurus (String)
     * @param isVegetarian, the Tyrannosaurus diet's preference (boolean)
     */
	public Tyrannosaurus(String name, boolean isVegetarian){
		super(name, isVegetarian);
	}
	/**
	 * Constructor to initialize the name and dietary preference of the Tyrannosaurus.
	 * @param name The name of the Tyrannosaurus.
	 * @param activity The activity instance calling this method.
	 */
	public Tyrannosaurus(String name, Activity activity){
		super(name, activity);
	}
	/**
     * Gets the subtype of the dinosaur.
     * @return the subtype of the dinosaur
     */
	@Override
	public String getSubType() {
		return "Tyrannosaurus";
	}
}
