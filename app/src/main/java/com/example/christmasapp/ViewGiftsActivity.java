package com.example.christmasapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.adapters.GiftAdapter;
import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;
import com.example.christmasapp.models.Gift;

import java.util.ArrayList;

public class ViewGiftsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gifts);

        ListView lvGifts = findViewById(R.id.lv_gifts);

        // Récupérer tous les cadeaux de tous les enfants
        ArrayList<Gift> allGifts = new ArrayList<>();
        for (Child child : DataStorage.getAllChildren()) {
            allGifts.addAll(child.getGifts());
        }

        // Configurer l'adaptateur pour afficher les cadeaux
        GiftAdapter adapter = new GiftAdapter(this, allGifts);
        lvGifts.setAdapter(adapter);
    }
}
