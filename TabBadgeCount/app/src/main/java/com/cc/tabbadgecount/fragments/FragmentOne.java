package com.cc.tabbadgecount.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cc.tabbadgecount.R;

/**
 * Created by Binay on 13/03/17.
 */

public class FragmentOne extends Fragment {
    private static FragmentOne instance;
    //TODO crating instance of  fragment
    public static FragmentOne getInstance() {

        instance = new FragmentOne();

        return instance;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_frgamnet, container, false);
        return view;
    }
}
