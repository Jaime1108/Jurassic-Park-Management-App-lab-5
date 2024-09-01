package edu.utsa.cs3443.pp036_lab5.model;

import android.app.Activity;

public class Dilophosaurus extends Theropod {
    /**
     * Constructor to initialize the name and dietary preference of the Dilophosaurus.
     * @param name, the name of the Velociraptor (String)
     * @param isVegetarian, the Velociraptor diet's preference (boolean)
     */
    public Dilophosaurus(String name, boolean isVegetarian) {
        super(name, isVegetarian);
    }
    /**
     * Constructor to initialize the name and dietary preference of the Dilophosaurus.
     *
     * @param name The name of the Dilophosaurus.
     * @param activity The activity instance calling this method.
     */
    public Dilophosaurus(String name, Activity activity) {
        super(name, activity);
    }
    /**
     * Gets the subtype of the dinosaur.
     * @return the subtype of the dinosaur
     */
    @Override
    public String getSubType() {
        return "Dilophosaurus";
    }

}