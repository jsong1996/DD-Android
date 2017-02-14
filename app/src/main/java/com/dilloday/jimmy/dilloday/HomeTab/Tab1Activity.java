package com.dilloday.jimmy.dilloday.HomeTab;

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
import com.dilloday.jimmy.dilloday.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Tab1Activity extends Fragment {
    private static final String TAG = "FirebaseDatabase";
    public static Artist artist1 = new Artist();
    public static Artist artist2 = new Artist();
    public static Artist artist3 = new Artist();
    public static Artist artist4 = new Artist();
    public static Artist artist5 = new Artist();
    public static Artist artist6 = new Artist();
    public static Artist artist7 = new Artist();


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
                System.out.println("Name: " + newPost.Name);
                System.out.println("Time: " + newPost.Time);
                System.out.println("Previous Post ID: " + prevChildKey);

                if (newPost.Name.toString().equals("SCHOOLBOY Q")){
                    artist1.setName(newPost.Name);
                    artist1.setTime(newPost.Time);;
                    artist1.setImg(R.drawable.schoolboyq_background);
                }
                else if (newPost.Name.toString().equals("CASHMERE CAT")){
                    artist2.setName(newPost.Name);
                    artist2.setTime(newPost.Time);
                    artist2.setImg(R.drawable.cashmere_background);
                }
                else if (newPost.Name.toString().equals("DIAL UP")) {
                    artist3.setName(newPost.Name);
                    artist3.setTime(newPost.Time);
                    artist3.setImg(R.drawable.dialup_background);
                }
                else if (newPost.Name.toString().equals("HAYDEN JAMES")) {
                    artist4.setName(newPost.Name);
                    artist4.setTime(newPost.Time);
                    artist4.setImg(R.drawable.hayden_background);
                }
                else if (newPost.Name.toString().equals("ANDERSON .PAAK")) {
                    artist5.setName(newPost.Name);
                    artist5.setTime(newPost.Time);
                    artist5.setImg(R.drawable.anderson_background);
                }
                else if (newPost.Name.toString().equals("THE MOWGLIS")) {
                    artist6.setName(newPost.Name);
                    artist6.setTime(newPost.Time);
                    artist6.setImg(R.drawable.mowglis_background);
                }
                else if (newPost.Name.toString().equals("THE SYNDICATE")) {
                    artist7.setName(newPost.Name);
                    artist7.setTime(newPost.Time);
                    artist7.setImg(R.drawable.syndicate_background);
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

        //artist1 = new Artist(artist10.getName(), artist10.getTime(), R.drawable.schoolboyq_background);
        //artist2 = new Artist("CASHMERE CAT", "7:45 PM", R.drawable.cashmere_background);
        //artist3 = new Artist("DIAL UP", "6:45 PM", R.drawable.dialup_background);
//        artist4 = new Artist("HAYDEN JAMES", "5:15 PM", R.drawable.cashmere_background);
//        artist5 = new Artist("ANDERSON .PAAK", "3:30 PM", R.drawable.anderson_background);
//        artist6 = new Artist("THE MOWGLI'S", "2:00 PM", R.drawable.mowglis_background);
//        artist7 = new Artist("THE SYNDICATE", "1:00 PM", R.drawable.syndicate_background);

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
                        Intent newActivity = new Intent(Tab1Activity.this.getContext(), ArtistOne.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                }


            }
        }
        );

        return rootView;
    }
}
