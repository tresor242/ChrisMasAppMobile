//package com.example.christmasapp;
//
//public class GiftListAdapter extends ArrayAdapter<Gift> {
//
//    public GiftListAdapter(Context context, List<Gift> gifts) {
//        super(context, 0, gifts);
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(getContext()).inflate(R.layout.gift_list_item, parent, false);
//        }
//
//        Gift gift = getItem(position);
//
//        TextView giftNameTextView = convertView.findViewById(R.id.gift_name_text);
//        TextView giftPriceTextView = convertView.findViewById(R.id.gift_price_text);
//
//        giftNameTextView.setText(gift.getName());
//        giftPriceTextView.setText("$" + String.valueOf(gift.getPrice()));
//
//        return convertView;
//    }
//}
//
