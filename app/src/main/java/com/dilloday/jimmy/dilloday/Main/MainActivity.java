package com.dilloday.jimmy.dilloday.Main;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.dilloday.jimmy.dilloday.Adapters.PagerAdapter;
import com.dilloday.jimmy.dilloday.HomeTab.MapsActivity;
import com.dilloday.jimmy.dilloday.HomeTab.Tab1Activity;
import com.dilloday.jimmy.dilloday.R;


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

                if (tab.getPosition() != 1) {
                    viewPager.setCurrentItem(tab.getPosition());
                }
                else {
                    Intent newActivity = new Intent(MainActivity.this, MapsActivity.class);
                    startActivity(newActivity);
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

