package com.dilloday.jimmy.dilloday.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dilloday.jimmy.dilloday.Adapters.ArtistAdapter;
import com.dilloday.jimmy.dilloday.Classes.Artist;
import com.dilloday.jimmy.dilloday.R;

import java.util.List;


/**
 * Created by jsonh on 7/19/2016.
 */
public class ArtistAdapter extends BaseAdapter {
    Context context;
    protected List<Artist> listArtists;
    LayoutInflater inflater;

    public ArtistAdapter(Context context, List<Artist> listArtists) {
        this.listArtists = listArtists;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public int getCount() {
        return listArtists.size();
    }

    @Override
    public Artist getItem(int position) {
        return listArtists.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.activity_listview,
                    parent, false);
            holder.txtName = (TextView) convertView
                    .findViewById(R.id.txt_name);
            holder.txtStrikes = (TextView) convertView
                    .findViewById(R.id.txt_time);
            holder.backgroundImg = (RelativeLayout) convertView
                    .findViewById(R.id.background_img);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Artist artist = listArtists.get(position);
        holder.txtName.setText(artist.getName());
        holder.txtStrikes.setText(artist.getTime());
        holder.backgroundImg.setBackgroundResource(artist.getImg());
        //holder.backgroundImg.setImageResource(R.mipmap.schoolboy_background);

        return convertView;
    }

    private class ViewHolder {
        TextView txtName;
        TextView txtStrikes;
        RelativeLayout backgroundImg;


    }
}