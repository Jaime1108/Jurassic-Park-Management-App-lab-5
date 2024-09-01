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
 * The zone class represents a zone holding dinosaur.
 * @author Khoa Nguyen (ppy036)
 * CS3443
 */
public class Zone implements Serializable {
    private String fullName; // Full name of the zone
    private String riskLevel; // Risk level associated with the zone
    private String zoneAbbreviation; // Abbreviation of the zone
    private ArrayList<Dinosaur> dinosaurs; // List of dinosaurs in the zone
    private int guestNum; // Number of guests in the zone

    /**
     * Constructor to initialize a Zone with given details.
     *
     * @param fullName, The full name of the zone (String).
     * @param riskLevel, The risk level of the zone (String).
     * @param zoneAbbreviation, The abbreviation of the zone (String).
     * @param guestNum, The number of guests in the zone (int).
     */
    public Zone(String fullName, String riskLevel, String zoneAbbreviation, int guestNum) {
        this.fullName = fullName;
        this.riskLevel = riskLevel;
        this.zoneAbbreviation = zoneAbbreviation;
        this.dinosaurs = new ArrayList<>();
        this.guestNum = guestNum;
    }
    /**
     * Gets the number of dinosaurs in the zone.
     * @return The number of dinosaurs.
     */
    public int getNumberOfDino(){
        return this.dinosaurs.size();
    }
    /**
     * Gets the full name of the zone.
     * @return fullName, The full name of the zone.
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Gets the risk level of the zone.
     * @return riskLevel, The risk level of the zone.
     */
    public String getRiskLevel() {
        return riskLevel;
    }
    /**
     * Gets the abbreviation of the zone.
     * @return zoneAbbreviation, The abbreviation of the zone.
     */
    public String getZoneAbbreviation() {
        return zoneAbbreviation;
    }
    /**
     * Gets the list of dinosaurs in the zone.
     * @return dinosaurs, The Arraylist of dinosaurs.
     */
    public ArrayList<Dinosaur> getDinosaurs() {
        return dinosaurs;
    }
    /**
     * Gets the number of guests in the zone.
     * @return guestNum, The number of guests.
     */
    public int getGuestNum() {
        return guestNum;
    }
    /**
     * Sets the full name of the zone.
     * @param fullName, The full name of the zone (String).
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    /**
     * Sets the risk level of the zone.
     * @param riskLevel, The risk level of the zone (String).
     */
    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }
    /**
     * Sets the abbreviation of the zone.
     * @param zoneAbbreviation, The abbreviation of the zone (String).
     */
    public void setZoneAbbreviation(String zoneAbbreviation) {
        this.zoneAbbreviation = zoneAbbreviation;
    }

    /**
     * Sets the list of dinosaurs in the zone.
     * @param dinosaurs, The list of dinosaurs (ArrayList<Dinosaur>).
     */
    public void setDinosaurs(ArrayList<Dinosaur> dinosaurs) {
        this.dinosaurs = dinosaurs;
    }
    /**
     * Sets the number of guests in the zone.
     * @param guestNum, The number of guests (int).
     */
    public void setGuestNum(int guestNum) {
        this.guestNum = guestNum;
    }

    /**
     * Adds the given dinosaur to the park if there is capacity.
     * @param dinosaur,  (Dinosaur)
     */
    public void addDino(Dinosaur dinosaur) {
        this.dinosaurs.add(dinosaur);
    }
    /**
     * Retrieves a dinosaur by its name from the zone's list of dinosaurs.
     * @param name The name of the dinosaur to retrieve.
     * @return The Dinosaur object if found, or null if not found.
     */
    public Dinosaur getDino(String name){
        for(Dinosaur dinosaur: this.dinosaurs){
            if(dinosaur.getName().equals(name)){
                return dinosaur;
            }
        }
        return null;
    }

    /**
     * Loads zone related dinosaurs into the zone from a CSV file.
     * Each line in the file should contain the dinosaur's name, type, and zone abbreviation.
     *
     * @param activity the activity instance calling this method
     */
    public void loadDino(Activity activity){
        // Access the asset manager to read the CSV file
        AssetManager manager = activity.getAssets();
        String fileName = "dinos.csv";

        try {
            // Open the CSV file from the assets folder
            InputStream file = manager.open(fileName);
            Scanner scan = new Scanner(file);
            // Iterate through each line of the CSV file
            while (scan.hasNextLine()) {
                String[] dinosaurInfo = scan.nextLine().split(",");
                for (int i = 0; i < dinosaurInfo.length; i++) {
                    dinosaurInfo[i] = dinosaurInfo[i].trim();
                }
                // get dinosaur information from the fields
                String name = dinosaurInfo[0];
                String type = dinosaurInfo[1];
                String zone = dinosaurInfo[2];
                // Check if the dinosaur belongs to the current zone
                if(zone.equals(this.zoneAbbreviation)){
                    // Create a new Dinosaur object based on the name and type
                    Dinosaur dinosaur = newDinosaur(name, type, activity);
                    this.addDino(dinosaur);  // Add the Dinosaur object to the zone
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
     * Creates a new Dinosaur object based on the type specified.
     * @param name The name of the dinosaur.
     * @param type The type of the dinosaur.
     * @param activity the activity instance calling this method
     * @return A new Dinosaur object of the specified type
     */
    public Dinosaur newDinosaur(String name, String type, Activity activity) {
        switch (type) {
            case "Apatosaurus":
                return new Apatosaurus(name, activity);
            case "Brachiosaurus":
                return new Brachiosaurus(name, activity);
            case "Dilophosaurus":
                return new Dilophosaurus(name, activity);
            case "Gallimimus":
                return new Gallimimus(name, activity);
            case "Indominous Rex":
                return new Indominous(name, activity);
            case "Stegosaurus":
                return new Stegosaurus(name, activity);
            case "Triceratops":
                return new Triceratops(name, activity);
            case "Tyrannosaurus":
                return new Tyrannosaurus(name, activity);
            case "Velociraptor":
                return new Velociraptor(name, activity);
            default:
                return null;
        }
    }
}

