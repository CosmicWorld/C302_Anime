package com.example.a15017381.c302_anime;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017381 on 29/5/2017.
 */

public class AnimeAdapter extends ArrayAdapter<Anime> {
    Context context;
    int layoutResourceId;
    ArrayList<Anime> animeList = null;

    public AnimeAdapter(Context context, int layoutResourceId, ArrayList<Anime> animeList) {
        super(context, layoutResourceId, animeList);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.animeList = animeList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        AnimeHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new AnimeHolder();
            holder.txtName = (TextView)row.findViewById(R.id.textViewName);
            holder.txtDescription = (TextView)row.findViewById(R.id.textViewDescription);
            holder.txtLink = (TextView)row.findViewById(R.id.textViewLink);
            holder.txtImage = (TextView)row.findViewById(R.id.textViewImage);

            row.setTag(holder);
        }
        else
        {
            holder = (AnimeHolder)row.getTag();
        }

        Anime cat = animeList.get(position);
        holder.txtName.setText(cat.getName());
        holder.txtDescription.setText(cat.getDescription());
        holder.txtLink.setText(cat.getLink());
        holder.txtImage.setText(cat.getImage());
        return row;
    }

    static class AnimeHolder
    {
        TextView txtName;
        TextView txtDescription;
        TextView txtLink;
        TextView txtImage;
    }
}
