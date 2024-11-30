package com.example.christmasapp;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.adapters.GiftAdapter;
import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;
import com.example.christmasapp.models.Gift;

import java.util.ArrayList;

public class ViewChildGiftsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_child_gifts);

        ListView lvChildGifts = findViewById(R.id.lv_child_gifts);

        // Récupérer tous les cadeaux de tous les enfants
        ArrayList<Gift> allGifts = new ArrayList<>();
        for (Child child : DataStorage.getAllChildren()) {
            allGifts.addAll(child.getGifts());
        }

        // Vérifiez s'il y a des cadeaux
        if (!allGifts.isEmpty()) {
            GiftAdapter adapter = new GiftAdapter(this, allGifts);
            lvChildGifts.setAdapter(adapter);
        } else {
            Toast.makeText(this, "Aucun cadeau trouvé pour les enfants.", Toast.LENGTH_SHORT).show();
        }
    }
}
