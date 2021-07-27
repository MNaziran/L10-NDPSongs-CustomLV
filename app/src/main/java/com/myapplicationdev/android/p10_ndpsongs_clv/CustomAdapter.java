package com.myapplicationdev.android.p10_ndpsongs_clv;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(@NonNull Context context, int resource, ArrayList<Song> objects){
        super(context, resource, objects);
        this.parent_context = context;
        this.layout_id = resource;
        this.songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvStars = rowView.findViewById(R.id.textViewStars);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);


        Song currentSong = songList.get(position);

        tvTitle.setText(currentSong.getTitle());
        tvYear.setText(currentSong.toStringYear());
        tvStars.setText(currentSong.starToString());
        tvSinger.setText(currentSong.getSingers());
        return rowView;
    }

}

