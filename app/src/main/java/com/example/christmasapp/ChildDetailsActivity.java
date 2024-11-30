package com.example.christmasapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.models.Child;

public class ChildDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_details);

        TextView tvName = findViewById(R.id.tv_name);
        TextView tvAge = findViewById(R.id.tv_age);
        TextView tvLocation = findViewById(R.id.tv_location);
        TextView tvUsername = findViewById(R.id.tv_username);

        // Récupérer les données transmises via l'Intent
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        int age = getIntent().getIntExtra("age", 0);
        String country = getIntent().getStringExtra("country");
        String city = getIntent().getStringExtra("city");
        String username = getIntent().getStringExtra("username");

        // Afficher les informations dans les TextView
        tvName.setText("Nom : " + firstName + " " + lastName);
        tvAge.setText("Âge : " + age);
        tvLocation.setText("Localisation : " + city + ", " + country);
        tvUsername.setText("Nom d'utilisateur : " + username);
    }
}
