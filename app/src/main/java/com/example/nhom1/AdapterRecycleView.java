package com.example.nhom1;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import static android.content.Context.MODE_PRIVATE;
import static android.support.v4.content.ContextCompat.startActivity;
import static android.view.View.*;

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.RecyclerViewHolder> {
    public static List<Session> data = new ArrayList<>();
    private Context context;
    MainActivity mainActivity = new MainActivity();

    public AdapterRecycleView(List<Session> data) {
        this.data = data;
        mainActivity = new MainActivity();
    }

    public AdapterRecycleView(List<Session> data, Context context) {
        this.data = data;
        this.context = context;
    }

    //    public static int selectedPos = RecyclerView.NO_POSITION;
    public static int selectedPos = -1;

    @NonNull
    @Override
    public AdapterRecycleView.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        mainActivity.dataSQL = new DataSQL(viewGroup.getContext());
        LayoutInflater inflater = LayoutInflater.from((viewGroup.getContext()));
        View view = inflater.inflate(R.layout.item_session, viewGroup, false);
        return new RecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterRecycleView.RecyclerViewHolder recyclerViewHolder, final int possition) {
        recyclerViewHolder.txtItem.setText(data.get(possition).getSes_Time());
        recyclerViewHolder.txtTitle.setText(data.get(possition).getSes_Title());
        Log.e("onBindViewHolder: ", "Aaaaa");
        recyclerViewHolder.itemView.setSelected(selectedPos == possition);
        recyclerViewHolder.imageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(recyclerViewHolder.imageButton.getContext(), recyclerViewHolder.imageButton);
                //inflating menu from xml resource
                Log.e("onClick: ", "oke");
                popup.inflate(R.menu.menu);
                //adding click listener
                final Session session = data.get(possition);

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.itDel:
                                Log.e("onMenuItemClick: ", String.valueOf(possition));
                                data.remove(possition);
                                mainActivity.dataSQL.deleteSession(MainActivity.stringList.get(possition));
                                MainActivity.adapterRecycleView.notifyItemRemoved(possition);
                                MainActivity.adapterRecycleView.notifyDataSetChanged();
                                //Log.e( "data: ",MainActivity.stringList.get(possition).getSes_Time() );
                                //MainActivity.pendingIntent.cancel();

                                //MainActivity.pendingIntent.cancel();
                                Intent intent = new Intent(context, MainActivity.class);
                                startActivity(context, intent, Bundle.EMPTY);

                                return true;
                            case R.id.itReview:
                                //handle menu2 click
                                return true;
                            default:
                                Log.e("onMenuItemClick: ", "oke");
                                return false;
                        }
                    }
                });
                //displaying the popup
                popup.show();
            }
        });
        //        recyclerViewHolder.itemView.setBackgroundColor(selectedPos == possition ? Color.GREEN : Color.TRANSPARENT);
        if (data.get(possition).getSes_addSes() == 1) {
            recyclerViewHolder.checkBox.setChecked(true);
        } else recyclerViewHolder.checkBox.setChecked(false);
        recyclerViewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (recyclerViewHolder.checkBox.isChecked()) {
                    MainActivity.stringList.get(possition).setSes_addSes(1);
                    mainActivity.dataSQL.updateSession(MainActivity.stringList.get(possition));
                    Log.e("oke", "update oke");
                } else {
                    MainActivity.stringList.get(possition).setSes_addSes(0);
                    mainActivity.dataSQL.updateSession(MainActivity.stringList.get(possition));
                    Log.e("oke", "update oke");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements OnClickListener {
        public TextView txtItem;
        public TextView txtTitle;
        public CheckBox checkBox;
        public ImageButton imageButton;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItem = (TextView) itemView.findViewById(R.id.itemSession);
            txtTitle = (TextView) itemView.findViewById(R.id.tvTitlelAlarm);
            checkBox = (CheckBox) itemView.findViewById(R.id.cbAddSes);
            itemView.setOnClickListener(this);
            imageButton = (ImageButton) itemView.findViewById(R.id.btnSetSession);
        }

        @Override
        public void onClick(View v) {
            if (getAdapterPosition() == RecyclerView.NO_POSITION) return;
            // Updating old as well as new positions
            notifyItemChanged(selectedPos);
            selectedPos = getAdapterPosition();
            notifyItemChanged(selectedPos);
            itemView.getContext().startActivity(new Intent(itemView.getContext(), AddAlarmActivity.class));

            Log.e("onClick: ", "clicked");
        }
    }
}
