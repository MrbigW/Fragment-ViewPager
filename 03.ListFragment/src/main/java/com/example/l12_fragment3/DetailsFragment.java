package com.example.l12_fragment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailsFragment extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.e("TAG","onCreate()");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.e("TAG","onCreateView()");
		TextView tv = new TextView(getActivity());
		//涉及Fragment间的通信
		//获取Fragment中的数据
		Bundle bundle = this.getArguments();
		String data = (String) bundle.get("data");
		tv.setText(data);
		
		return tv;
	}
	
}
