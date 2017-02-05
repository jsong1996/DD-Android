package com.dilloday.jimmy.dilloday.HomeTab;

import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dilloday.jimmy.dilloday.R;

import java.util.ArrayList;
import java.util.List;

public class Tab3Activity extends Fragment {

    public static List<String> alert = new ArrayList<String>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notifications, container, false);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.fragment_notifications, R.id.notifications_list_textview, alert);
//        ListView listview = (ListView) rootView.findViewById(R.id.alert_listView);
//        listview.setAdapter(adapter);

        return rootView;
    }



}
