//package com.example.christmasapp;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ArrayAdapter;
//import android.widget.TextView;
//
//import com.example.christmasapp.models.Child;
//
//import java.util.List;
//
//public class ChildListAdapter extends ArrayAdapter<Child> {
//
//    public ChildListAdapter(Context context, List<Child> children) {
//        super(context, 0, children);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.child_list_item, parent, false);
//        }
//
//        Child child = getItem(position);
//
//        TextView nameTextView = convertView.findViewById(R.id.name_text);
//        TextView locationTextView = convertView.findViewById(R.id.location_text);
//
//        nameTextView.setText(child.getFirstName() + " " + child.getLastName());
//        locationTextView.setText(child.getCity() + ", " + child.getCountry());
//
//        return convertView;
//    }
//}
//
