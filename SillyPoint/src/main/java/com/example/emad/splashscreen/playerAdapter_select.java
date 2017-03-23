package com.example.emad.splashscreen;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
public class playerAdapter_select extends RecyclerView.Adapter<playerAdapter_select.MyViewHolder>{

    private SelectTeam.JSONTask mContext;
    private ArrayList<Player> P_list;

    final private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, type;
        public TextView img_cost;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.title);
            type = (TextView) view.findViewById(R.id.position);
            img_cost = (TextView) view.findViewById(R.id.cost_image);

            view.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            //System.out.println("onClick");
            //TextView tv = (TextView) v.findViewById(R.id.text1);
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }


    public playerAdapter_select( ArrayList<Player> albumList,ListItemClickListener listener) {
        //this.mContext = mContext;
        this.P_list = albumList;
        this.mOnClickListener = listener;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_select_player, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Player p = P_list.get(position);
        holder.img_cost.setText(p.cost.toString());
        holder.name.setText(p.name);
        holder.type.setText(p.type);

        // loading album cover using Glide library

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // showPopupMenu(holder.overflow);
            }
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
   /* private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
       // inflater.inflate(R.menu.menu_album, popup.getMenu());
       // popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }*/

    /**
     * Click listener for popup menu items
     */
   /* class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }
*/
    @Override
    public int getItemCount() {
        return P_list.size();
    }
}
