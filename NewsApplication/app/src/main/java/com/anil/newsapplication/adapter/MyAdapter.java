package com.anil.newsapplication.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.anil.newsapplication.fragment.EconomicsFragment;
import com.anil.newsapplication.fragment.PoliticsFragment;
import com.anil.newsapplication.fragment.SportsFragment;

public class MyAdapter extends FragmentPagerAdapter {
    private static final int NUM_ITEMS = 3;

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new EconomicsFragment();
            case 1:
                return new PoliticsFragment();
            case 2:
                return new SportsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Economics";
            case 1:
                return "Politics";
            case 2:
                return "Sports";
            default:
                return null;
        }
    }
}
