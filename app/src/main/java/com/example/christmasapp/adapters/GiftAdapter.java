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
import com.example.christmasapp.models.Gift;

import java.util.ArrayList;

public class GiftAdapter extends ArrayAdapter<Gift> {

    public GiftAdapter(@NonNull Context context, @NonNull ArrayList<Gift> gifts) {
        super(context, 0, gifts); // Appeler le constructeur parent
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Récupérer l'objet cadeau à cette position
        Gift gift = getItem(position);

        // Recycler la vue si elle existe déjà
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.gift_item, parent, false);
        }

        // Lier les données aux vues
        TextView tvGiftName = convertView.findViewById(R.id.tv_gift_name);
        TextView tvGiftType = convertView.findViewById(R.id.tv_gift_type);
        TextView tvGiftDescription = convertView.findViewById(R.id.tv_gift_description);
        TextView tvGiftPrice = convertView.findViewById(R.id.tv_gift_price);

        // Assurez-vous que gift n'est pas null
        if (gift != null) {
            tvGiftName.setText(gift.getName());
            tvGiftType.setText("Type : " + gift.getType());
            tvGiftDescription.setText(gift.getDescription());
            tvGiftPrice.setText("Prix : $" + gift.getPrice());
        }

        return convertView;
    }
}
