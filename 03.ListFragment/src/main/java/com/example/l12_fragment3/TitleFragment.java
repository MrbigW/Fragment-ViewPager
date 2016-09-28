package com.example.l12_fragment3;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TitleFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //如果我们继承于ListFragment，则父类的onCreateView()已经帮我们加载了一个ListView。
        //所以，就不需要我们自己再去加载一个ListView的布局
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //使用Adapter将数据装载到ListView中显示
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.item_titlefragment, DataUtils.TITLES));
        //设置ListView为单选模式
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //显示时，默认选中第一项
        getListView().setItemChecked(0, true);
        setData(0);
    }

    //当点击ListView中的item时的回调方法
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        setData(position);

        int h1=l.getHeight();
        int h2=v.getHeight();

        Log.i("h1Height",h1+"");
        Log.i("h2Height",h2+"");

        l.setSelectionFromTop(position,h1/2-h2/2);

    }

    private void setData(int position) {
        //创建DetailsFragment的对象
        DetailsFragment detailsFragment = new DetailsFragment();
        //向DetailsFragment中盛装数据
        Bundle args = new Bundle();//内部封装了一个HashMap<String,Object>
        args.putString("data", DataUtils.DETAILS[position]);
        detailsFragment.setArguments(args);
        Log.e("TAG", "携带数据");

        //动态的加载右边的DetailsFragment
        FragmentManager fragmentManager = this.getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fl_main_container, detailsFragment);
        transaction.commit();//千万不要忘了提交
    }

}
