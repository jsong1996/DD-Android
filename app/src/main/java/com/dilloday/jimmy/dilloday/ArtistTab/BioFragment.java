package com.dilloday.jimmy.dilloday.ArtistTab;


import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStream;

import com.dilloday.jimmy.dilloday.R;

import java.io.InputStream;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {
    public static View rootview;

    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootview = (View) inflater.inflate(R.layout.fragment_bio, container, false);


        try{
            InputStream is = getActivity().getAssets().open("schoolboyq.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String text = new String(buffer);
            TextView bio = (TextView) rootview.findViewById(R.id.artist_bio);
            bio.setText(text);



        } catch (IOException e){

            throw new RuntimeException(e);
        }
//        TextView bio = (TextView) rootview.findViewById(R.id.artist_bio);
//        bio.setText("This is a test");



        return rootview;



    }

}
