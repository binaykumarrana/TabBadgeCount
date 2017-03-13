package com.cc.tabbadgecount.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.cc.tabbadgecount.fragments.FragmentFive;
import com.cc.tabbadgecount.fragments.FragmentFour;
import com.cc.tabbadgecount.fragments.FragmentOne;
import com.cc.tabbadgecount.fragments.FragmentThree;
import com.cc.tabbadgecount.fragments.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Binay on 13/03/17.
 */

public class HomeTabAdapter extends BaseViewPagerFragmentStatAdapter{
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    int pos = 0;

    public HomeTabAdapter(FragmentManager manager) {
        super(manager);
    }



    @Override
    public Fragment getFragmentItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();

            case 2:
                return new FragmentThree();

            case 3:
                return new FragmentFour();
            case 4:
                return new FragmentFive();

            default:
                return null;
        }
    }

    @Override
    public void updateFragmentItem(int position, Fragment fragment) {

    }


    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}