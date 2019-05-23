package com.example.baitap4;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MusicAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Music> data = null;

    public MusicAdapter(Context context, ArrayList<Music> data) {
        this.context = context;
        this.data = data;
    }

    static class ViewHolder{
        ImageView avatar;
        TextView name;
        TextView singer;
        TextView time;
        ImageView arrow;
    }

    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int i) {
        return this.data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return this.data.indexOf(getItem(i));
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder viewHolder = null;

        if(row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(R.layout.list_row, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.avatar = row.findViewById(R.id.imageViewAvatar);
            viewHolder.name = row.findViewById(R.id.textViewName);
            viewHolder.singer = row.findViewById(R.id.textViewSinger);
            viewHolder.time = row.findViewById(R.id.textViewTime);
            viewHolder.arrow = row.findViewById(R.id.imageView2);
            row.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) row.getTag();
        }

        Music music = data.get(i);
        viewHolder.avatar.setImageResource(music.getAvatar());
        viewHolder.name.setText(music.getName());
        viewHolder.singer.setText(music.getSinger());
        viewHolder.time.setText(music.getTime());
        viewHolder.arrow.setImageResource(music.getArrow());

        return row;
    }

}
