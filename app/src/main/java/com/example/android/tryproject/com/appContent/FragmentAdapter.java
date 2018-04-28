package com.example.android.tryproject.com.appContent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Things To Do", "Paranoiacs", "Food", "Mosques"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new Thing_To_do_Fragment();
        } else if (position == 1) {
            return new Pharaonic_Fragment();
        } else if (position == 2) {
            return new Food_Fragment();

        } else {
            return new MosquesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
