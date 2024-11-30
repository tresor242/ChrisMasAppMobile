package com.example.christmasapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.christmasapp.R;
import com.example.christmasapp.models.Child;

import java.util.ArrayList;

public class ChildAdapter extends ArrayAdapter<Child> {

    public ChildAdapter(@NonNull Context context, @NonNull ArrayList<Child> children) {
        super(context, 0, children);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Récupérer l'objet enfant à cette position
        Child child = getItem(position);

        // Recycler la vue si elle existe déjà
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_child, parent, false);
        }

        // Lier les données aux vues
        TextView tvChildName = convertView.findViewById(R.id.tv_child_name);
        TextView tvChildLocation = convertView.findViewById(R.id.tv_child_location);
        TextView tvChildAge = convertView.findViewById(R.id.tv_child_age);

        if (child != null) {
            tvChildName.setText("Nom : " + child.getFirstName() + " " + child.getLastName());
            tvChildLocation.setText("Localisation : " + child.getCity() + ", " + child.getCountry());
            tvChildAge.setText("Âge : " + child.getAge());
        }

        return convertView;
    }
}
