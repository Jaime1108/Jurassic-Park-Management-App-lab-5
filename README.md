# Jurassic Park App Mockup

This project is an Android app mockup for a fictional Jurassic Park management system. The app allows users to explore various zones of the park, view details about the dinosaurs in each zone, and transfer dinosaurs between zones.

## Features

1. **Main Activity (MainActivity):**
   - Displays a list of all the zones in Jurassic Park.
   - Each zone is represented by a button with the zone's name.
   - When a user clicks on a zone button, they are taken to the Zone Activity for that specific zone.

2. **Zone Activity (ZoneActivity):**
   - Shows a detailed list of dinosaurs within the selected zone.
   - Each dinosaur entry displays its name, type, and a profile picture.
   - Includes a button for transferring a dinosaur to a different zone.

3. **Transferring Activity (TransferringActivity):**
   - Prompts the user to input the name of the dinosaur they want to transfer and the zone they wish to transfer it to.
   - Contains a confirmation button that, when clicked, shows a popup message indicating whether the transfer was successful or not.
   - Provides a button to return to the Main Activity.

## Navigation Flow

1. **MainActivity**: The user starts here and can select any zone to explore.
2. **ZoneActivity**: Upon selecting a zone, the user sees a list of dinosaurs and can choose to transfer a dinosaur.
3. **TransferringActivity**: The user inputs transfer details and confirms, receiving feedback on the operation's success or failure. The user can return to the MainActivity from here.

## Getting Started

### Prerequisites

- Android Studio installed on your computer.
- Basic understanding of Android development and activities.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/Jaime1108/Jurassic-Park-Management-App-lab-5.git
Open the project in Android Studio.
Sync the project with Gradle files.
Build and run the app on an Android emulator or a physical device.
