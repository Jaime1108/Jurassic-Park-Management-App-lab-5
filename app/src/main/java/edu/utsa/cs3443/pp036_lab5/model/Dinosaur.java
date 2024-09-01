package edu.utsa.cs3443.pp036_lab5.model;

/**
* The Dinosaur interface represents individual dinosaurs in the park.
* @author Khoa Nguyen (ppy036) 
* CS3443
*/
public interface Dinosaur {
	/**
     * Checks if the dinosaur is vegetarian.
     * @return true if the dinosaur is not carnivore, false otherwise
     */
	public boolean isVegetarian();
	/**
     * Gets the name of the dinosaur.
     * @return name, the name of the dinosaur (String)
     */
	public String getName();
	/**
     * Gets the type of the dinosaur.
     * @return String, the type of the dinosaur 
     */
	public String getType();
	
	/**
    * Gets a string representation of the dinosaur.
    * @return a string representation of the dinosaur
    */
	public String toString();
	/**
	 * Gets a string diet preference representation of the dinosaur.
	 * @return a string diet preference representation of the dinosaur
	 */
	public String getDietPreference();
	/**
	 * Gets the Subtype of the dinosaur.
	 * @return String, the SubType of the dinosaur
	 */
	public abstract String getSubType();

}
