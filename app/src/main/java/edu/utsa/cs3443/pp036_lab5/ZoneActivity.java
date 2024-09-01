package edu.utsa.cs3443.pp036_lab5;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.pp036_lab5.model.Dinosaur;
import edu.utsa.cs3443.pp036_lab5.model.Park;
import edu.utsa.cs3443.pp036_lab5.model.Zone;
/**
 * ZoneActivity class to display the zone and the dinosaurs within it.
 * @author Khoa Nguyen (ppy036)
 * CS3443
 */
public class ZoneActivity extends AppCompatActivity {
    private Park park;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_zone);

        // Initialize views
        TextView zoneView = findViewById(R.id.Zone);
        TextView guestNumber = findViewById(R.id.guestNum);
        TextView dinoNumber = findViewById(R.id.dinoNum);
        LinearLayout DinoContainer = findViewById(R.id.DinoContainer);

        // Retrieve data from the Intent
        String zoneAbbreviation = getIntent().getStringExtra("ZoneAbbreviation");
        park = (Park) getIntent().getSerializableExtra("park");

        // Get zone from abbreviation
        Zone zone = park.getZoneFromAbbreviation(zoneAbbreviation);

        // Set zone information
        zoneView.setText("Zone " + zoneAbbreviation);
        guestNumber.setText("# of guests: " + zone.getGuestNum());
        dinoNumber.setText("# of dinosaurs: " + zone.getNumberOfDino());

        // get the dinosaur information and display it
        for (Dinosaur dinosaurs : zone.getDinosaurs()) {

            View crewMemberView = LayoutInflater.from(this).inflate(R.layout.dino_layout, DinoContainer, false);
            ImageView dinoImage  = crewMemberView.findViewById(R.id.dinoPhoto);
            TextView dinoName = crewMemberView.findViewById(R.id.dinoName);
            TextView TypeDiet = crewMemberView.findViewById(R.id.Type_and_diet);

            // Get the image resource based on the dinosaur's name
            String image ="@drawable/" + dinosaurs.getName().toLowerCase();
            int imageResource = getResources().getIdentifier(image, null, getPackageName());
            // If the image resource is not found, use the default image
            if( imageResource == 0){     // If not the image, use the default image
                image ="@drawable/default_image";
                imageResource = getResources().getIdentifier(image, null, getPackageName());
            }

            Drawable res = getResources().getDrawable(imageResource);
            dinoImage.setImageDrawable(res); //set image
            // Set the dinosaur's name and type with diet preference
            dinoName.setText(dinosaurs.getName());
            TypeDiet.setText(dinosaurs.getSubType() + ", " + dinosaurs.getDietPreference());
            DinoContainer.addView(crewMemberView); // Add the dinosaur view to the container
        }
        // Set up the relocation button
        Button relocation = findViewById(R.id.relocate);
        relocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start ZoneActivity
                Intent intent = new Intent(ZoneActivity.this, TransferingActivity.class);
                intent.putExtra("ZoneAbbreviation", zone.getZoneAbbreviation());
                intent.putExtra("park", park);
                startActivity(intent);
            }
        });

    }
}

