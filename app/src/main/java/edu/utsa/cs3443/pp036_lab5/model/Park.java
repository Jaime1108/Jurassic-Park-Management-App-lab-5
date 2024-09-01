package edu.utsa.cs3443.pp036_lab5.model;
import android.app.Activity;
import android.content.res.AssetManager;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
* The Park class represents a park holding zones and dinosaur.
* @author Khoa Nguyen (ppy036)
* CS3443
*/
public class Park implements Serializable {

	private String name; // name of the park
	private ArrayList<Zone> zones;
	/**
	 * Constructor to initialize the park's name and maximum capacity.
	 * @param name, the name of the park (String)
	 */
	public Park(String name) {
		this.name = name; //initialize park's name
		this.zones = new ArrayList<Zone>(); //create new array of dinosaur
	}

	/**
	 * Sets the name of the park.
	 * @param name, the new name of the park (String)
	 */
	public void setName(String name) {
		this.name = name;}
	/**
	 * Returns the park's name.
	 * @return string, park's name
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Returns the park's zones.
	 * @return zones, The arrayList of zones in the park
	 */
	public ArrayList<Zone> getZones() {
		return zones;
	}
	/**
	 * Sets the zone of the park.
	 * @param zones, The arrayList of zones in the par (ArrayList<Zone>)
	 */
	public void setZones(ArrayList<Zone> zones) {
		this.zones = zones;
	}

	@Override
	public String toString() {
		return "Park{" +
				"name='" + name + '\'' +
				", zones=" + zones +
				'}';
	}
	/**
	 * Adds a zone into the park.
	 *
	 * @param zone, the zone to be added to the park (Zone)
	 */
	public void addzone(Zone zone){
		this.zones.add(zone);
	}
	/**
	 * get the zone using the zoneAbbreviation.
	 *
	 * @param zoneAbbreviation, the Abbreviation of zone (String)
	 * @return zones, the correct zone that match the abbreviation (Zone)
	 */
	public Zone getZoneFromAbbreviation(String zoneAbbreviation) {
		for (Zone zones : this.zones){
			if(zones.getZoneAbbreviation().equals(zoneAbbreviation)){
				return zones;
			}
		}
		return null;
	}
	/**
	 * Loads zones to the park from the CSV file.
	 * Each each line in the file contain zone full name,risk level,zone abbreviation,number of guests
	 *
	 * @param activity the activity instance calling this method
	 */
	public void loadZones(Activity activity){
		AssetManager manager = activity.getAssets();
		String fileName = "zones.csv";

		try {
			// Open the CSV file from assets
			InputStream file = manager.open(fileName);
			Scanner scan = new Scanner(file);
			// Iterate through each line of the CSV file

			while (scan.hasNextLine()) {
				String[] zoneInfo = scan.nextLine().split(",");
				for (int i = 0; i < zoneInfo.length; i++) {
					zoneInfo[i] = zoneInfo[i].trim();
				}
				// Extract zone information from the array
				String fullName = zoneInfo[0];
				String riskLevel = zoneInfo[1];
				String zoneAbbreviation = zoneInfo[2];
				int guestNum = Integer.parseInt(zoneInfo[3]);

				// Create a new Zone object with the extracted information
				Zone zone = new Zone(fullName, riskLevel, zoneAbbreviation, guestNum);
				zone.loadDino(activity); // Load dinosaurs for this zone
				this.addzone(zone); // Add the zone to the park
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
	 * Moves a dinosaur from one zone to another. This method removes the dinosaur from the current zone's list and
	 * adds it to the moving zone's list.
	 * @param dino The Dinosaur object to be moved.
	 * @param currentZone The current Zone of the dinosaur.
	 * @param movingZone The Zone that dinosaur is moving into
	 */
	public void movingDino(Dinosaur dino, Zone currentZone, Zone movingZone) {
		Dinosaur dummy = dino;     // Temporarily hold the Dinosaur object
		currentZone.getDinosaurs().remove(dino);
		movingZone.getDinosaurs().add(dummy);
		dummy = null;
	}
}
