package com.example.emad.splashscreen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HP Pavilion 13 on 3/4/2017.
 */


public class customAdapter  extends ArrayAdapter<Item_Player> {
    private List<Item_Player> l;
    public TextView name, type;
    public TextView img_cost;
    private static ArrayList<Integer> check=new ArrayList<>();


    public customAdapter(Context context, int resource, List<Item_Player> items) {
        super(context, resource, items);
        l=items;
    }


    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.card_select_player, null);

        }


        Item_Player p = getItem(position);
        check.add(position);

        if (p != null) {
            //CheckedTextView tt1 = (CheckedTextView) v.findViewById(R.id.txtvw);
            name = (TextView) v.findViewById(R.id.title);
            type = (TextView) v.findViewById(R.id.position);
            img_cost = (TextView) v.findViewById(R.id.cost_image);

            if (name != null) {
                name.setText(p.name);
                type.setText(p.type);
                img_cost.setText(p.cost.toString());

                img_cost.setBackgroundResource(R.color.colorAccent);
            }




        }
        return v;
    }

}
