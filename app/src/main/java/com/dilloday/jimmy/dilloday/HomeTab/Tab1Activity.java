package com.dilloday.jimmy.dilloday.HomeTab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.dilloday.jimmy.dilloday.R;

import java.util.ArrayList;

public class Tab1Activity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<Artist> arrayArtists = new ArrayList<Artist>();

        Artist artist1 = new Artist("SCHOOLBOY Q", "9:15 PM", R.drawable.schoolboyq_background);
        Artist artist2 = new Artist("CASHMERE CAT", "7:45 PM", R.drawable.cashmere_background);
        Artist artist3 = new Artist("DIAL UP", "6:45 PM", R.drawable.dialup_background);
        Artist artist4 = new Artist("HAYDEN JAMES", "5:15 PM", R.drawable.cashmere_background);
        Artist artist5 = new Artist("ANDERSON .PAAK", "3:30 PM", R.drawable.anderson_background);
        Artist artist6 = new Artist("THE MOWGLI'S", "2:00 PM", R.drawable.mowglis_background);
        Artist artist7 = new Artist("THE SYNDICATE", "1:00 PM", R.drawable.syndicate_background);

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
