package com.cc.tabbadgecount.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cc.tabbadgecount.R;
import com.cc.tabbadgecount.adapters.HomeTabAdapter;
import com.cc.tabbadgecount.fragments.FragmentFive;
import com.cc.tabbadgecount.fragments.FragmentFour;
import com.cc.tabbadgecount.fragments.FragmentOne;
import com.cc.tabbadgecount.fragments.FragmentThree;
import com.cc.tabbadgecount.fragments.FragmentTwo;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.toolbar)
    Toolbar toolbar;
    @InjectView(R.id.tabsHomePage)
    TabLayout tabsHomePage;
    @InjectView(R.id.viewpagerTabCount)
    ViewPager viewpagerTabCount;
    @InjectView(R.id.activity_main)
    RelativeLayout activityMain;
    HomeTabAdapter mHomeTabAdapter;
    String[] tabTitle = new String[]{"FRAGONE", "FRAGTWO", "FRAGTHREE", "FRAGFOUR", "FRAGFIVE"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        setupViewPager(viewpagerTabCount);
        tabsHomePage.setupWithViewPager(viewpagerTabCount);

        //TODO setting up tab with badges
        setUpTabBadges();
    }

    //TODO setting up viewpager and number of tabs
    private void setupViewPager(ViewPager viewPager) {
        Fragment mFragmentOne, mFragmentTwo, mFragmentThree, mFragmentFour, mFragmentFive;
        mHomeTabAdapter = new HomeTabAdapter(getSupportFragmentManager());
        mFragmentOne = FragmentOne.getInstance();
        mFragmentTwo = FragmentTwo.getInstance();
        mFragmentThree = FragmentThree.getInstance();
        mFragmentFour = FragmentFour.getInstance();
        mFragmentFive = FragmentFive.getInstance();
        mHomeTabAdapter.addFragment(mFragmentOne, "FRAGONE");
        mHomeTabAdapter.addFragment(mFragmentTwo, "FRAGTWO");
        mHomeTabAdapter.addFragment(mFragmentThree, "FRAGTHREE");
        mHomeTabAdapter.addFragment(mFragmentFour, "FRAGFOUR");
        mHomeTabAdapter.addFragment(mFragmentFive, "FRAGFIVE");
        viewPager.setAdapter(mHomeTabAdapter);
    }

    private void setUpTabBadges() {
        // Iterate over all tabs and set the custom view
        for (int i = 0; i < tabsHomePage.getTabCount(); i++) {
            TabLayout.Tab tab = tabsHomePage.getTabAt(i);
            tab.setCustomView(getTabView(i));
        }


    }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/layout_custom_tab_badge.xml` with a TextView
        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_custom_tab_badge, null);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.badgeLayout);
        TextView tv = (TextView) view.findViewById(R.id.tabTextView);
        TextView badgeCountTextView = (TextView) view.findViewById(R.id.badgeCountTextView);
        tv.setText(tabTitle[position]);
        //You can display badge count in badgeCountTextView based on position of tab
        return view;
    }
}
