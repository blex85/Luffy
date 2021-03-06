package com.xishuang.plugintest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xishuang.plugintest.dummy.DummyContent;
import com.xishuang.plugintest.fragment.ItemFragment;
import com.xishuang.plugintest.fragment.ListItemFragment;

public class TabActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    ViewPager mViewPager;

    Fragment mFragment1;

    Fragment mFragment2;

    Fragment mFragment3;

    PagerAdapter mPagerAdapter;

    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initView(savedInstanceState);
    }


    private void initView(Bundle savedInstanceState) {

        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(2);
        mTabLayout = (TabLayout) findViewById(R.id.toolbar_tab);

        if (savedInstanceState == null) {
            mFragment1 = ItemFragment.newInstance("RecycleView1");
            mFragment2 = ItemFragment.newInstance("RecycleView2");
            mFragment3 = ListItemFragment.newInstance("ListView");
        }

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return mFragment1;
            } else if (position == 1) {
                return mFragment2;
            } else if (position == 2) {
                return mFragment3;
            }

            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

    }
}
