package com.atsgg.fragmenttest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 那位程序猿Mr.W on 2016/9/27.
 * 微信:1024057635
 * gitHub:MrbigW
 * =.=
 */

public class MyFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View fragView = View.inflate(getActivity(), R.layout.ll_fragment1, null);

        return fragView;
    }
}
