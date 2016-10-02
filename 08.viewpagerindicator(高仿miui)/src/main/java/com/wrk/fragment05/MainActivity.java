package com.wrk.fragment05;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.wrk.fragment05.view.ViewPagerIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends FragmentActivity {

    private ViewPager mViewPager;
    private ViewPagerIndicator mIndicator;

    private List<String> mTitles;

    private List<Fragment> mContents;

    private FragmentPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        initViews();

        initDatas();

        mIndicator.setVisibleTabCount(3);
        mIndicator.setTabItemTitles(mTitles);

        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                // tabWidth*positionOffset + position*tabWidth
                mIndicator.scroll(position, positionOffset);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initDatas() {

        mTitles = Arrays.asList("短信1", "收藏2", "推荐3","短信4", "收藏5", "推荐6","短信7", "收藏8", "推荐9");
        mContents = new ArrayList<Fragment>();

        for (String title : mTitles) {
            VpSimpleFragment vpSimpleFragment = VpSimpleFragment.newInstance(title);
            mContents.add(vpSimpleFragment);
        }

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mContents.get(position);
            }

            @Override
            public int getCount() {
                return mContents.size();
            }
        };

    }

    private void initViews() {

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
        mIndicator = (ViewPagerIndicator) findViewById(R.id.id_indicator);

    }
}
