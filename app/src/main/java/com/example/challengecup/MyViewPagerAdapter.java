package com.example.challengecup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by cnrobin on 17-10-17.
 * Just Enjoy It!!!
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> fragments;

    public MyViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}
