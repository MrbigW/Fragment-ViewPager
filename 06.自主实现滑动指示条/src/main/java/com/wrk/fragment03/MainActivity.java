package com.wrk.fragment03;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private View mView1, mView2, mView3;
    private ViewPager mViewPager;

    // view的集合
    private List<View> mViews;

    //指示器的属性
    private ImageView cursor;
    private int cursorWid = 0; // 游标宽度
    private int offset = 0; // 动画图片的偏移量
    private int currIndex = 0; //当前页面编号


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // 初始化ViewPager的子view
        initPagerView();

        // 初始化指示器的位置
        initCursorPos();

        mViewPager.setAdapter(new MyPagerAdapter(mViews));
        mViewPager.addOnPageChangeListener(new MyPagerChangeListener());
    }

    private void initPagerView() {
        LayoutInflater inflater = getLayoutInflater();
        mView1 = inflater.inflate(R.layout.layout01, null);
        mView2 = inflater.inflate(R.layout.layout02, null);
        mView3 = inflater.inflate(R.layout.layout03, null);

        mViews = new ArrayList<View>();
        mViews.add(mView1);
        mViews.add(mView2);
        mViews.add(mView3);
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        cursor = (ImageView) findViewById(R.id.cursor);
    }

    private void initCursorPos() {
        // 初始化动画
        cursorWid = BitmapFactory.decodeResource(getResources(), R.drawable.a).getWidth();

        // 获取屏幕宽
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenW = displayMetrics.widthPixels;

        // 计算偏移量
        offset = (screenW / mViews.size() - cursorWid) / 2;

        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        cursor.setImageMatrix(matrix); //设置动画初始位置
    }

    /**
     * PageAdapter 必须重写的四个函数：
     * boolean isViewFromObject(View arg0, Object arg1)
     * int getCount():返回要滑动的VIew的个数
     * void destroyItem(ViewGroup container, int position,Object object)：从当前container中删除指定位置（position）的View
     * Object instantiateItem(ViewGroup container, int position)：做了两件事，第一：将当前视图添加到container中，第二：返回当前View
     */
    class MyPagerAdapter extends PagerAdapter {

        private List<View> mViewList;

        public MyPagerAdapter(List<View> viewList) {
            this.mViewList = viewList;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(mViewList.get(position));

            return mViewList.get(position);
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            super.destroyItem(container, position, object); // 这句必须删掉
            container.removeView(mViewList.get(position));
        }
    }

    class MyPagerChangeListener implements ViewPager.OnPageChangeListener {

        int one = offset * 2 + cursorWid; // 页卡1 -> 页卡2 偏移量
        int two = one * 2; // 页卡1 -> 页卡3 偏移量

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            Animation animation = null;

            switch (position) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, 0, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, 0, 0, 0);
                    }
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, one, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                    }
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(offset, two, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                    }
                    break;
            }

            // 设置当前页面
            currIndex = position;
            animation.setFillAfter(true);
            animation.setDuration(300);
            cursor.startAnimation(animation);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}


































