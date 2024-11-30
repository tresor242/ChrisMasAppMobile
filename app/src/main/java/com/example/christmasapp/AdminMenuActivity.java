package com.example.christmasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

        Button btnViewChildren = findViewById(R.id.btn_view_children);
        Button btnViewChildInfo = findViewById(R.id.btn_view_child_info);
        Button btnViewChildGifts = findViewById(R.id.btn_view_child_gifts);

        // Voir tous les enfants
        btnViewChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, ViewChildrenActivity.class);
                startActivity(intent);
            }
        });

        // Voir les informations d'un enfant
        btnViewChildInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, ViewChildInfoActivity.class);
                startActivity(intent);
            }
        });

         //Voir les demandes de cadeaux
        btnViewChildGifts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminMenuActivity.this, ViewChildGiftsActivity.class);
                startActivity(intent);
            }
        });
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
            intent = new Intent(AdminMenuActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
