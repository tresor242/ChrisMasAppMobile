package com.example.christmasapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText firstName = findViewById(R.id.input_firstname);
        EditText lastName = findViewById(R.id.input_lastname);
        EditText age = findViewById(R.id.input_age);
        EditText country = findViewById(R.id.input_country);
        EditText city = findViewById(R.id.input_city);
        EditText username = findViewById(R.id.input_username);
        EditText password = findViewById(R.id.input_password);
        Button registerButton = findViewById(R.id.btn_register);

        registerButton.setOnClickListener(v -> {
            String fName = firstName.getText().toString().trim();
            String lName = lastName.getText().toString().trim();
            String ageText = age.getText().toString().trim();
            String childCountry = country.getText().toString().trim();
            String childCity = city.getText().toString().trim();
            String user = username.getText().toString().trim();
            String pass = password.getText().toString().trim();

            if (fName.isEmpty() || lName.isEmpty() || ageText.isEmpty() || childCountry.isEmpty()
                    || childCity.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Tous les champs sont obligatoires", Toast.LENGTH_SHORT).show();
                return;
            }

            int childAge;
            try {
                childAge = Integer.parseInt(ageText);
            } catch (NumberFormatException e) {
                Toast.makeText(RegisterActivity.this, "Âge invalide", Toast.LENGTH_SHORT).show();
                return;
            }

            DataStorage.addChild(new Child(fName, lName, childAge, childCountry, childCity, user, pass));
            Toast.makeText(RegisterActivity.this, "Inscription réussie", Toast.LENGTH_SHORT).show();

            // Retour à la page de connexion
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
