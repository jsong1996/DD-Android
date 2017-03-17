package com.dilloday.jimmy.dilloday.HomeTab;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dilloday.jimmy.dilloday.Classes.Notification;
import com.dilloday.jimmy.dilloday.Classes.dbArtist;
import com.dilloday.jimmy.dilloday.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Tab3Activity extends Fragment {

    public static List<String> alert = new ArrayList<String>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference notificationsRef= database.getReference("Notifications/");
        notificationsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String prevChildKey) {
                String notification = dataSnapshot.getValue(String.class);
                System.out.println("Notification Body: " + notification);
                if (!alert.contains(notification)){
                    //System.out.println("Reaches Here");
                    alert.add(notification);
                }
                //System.out.println(alert);
                }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String prevChildKey) {
                Notification n = dataSnapshot.getValue(Notification.class);
                //System.out.println("The updated post title is: " + changedPost.Name);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                String notification = dataSnapshot.getValue(String.class);
                if (alert.contains(notification)){
                    alert.remove(notification);
                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String prevChildKey) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });
        //System.out.println(alert);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.fragment_notifications, R.id.txt_notification, alert);
        ListView listview = (ListView) rootView.findViewById(R.id.alert_listView);
        listview.setAdapter(adapter);

        return rootView;
    }



}
