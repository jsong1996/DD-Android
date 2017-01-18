package com.dilloday.jimmy.dilloday.ArtistTab;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.dilloday.jimmy.dilloday.R;

import java.net.URI;


/**
 * A simple {@link Fragment} subclass.
 */
public class MusicFragment extends Fragment {


    /* TODO: Spotify/Itunes/Youtube/Soundcloud/Tidal Integration */

    public MusicFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_music, container, false);

        final ImageButton youtubeButton = (ImageButton) view.findViewById(R.id.youtube_button);
        final ImageButton spotifyButton = (ImageButton) view.findViewById(R.id.spotify_button);
        final ImageButton itunesButton = (ImageButton) view.findViewById(R.id.itunes_button);
        final ImageButton soundcloudButton = (ImageButton) view.findViewById(R.id.soundcloud_button);
        final ImageButton tidalButton = (ImageButton) view.findViewById(R.id.tidal_button);

        youtubeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/SchoolBoyQVEVO"));
                startActivity(browserIntent);
            }
        });

        spotifyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent spotifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.spotify.com/artist/5IcR3N7QB1j6KBL8eImZ8m"));
                startActivity(spotifyIntent);
            }
        });
        itunesButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent spotifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://itunes.apple.com/us/artist/schoolboy-q/id333097675"));
                startActivity(spotifyIntent);
            }
        });
        soundcloudButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent spotifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://soundcloud.com/schoolboy-q"));
                startActivity(spotifyIntent);
            }
        });
        tidalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent spotifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://listen.tidal.com/artist/3882537"));
                startActivity(spotifyIntent);
            }
        });


        return view;
    }

}
