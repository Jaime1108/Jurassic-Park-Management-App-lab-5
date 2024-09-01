package edu.utsa.cs3443.pp036_lab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.pp036_lab5.model.Park;
import edu.utsa.cs3443.pp036_lab5.model.Zone;
/**
 * MainActivity class to display the map.
 * @author Khoa Nguyen (ppy036)
 * CS3443
 */
public class MainActivity extends AppCompatActivity {
    private Park park;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // Retrieve the Park object from Intent
        park = (Park) getIntent().getSerializableExtra("park");
        if(park == null) {
            String parkname = "Jurassic Park"; //create a new park if the app is launching for the first time
            park = new Park(parkname);
            try {  // Load Zone from the CSV file into the fleet
                park.loadZones(this);
            } catch (Exception e) {
                // Display a Toast message indicating an error loading zone
                Toast.makeText(this, "Error loading zone: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        // Iterate over zones and set up buttons
        for (Zone zone : park.getZones()) {
            // Find the button using the zone abbreviation as the ID
            int buttonId = getResources().getIdentifier(zone.getZoneAbbreviation(), "id", getPackageName());
            Button button = findViewById(buttonId);
                // Set up the button's onClickListener
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create an Intent to move to ZoneActivity
                    Intent intent = new Intent(MainActivity.this, ZoneActivity.class);
                    Toast.makeText(getApplicationContext(), "Clicked " + zone.getZoneAbbreviation(), Toast.LENGTH_LONG).show();
                    // Pass the Park object and ZoneAbbreviation to the ZoneActivity so it can reuse the same data
                    intent.putExtra("park", park);
                    intent.putExtra("ZoneAbbreviation", zone.getZoneAbbreviation());
                    startActivity(intent);
                }
            });

        }
    }
}