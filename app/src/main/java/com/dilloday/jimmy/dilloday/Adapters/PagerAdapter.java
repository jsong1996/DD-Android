package com.dilloday.jimmy.dilloday.Adapters;

/**
 * Created by jsonh on 7/18/2016.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.dilloday.jimmy.dilloday.HomeTab.Tab1Activity;
import com.dilloday.jimmy.dilloday.HomeTab.Tab2Activity;
import com.dilloday.jimmy.dilloday.HomeTab.Tab3Activity;
import com.dilloday.jimmy.dilloday.HomeTab.Tab4Activity;


public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Tab1Activity tab1 = new Tab1Activity();
                return tab1;
            case 1:
                Tab2Activity tab2 = new Tab2Activity();
                return tab2;
            case 2:
                Tab3Activity tab3 = new Tab3Activity();
                return tab3;
            case 3:
                Tab4Activity tab4 = new Tab4Activity();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}