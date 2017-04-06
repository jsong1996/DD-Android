package com.dilloday.jimmy.dilloday.HomeTab;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


import com.dilloday.jimmy.dilloday.Adapters.ArtistAdapter;
import com.dilloday.jimmy.dilloday.ArtistPages.ArtistOne;
import com.dilloday.jimmy.dilloday.Classes.Artist;
import com.dilloday.jimmy.dilloday.Classes.dbArtist;
import com.dilloday.jimmy.dilloday.Classes.Util;
import com.dilloday.jimmy.dilloday.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Tab1Activity extends Fragment {
    private static final String TAG = "FirebaseDatabase";
    private static final String pinkBackgroundURL = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQbEICyOfhxQfSU9RfxTqJHbIWB0qChykTNZwl4FYtPF1JPiIxbiA";
    public static Artist artist1 = new Artist("TBD", "9:00 PM", pinkBackgroundURL, "notset");
    public static Artist artist2 = new Artist("TBD", "7:45 PM", pinkBackgroundURL, "notset");
    public static Artist artist3 = new Artist("TBD", "6:00 PM", pinkBackgroundURL, "notset");
    public static Artist artist4 = new Artist("TBD", "5:15 PM", pinkBackgroundURL, "notset");
    public static Artist artist5 = new Artist("TBD", "3:30 PM", pinkBackgroundURL, "notset");
    public static Artist artist6 = new Artist("TBD", "2:00 PM", pinkBackgroundURL, "notset");
    public static Artist artist7 = new Artist("TBD", "1:00 PM", pinkBackgroundURL, "notset");
    public static MediaPlayer player = new MediaPlayer();
    public static String musicSource = new String();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<Artist> arrayArtists = new ArrayList<Artist>();

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference artistOneRef = database.getReference("Artists/");
        artistOneRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                dbArtist newPost = dataSnapshot.getValue(dbArtist.class);
//                System.out.println("Name: " + newPost.Name);
//                System.out.println("Time: " + newPost.Time);
//                System.out.println("Previous Post ID: " + prevChildKey);

                if (newPost.ID.toString().equals("Artist1")){
                    artist1.setName(newPost.Name);
                    artist1.setTime(newPost.Time);;
                    artist1.setImgURL(newPost.imgURL);
                    artist1.setAudioURL(newPost.audioURL);

                }
                else if (newPost.ID.toString().equals("Artist2")){
                    artist2.setName(newPost.Name);
                    artist2.setTime(newPost.Time);
                    artist2.setImgURL(newPost.imgURL);
                    artist2.setAudioURL(newPost.audioURL);
                }
                else if (newPost.ID.toString().equals("Artist3")) {
                    artist3.setName(newPost.Name);
                    artist3.setTime(newPost.Time);
                    artist3.setImgURL(newPost.imgURL);
                    artist3.setAudioURL(newPost.audioURL);
                }
                else if (newPost.ID.toString().equals("Artist4")) {
                    artist4.setName(newPost.Name);
                    artist4.setTime(newPost.Time);
                    artist4.setImgURL(newPost.imgURL);
                    artist4.setAudioURL(newPost.audioURL);
                }
                else if (newPost.ID.toString().equals("Artist5")) {
                    artist5.setName(newPost.Name);
                    artist5.setTime(newPost.Time);
                    artist5.setImgURL(newPost.imgURL);
                    artist5.setAudioURL(newPost.audioURL);
                }
                else if (newPost.ID.toString().equals("Artist6")) {
                    artist6.setName(newPost.Name);
                    artist6.setTime(newPost.Time);
                    artist6.setImgURL(newPost.imgURL);
                    artist6.setAudioURL(newPost.audioURL);
                }
                else if (newPost.ID.toString().equals("Artist7")) {
                    artist7.setName(newPost.Name);
                    artist7.setTime(newPost.Time);
                    artist7.setImgURL(newPost.imgURL);
                    artist7.setAudioURL(newPost.audioURL);
                }

            }


            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                dbArtist changedPost = dataSnapshot.getValue(dbArtist.class);
                //System.out.println("The updated post title is: " + changedPost.Name);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
        arrayArtists.add(artist1);
        arrayArtists.add(artist2);
        arrayArtists.add(artist3);
        arrayArtists.add(artist4);
        arrayArtists.add(artist5);
        arrayArtists.add(artist6);
        arrayArtists.add(artist7);

        final ListView listview = (ListView) rootView.findViewById(R.id.test_list);
        ArtistAdapter adapter = new ArtistAdapter(this.getContext(), arrayArtists);
        listview.setAdapter(adapter);




        //Pull the string at the corresponding click and store into listeItem.
        listview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Extract object at each lits position.
                Object listItem = listview.getItemAtPosition(position);
                switch (position) {
                    //Fill with artist switch cases
                    case 0:
                        try {

                            if (musicSource != artist1.getAudioURL()) {
                                player.stop();
                                musicSource = artist1.getAudioURL();
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
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
//                        Intent newActivity = new Intent(Tab1Activity.this.getContext(), ArtistOne.class);
//                        startActivity(newActivity);
                        break;
                    case 1:
                        try {

                            if (musicSource != artist2.getAudioURL()) {
                                player.stop();
                                musicSource = artist2.getAudioURL();
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

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                    case 2:
                        try {

                            if (musicSource != artist3.getAudioURL()) {
                                player.stop();
                                musicSource = artist3.getAudioURL();
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

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                    case 3:
                        try {

                            if (musicSource != artist4.getAudioURL()) {
                                player.stop();
                                musicSource = artist4.getAudioURL();
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

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                    case 4:
                        try {

                            if (musicSource != artist5.getAudioURL()) {
                                player.stop();
                                musicSource = artist5.getAudioURL();
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

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                    case 5:
                        try {

                            if (musicSource != artist6.getAudioURL()) {
                                player.stop();
                                musicSource = artist6.getAudioURL();
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

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                    case 6:
                        try {

                            if (musicSource != artist7.getAudioURL()) {
                                player.stop();
                                musicSource = artist7.getAudioURL();
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

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                    case 7:
                        try {

                            if (musicSource != "http://sound41.songsbling.link/songspk/files/A%20Sky%20Full%20Of%20Stars%20-%20Coldplay%20-%20%5BSongsPk.CC%5D.mp3") {
                                player.stop();
                                musicSource = "http://sound41.songsbling.link/songspk/files/A%20Sky%20Full%20Of%20Stars%20-%20Coldplay%20-%20%5BSongsPk.CC%5D.mp3";
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

                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                        break;
                }


            }
        }
        );

        return rootView;
    }

    public static Drawable LoadImageFromWebOperations(String url) {
        try {
            InputStream is = (InputStream) new URL(url).getContent();
            Drawable d = Drawable.createFromStream(is, "src name");
            return d;
        } catch (Exception e) {
            return null;
        }
    }
}
