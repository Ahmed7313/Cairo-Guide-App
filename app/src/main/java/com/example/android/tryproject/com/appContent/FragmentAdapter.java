package com.example.android.tryproject.com.appContent;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.tryproject.R;

public class FragmentAdapter extends FragmentPagerAdapter {

    Context mContext;

    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
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
        if (position == 0) {
            return mContext.getString(R.string.things_to_do);
        } else if (position == 1) {
            return mContext.getString(R.string.Paranoiacs);
        } else if (position == 2) {
            return mContext.getString(R.string.Food);
        } else {
            return mContext.getString(R.string.Mosques);
        }
    }
}
