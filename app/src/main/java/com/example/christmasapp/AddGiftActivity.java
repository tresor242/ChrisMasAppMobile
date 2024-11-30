package com.example.christmasapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;
import com.example.christmasapp.models.Gift;

public class AddGiftActivity extends AppCompatActivity {
    private Child currentChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_gift);

        RadioGroup radioGroupGiftType = findViewById(R.id.radio_group_gift_type);
        EditText etGiftName = findViewById(R.id.et_gift_name);
        EditText etGiftDescription = findViewById(R.id.et_gift_description);
        EditText etGiftPrice = findViewById(R.id.et_gift_price);
        Button btnAddGift = findViewById(R.id.btn_add_gift);

        // Récupérer l'utilisateur connecté
        String username = getIntent().getStringExtra("username");
        currentChild = DataStorage.findChildByUsername(username);

        btnAddGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer l'option sélectionnée dans le RadioGroup
                int selectedId = radioGroupGiftType.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(AddGiftActivity.this, "Veuillez sélectionner un type de cadeau", Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton selectedRadioButton = findViewById(selectedId);
                String type = selectedRadioButton.getText().toString();

                // Récupérer les autres informations
                String name = etGiftName.getText().toString().trim();
                String description = etGiftDescription.getText().toString().trim();
                String priceStr = etGiftPrice.getText().toString().trim();

                if (name.isEmpty() || description.isEmpty() || priceStr.isEmpty()) {
                    Toast.makeText(AddGiftActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Conversion du prix
                try {
                    double price = Double.parseDouble(priceStr);

                    // Création et ajout du cadeau
                    Gift gift = new Gift(type, name, description, price);
                    currentChild.addGift(gift); // Ajouter le cadeau dans la liste
                    Toast.makeText(AddGiftActivity.this, "Cadeau ajouté avec succès !", Toast.LENGTH_SHORT).show();
                    finish();
                } catch (NumberFormatException e) {
                    Toast.makeText(AddGiftActivity.this, "Veuillez entrer un prix valide", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
