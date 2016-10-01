package com.wrk.fragment02;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private View mView1, mView2, mView3;
    private ViewPager mViewPager;
    private PagerTabStrip pagertab;

    // view的集合
    private List<View> mViews;

    // title的集合
    private List<String> mTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        pagertab = (PagerTabStrip) findViewById(R.id.pagertab);

        // 更改下划线的样式
        pagertab.setTabIndicatorColorResource(R.color.colorAccent);

        LayoutInflater inflater = getLayoutInflater();
        mView1 = inflater.inflate(R.layout.layout01, null);
        mView2 = inflater.inflate(R.layout.layout02, null);
        mView3 = inflater.inflate(R.layout.layout03, null);

        mViews = new ArrayList<View>();
        mViews.add(mView1);
        mViews.add(mView2);
        mViews.add(mView3);

        mTitles = new ArrayList<String>();
        mTitles.add("胡凡");
        mTitles.add("唐猛");
        mTitles.add("姚凯丽");

        mViewPager.setAdapter(new MyPagerAdapter());
    }

    /**
     * PageAdapter 必须重写的四个函数：
     * boolean isViewFromObject(View arg0, Object arg1)
     * int getCount():返回要滑动的VIew的个数
     * void destroyItem(ViewGroup container, int position,Object object)：从当前container中删除指定位置（position）的View
     * Object instantiateItem(ViewGroup container, int position)：做了两件事，第一：将当前视图添加到container中，第二：返回当前View
     */
    class MyPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(mViews.get(position));

            return mViews.get(position);
        }

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object); // 这句必须删掉
            container.removeView(mViews.get(position));
        }

//        在Tab标题前加了一个图片；
        @Override
        public CharSequence getPageTitle(int position) {
            // SpannableStringBuilder+ImageSpan实现图文结合
            SpannableStringBuilder ssb = new SpannableStringBuilder(" " + mTitles.get(position));

            Drawable mDrawable = getResources().getDrawable(R.mipmap.ic_launcher);
            mDrawable.setBounds(0, 0, mDrawable.getIntrinsicWidth(), mDrawable.getIntrinsicHeight());

            ImageSpan imageSpan = new ImageSpan(mDrawable, ImageSpan.ALIGN_BASELINE);

            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.RED);
            ssb.setSpan(imageSpan, 0, 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);// 设置图标
            ssb.setSpan(foregroundColorSpan,1,ssb.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            ssb.setSpan(new RelativeSizeSpan(1.2f),1,ssb.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            return ssb;
        }
    }

}
