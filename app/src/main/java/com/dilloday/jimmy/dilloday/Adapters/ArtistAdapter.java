package com.dilloday.jimmy.dilloday.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dilloday.jimmy.dilloday.Adapters.ArtistAdapter;
import com.dilloday.jimmy.dilloday.Classes.Artist;
import com.dilloday.jimmy.dilloday.HomeTab.Tab1Activity;
import com.dilloday.jimmy.dilloday.R;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;


/**
 * Created by jsonh on 7/19/2016.
 */
public class ArtistAdapter extends BaseAdapter {
    Context context;
    protected List<Artist> listArtists;
    boolean[] clickedArray = new boolean[7];
    LayoutInflater inflater;
    MediaPlayer player = new MediaPlayer();
    String musicSource = new String();

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
        final ViewHolder holder;
        final int pos = position;


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
            holder.playbar = (ImageView) convertView.findViewById(R.id.play_bar);


            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Artist artist = listArtists.get(position);
        holder.txtName.setText(artist.getName());
        holder.txtStrikes.setText(artist.getTime());
        holder.audioURL = artist.getAudioURL();

        ImageView imgHolder = (ImageView) convertView.findViewById(R.id.imgHolder);
        if (clickedArray[position] == true){
            imgHolder.setAlpha(0.5f);
        }
        else{
            imgHolder.setAlpha(1.0f);
        }

        imgHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickedArray[pos] == false) {
                    clickedArray[pos] = true;
                    v.setAlpha(0.5f);
                }
                else{
                    clickedArray[pos] = false;
                    v.setAlpha(1.0f);
                }


                try {
                    if (musicSource != holder.audioURL) {
                        player.stop();
                        musicSource = holder.audioURL;
                    }

                    if (player.isPlaying()) {
                        player.pause();
                    } else {
                        player.start();
                    }

                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource(musicSource);
                    player.prepare();
                    player.start();
                }
                 catch (Exception e) {
                    // TODO: handle exception
                }

            }
        });




        Picasso.with(context) //Context
                .load(artist.getImgURL()) //URL/FILE
                .into(imgHolder);//an ImageView Object to show the loaded image;

        //holder.backgroundImg.setBackground(artist.getDrawableImg());




        return convertView;
    }



    private class ViewHolder {
        TextView txtName;
        TextView txtStrikes;
        RelativeLayout backgroundImg;
        ImageView playbar;
        int pos;
        String audioURL;


    }
}