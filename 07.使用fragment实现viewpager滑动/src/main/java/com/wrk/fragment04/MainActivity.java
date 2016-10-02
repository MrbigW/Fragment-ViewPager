package com.wrk.fragment04;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private List<Fragment> mFragments;
    private ViewPager viewpager;
    private MyFragAdapater mAdapater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = (ViewPager) findViewById(R.id.viewpager);

        mFragments = new ArrayList<>();
        mFragments.add(new Fragment01());
        mFragments.add(new Fragment02());
        mFragments.add(new Fragment03());

        // 初始化FragmentPagerAdapter
        mAdapater = new MyFragAdapater(getSupportFragmentManager(), mFragments);


        // 设置适配器
        viewpager.setAdapter(mAdapater);
    }

    class MyFragAdapater extends FragmentPagerAdapter {

        private List<Fragment> mFragmentList;

        public MyFragAdapater(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.mFragmentList = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
