package com.atsgg.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * 测试使用Fragment(静态加载)
 * 1. 定义Fragment的子类，并加载布局文件:onCreateView()
 * 2. 在布局文件中通过<fragment>指定自定义Fragment
 * 3. 我们的Activity必须继承与FragmentActivity
 *
 *
 */

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
