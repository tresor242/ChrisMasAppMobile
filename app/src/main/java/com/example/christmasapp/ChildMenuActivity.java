package com.example.christmasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;

public class ChildMenuActivity extends AppCompatActivity {
    private Child currentChild;
    private TextView tvWelcome; // Déclaration ici, initialisation dans onCreate()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_menu);

        // Initialiser tvWelcome après setContentView
        tvWelcome = findViewById(R.id.tv_welcome);
        Button btnEditInfo = findViewById(R.id.btn_edit_info);
        Button btnAddGift = findViewById(R.id.btn_add_gift);
        Button btnViewGifts = findViewById(R.id.btn_view_gifts);

        // Récupérer l'enfant connecté
        String username = getIntent().getStringExtra("username");
        currentChild = DataStorage.findChildByUsername(username);

        // Afficher le message de bienvenue
        if (currentChild != null) {
            tvWelcome.setText("Bienvenue, " + currentChild.getFirstName());
        }

        // Modifier les informations
        btnEditInfo.setOnClickListener(v -> {
            Intent intent = new Intent(ChildMenuActivity.this, EditInfoActivity.class);
            intent.putExtra("username", currentChild.getUsername());
            startActivity(intent);
        });

        // Ajouter un cadeau (commenté pour l'instant)
        btnAddGift.setOnClickListener(v -> {
            Intent intent = new Intent(ChildMenuActivity.this, AddGiftActivity.class);
            intent.putExtra("username", currentChild.getUsername());
            startActivity(intent);
        });

        // Voir les cadeaux (commenté pour l'instant)
        btnViewGifts.setOnClickListener(v -> {
            Intent intent = new Intent(ChildMenuActivity.this, ViewGiftsActivity.class);
            intent.putExtra("username", currentChild.getUsername());
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Recharger les données de l'utilisateur connecté
        if (currentChild != null) {
            currentChild = DataStorage.findChildByUsername(currentChild.getUsername());
            if (currentChild != null) {
                tvWelcome.setText("Bienvenue, " + currentChild.getFirstName());
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add(0, 1, 0, "Se déconnecter");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        // Vérifiez si l'ID correspond à l'élément que vous souhaitez gérer
        if (item.getItemId() == 1) {
            intent = new Intent(ChildMenuActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
