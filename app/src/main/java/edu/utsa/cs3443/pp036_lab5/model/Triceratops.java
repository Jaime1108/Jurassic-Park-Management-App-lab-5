package edu.utsa.cs3443.pp036_lab5.model;

import android.app.Activity;

public class Triceratops extends Chasmosaurine {
    /**
     * Constructor to initialize the name and dietary preference of the Triceratops.
     * @param name, the name of the Triceratops (String)
     * @param isVegetarian, the Triceratops diet's preference (boolean)
     */
    public Triceratops(String name, boolean isVegetarian){
        super(name, isVegetarian);
    }
    /**
     * Constructor to initialize the name and dietary preference of the Triceratops.
     * @param name The name of the Triceratops.
     * @param activity The activity instance calling this method.
     */
    public Triceratops(String name, Activity activity){
        super(name, activity);
    }
    /**
     * Gets the subtype of the dinosaur.
     * @return the subtype of the dinosaur
     */
    @Override
    public String getSubType() {
        return "Triceratops";
    }
}
