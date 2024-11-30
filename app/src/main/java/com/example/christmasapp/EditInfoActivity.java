package com.example.christmasapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;

public class EditInfoActivity extends AppCompatActivity {
    private EditText firstName, lastName, age, country, city, username, password;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info);

        // Lier les vues
        firstName = findViewById(R.id.edit_first_name);
        lastName = findViewById(R.id.edit_last_name);
        age = findViewById(R.id.edit_age);
        country = findViewById(R.id.edit_country);
        city = findViewById(R.id.edit_city);
        username = findViewById(R.id.edit_username);
        password = findViewById(R.id.edit_password);
        saveButton = findViewById(R.id.save_changes_button);

        // Récupérer le nom d'utilisateur (transmis via Intent)
        String currentUsername = getIntent().getStringExtra("username");
        Child currentChild = DataStorage.findChildByUsername(currentUsername);

        // Pré-remplir les champs avec les informations de l'enfant actuel
        if (currentChild != null) {
            firstName.setText(currentChild.getFirstName());
            lastName.setText(currentChild.getLastName());
            age.setText(String.valueOf(currentChild.getAge()));
            country.setText(currentChild.getCountry());
            city.setText(currentChild.getCity());
            username.setText(currentChild.getUsername());
            password.setText(currentChild.getPassword());
        }

        // Sauvegarder les nouvelles informations
        saveButton.setOnClickListener(v -> {
            try {
                String newFirstName = firstName.getText().toString().trim();
                String newLastName = lastName.getText().toString().trim();
                String ageText = age.getText().toString().trim();
                String newCountry = country.getText().toString().trim();
                String newCity = city.getText().toString().trim();
                String newUsername = username.getText().toString().trim();
                String newPassword = password.getText().toString().trim();

                // Validation des champs
                if (newFirstName.isEmpty() || newLastName.isEmpty() || ageText.isEmpty() ||
                        newCountry.isEmpty() || newCity.isEmpty() || newUsername.isEmpty() || newPassword.isEmpty()) {
                    Toast.makeText(this, "Tous les champs doivent être remplis", Toast.LENGTH_SHORT).show();
                    return;
                }

                int newAge = Integer.parseInt(ageText);

                // Mettre à jour les informations dans DataStorage
                if (currentChild != null) {
                    currentChild.setFirstName(newFirstName);
                    currentChild.setLastName(newLastName);
                    currentChild.setAge(newAge);
                    currentChild.setCountry(newCountry);
                    currentChild.setCity(newCity);
                    currentChild.setUsername(newUsername);
                    currentChild.setPassword(newPassword);

                    // Mettre à jour dans la liste d'enfants
                    DataStorage.updateChildInfo(currentChild);

                    Toast.makeText(this, "Modifications enregistrées avec succès !", Toast.LENGTH_SHORT).show();
                    finish(); // Fermer l'activité
                }
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Veuillez entrer un âge valide.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
