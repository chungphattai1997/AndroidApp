package com.example.baitapmau;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SocialNetworkAdapter extends ArrayAdapter<SocialNetwork> {
    Context context;
    int layoutID;
    ArrayList<SocialNetwork> data = null;

    public SocialNetworkAdapter(Context context, int layoutID, ArrayList<SocialNetwork> data) {
        super(context, layoutID, data);
        this.context = context;
        this.layoutID = layoutID;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        SocialNetworkHolder holder = null;

        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutID, parent, false);
            holder = new SocialNetworkHolder();
            holder.imgIcon = row.findViewById(R.id.imageView);
            holder.txtTitle = row.findViewById(R.id.txtTitle);

            row.setTag(holder);
        }
        else
        {
            holder = (SocialNetworkHolder) row.getTag();
        }

        SocialNetwork item = data.get(position);
        holder.txtTitle.setText(item.title);
        holder.imgIcon.setImageResource(item.icon);

        return  row;
    }

    static class SocialNetworkHolder{
        ImageView imgIcon;
        TextView txtTitle;
    }
}
