package com.dilloday.jimmy.dilloday.Main;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.support.design.widget.TabLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.dilloday.jimmy.dilloday.Adapters.PagerAdapter;
import com.dilloday.jimmy.dilloday.R;
import com.google.firebase.iid.FirebaseInstanceId;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.marker_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.bell_icon));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.question_mark));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter pAdapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int tabPos = tab.getPosition();

                TextView header = (TextView) findViewById(R.id.header_text);
                viewPager.setCurrentItem(tabPos);


                if (tabPos == 0){
                    header.setText("SCHEDULE");
                    String tkn = FirebaseInstanceId.getInstance().getToken();
                    Toast.makeText(MainActivity.this, "Current token ["+tkn+"]",
                            Toast.LENGTH_LONG).show();
                }
                else if (tabPos == 1) {
                    header.setText("MAP");
                }
                else if (tabPos == 2){
                    header.setText("ALERTS");
                }
                else if (tabPos == 3){
                    header.setText("INFO");
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }




        });




    }

}

