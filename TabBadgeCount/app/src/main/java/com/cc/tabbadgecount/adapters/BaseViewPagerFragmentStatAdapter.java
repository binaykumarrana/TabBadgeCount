package com.cc.tabbadgecount.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.WeakHashMap;

/**
 * Created by Binay on 13/03/17.
 */

public abstract class BaseViewPagerFragmentStatAdapter extends FragmentStatePagerAdapter {
    private WeakHashMap<Integer, Fragment> mFragments;


    public WeakHashMap<Integer, Fragment> getFragmentList() {
        return mFragments;
    }

    public BaseViewPagerFragmentStatAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new WeakHashMap<Integer, Fragment>();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment item = getFragmentItem(position);
        mFragments.put(Integer.valueOf(position), item);
        return item;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
        Integer key = Integer.valueOf(position);
        if (mFragments.containsKey(key)) {
            mFragments.remove(key);
        }
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();

    }

    @Override
    public int getItemPosition(Object object) {
        //If the object is a fragment, check to see if we have it in the hashmap
        if (object instanceof Fragment) {
            int position = findFragmentPositionHashMap((Fragment) object);
            //If fragment found in the hashmap check if it should be shown
            if (position >= 0) {
                //Return POSITION_NONE if it shouldn't be display
                return (position >= getCount() ? POSITION_NONE : position);
            }
        }

        return super.getItemPosition(object);
    }

    /**
     * Find the location of a fragment in the hashmap if it being view
     *
     * @param object the Fragment we want to check for
     * @return the position if found else -1
     */
    protected int findFragmentPositionHashMap(Fragment object) {
        for (Integer position : mFragments.keySet()) {
            if (position != null &&
                    mFragments.get(position) != null &&
                    mFragments.get(position) == object) {
                return position;
            }
        }

        return -1;
    }

    public abstract Fragment getFragmentItem(int position);
    public abstract void updateFragmentItem(int position, Fragment fragment);

}