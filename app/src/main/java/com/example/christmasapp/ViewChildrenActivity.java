package com.example.christmasapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.christmasapp.adapters.ChildAdapter;
import com.example.christmasapp.data.DataStorage;
import com.example.christmasapp.models.Child;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewChildrenActivity extends AppCompatActivity {

    private ArrayList<Child> children; // Liste complète des enfants
    private ListView lvChildren;
    private ChildAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_children);

        lvChildren = findViewById(R.id.lv_children);
        Button btnSortName = findViewById(R.id.btn_sort_name);
        Button btnSortLocation = findViewById(R.id.btn_sort_location);

        // Récupérer la liste des enfants depuis DataStorage
        children = DataStorage.getAllChildren();

        // Configurer l'adaptateur pour le ListView
        adapter = new ChildAdapter(this, children);
        lvChildren.setAdapter(adapter);

        // Gérer le clic sur "Trier par Nom/Prénom"
        btnSortName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortByName(); // Appeler la méthode pour trier par nom/prénom
            }
        });

        // Gérer le clic sur "Trier par Pays/Ville"
        btnSortLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sortByLocation(); // Appeler la méthode pour trier par pays/ville
            }
        });

        // Gérer les clics sur les éléments du ListView
        lvChildren.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Child selectedChild = children.get(position);

                // Passer les informations de l'enfant à ChildDetailsActivity
                Intent intent = new Intent(ViewChildrenActivity.this, ChildDetailsActivity.class);
                intent.putExtra("firstName", selectedChild.getFirstName());
                intent.putExtra("lastName", selectedChild.getLastName());
                intent.putExtra("age", selectedChild.getAge());
                intent.putExtra("country", selectedChild.getCountry());
                intent.putExtra("city", selectedChild.getCity());
                intent.putExtra("username", selectedChild.getUsername());
                startActivity(intent);
            }
        });
    }

    // Méthode pour trier par nom/prénom
    private void sortByName() {
        Collections.sort(children, new Comparator<Child>() {
            @Override
            public int compare(Child c1, Child c2) {
                int firstNameComparison = c1.getFirstName().compareTo(c2.getFirstName());
                if (firstNameComparison == 0) {
                    return c1.getLastName().compareTo(c2.getLastName());
                }
                return firstNameComparison;
            }
        });
        adapter.notifyDataSetChanged(); // Mettre à jour l'affichage
    }


    // Méthode pour trier par pays/ville
    private void sortByLocation() {
        Collections.sort(children, new Comparator<Child>() {
            @Override
            public int compare(Child c1, Child c2) {
                int countryComparison = c1.getCountry().compareTo(c2.getCountry());
                if (countryComparison == 0) {
                    return c1.getCity().compareTo(c2.getCity());
                }
                return countryComparison;
            }
        });
        adapter.notifyDataSetChanged(); // Mettre à jour l'affichage
    }

}
