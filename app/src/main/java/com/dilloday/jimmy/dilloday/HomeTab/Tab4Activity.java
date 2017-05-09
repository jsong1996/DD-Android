package com.dilloday.jimmy.dilloday.HomeTab;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.dilloday.jimmy.dilloday.Main.MainActivity;
import com.dilloday.jimmy.dilloday.R;

public class Tab4Activity extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

//        final Button LyftButton = (Button) view.findViewById(R.id.lyft_button);
        final Button nupdButton = (Button) view.findViewById(R.id.nupd_button);
        final Button emergencyButton = (Button) view.findViewById(R.id.emergency_button);
        final Button mayfestButton = (Button) view.findViewById(R.id.mayfest_button);
        final Button shuttleButton = (Button) view.findViewById(R.id.shuttle_button);
        final Button sponsorsButton = (Button) view.findViewById(R.id.sponsors_button);

//        LyftButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View V) {
//                Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage("me.lyft.android");
//                if (launchIntent != null) {
//                    startActivity(launchIntent);
//                }
//                else {
//                    Context context = getContext();
//                    CharSequence text = "Please download Lyft first!";
//                    int duration = Toast.LENGTH_SHORT;
//
//                    Toast toast = Toast.makeText(context, text, duration);
//                    toast.show();
//                }
//            }
//        });
        nupdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String nupd_number = "8474913456";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" +nupd_number));
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //request permission from user if the app hasn't got the required permission
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                            10);
                    return;
                }else {     //have got permission
                    startActivity(intent);  //call activity and make phone call
                }
            }
        });
        emergencyButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                String pd_number = "911";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" +pd_number));
                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    //request permission from user if the app hasn't got the required permission
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                            10);
                    return;
                }else {     //have got permission
                    startActivity(intent);  //call activity and make phone call
                }
            }
        });
        mayfestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"dilloday@gmail.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT   , "Message Body");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    Log.i("Email Sent", "");
                }catch (android.content.ActivityNotFoundException ex){
                    Toast.makeText(getContext(), "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        shuttleButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://northwestern.doublemap.com/map/"));
                startActivity(browserIntent);
            }
        });
        sponsorsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dilloday.com/sponsors"));
                startActivity(browserIntent);
            }
        });

        return view;
    }
}