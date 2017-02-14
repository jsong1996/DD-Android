package com.dilloday.jimmy.dilloday.HomeTab;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dilloday.jimmy.dilloday.Main.MainActivity;
import com.dilloday.jimmy.dilloday.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.net.URL;


public class Tab2Activity extends Fragment {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_map, container, false);
        FirebaseStorage storage = FirebaseStorage.getInstance();

//        StorageReference storageRef = storage.getReferenceFromUrl("gs://dillo-day-androi-1483670185603.appspot.com/images/lakefill_map_2016.png");
//
//        StorageReference spaceRef = storageRef.child("images/lakefill_map_2016.png");
//
//        Uri url = spaceRef.getDownloadUrl().getResult();
//
        ImageView map = (ImageView) view.findViewById(R.id.map);
        Drawable drawable = getResources().getDrawable(R.drawable.lakefill_map_2016);
        map.setBackground(drawable);
//        Picasso.with(getContext())
//                .load(url)
//                .into(map);


        return view;


    }
}
