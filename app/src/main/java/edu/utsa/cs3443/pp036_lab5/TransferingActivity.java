package edu.utsa.cs3443.pp036_lab5;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.pp036_lab5.model.Dinosaur;
import edu.utsa.cs3443.pp036_lab5.model.Park;
import edu.utsa.cs3443.pp036_lab5.model.Zone;

/**
 * TransferingActivity class to display the relocation of dinosaur.
 * @author Khoa Nguyen (ppy036)
 * CS3443
 */
public class TransferingActivity extends AppCompatActivity {
    private Park park;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transfering);
        // Retrieve data from the Intent
        String zoneAbbreviation = getIntent().getStringExtra("ZoneAbbreviation");
        park = (Park) getIntent().getSerializableExtra("park");

        // Get the current zone from the abbreviation
        Zone currentZone = park.getZoneFromAbbreviation(zoneAbbreviation);
        TextView zoneView = findViewById(R.id.Zone);
        zoneView.setText("Zone " + zoneAbbreviation);

        // Set up the relocation button
        Button relocationButton = findViewById(R.id.relocateButton);
        relocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input fields for dinosaur name and new zone
                EditText inputDinoName = findViewById(R.id.dinosaurNameInput);
                EditText inputRelocateZone = findViewById(R.id.newZoneInput);
                String dinoTransferName = inputDinoName.getText().toString();
                String relocationZone = inputRelocateZone.getText().toString();
                // Find the dinosaur and the new zone
                Dinosaur dino = currentZone.getDino(dinoTransferName);
                Zone movingZone = park.getZoneFromAbbreviation(relocationZone);
                // Check if the dinosaur and zone exist
                if(dino == null){
                    Toast.makeText(getApplicationContext(), "Dinosaur  " + dinoTransferName + " does not exist! Try again!" , Toast.LENGTH_LONG).show();

                }else if(movingZone == null){
                    Toast.makeText(getApplicationContext(), "Zone " + relocationZone + " does not exist! Try again!" , Toast.LENGTH_LONG).show();
                }
                else{// Relocate the dinosaur
                    park.movingDino( dino, currentZone ,movingZone);
                    Toast.makeText(getApplicationContext(), "Relocated "+dinoTransferName +" to zone " + relocationZone , Toast.LENGTH_LONG).show();
                }
            }
        });
        // Set up the map view button
        Button mapView = findViewById(R.id.parkMapButton);
        mapView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to move to map screen
                Intent intent = new Intent(TransferingActivity.this, MainActivity.class);
                intent.putExtra("park", park);
                startActivity(intent);
            }
        });



    }

}
