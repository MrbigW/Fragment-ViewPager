package com.example.l12_fragment2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/*
 * 测试Fragment的生命周期（）
 * 1.声明周期的状态：4种：运行，暂停，停止，死亡
 * 2.生命周期方法（11个方法）
 * 3.测试用例：
 * 添加Fragment对象显示
 * 构造器-onAttch() - onCreate() - onCreateView() - onActivityCreated() - onStart() - onResume()
 * home到桌面
 * onPause() - onStop()
 * 回到应用
 * onStart() - onResume()
 * replace为其它Fragment   （将现有的Fragment添加到了返回栈）
 * onPause() - onStop() - onDestoryView()
 * 返回到本身的Fragment
 * onCreateView() - onActivityCreated() - onStart() - onResume()
 * 退出应用
 * onPause() - onStop() - onDestoryView() - onDestory() - onDetach()
 * 
 * 测试：如果没有添加到返回栈的操作，那么执行“replace为其它Fragment”，生命周期方法又会如何？
 * 
 * 关注于：onCreateView():通过此方法，返回一个Fragment加载的布局对应的视图对象。
 *       onActivityCreated():如果需要操作Fragment加载的布局中的视图对象的话，就使用此方法
 * 
 */
public class MyFragment1 extends Fragment {
	
	public MyFragment1() {
		Log.e("TAG", "MyFragment1()");
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.e("TAG", "onAttach()");
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.e("TAG", "onCreate()");
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		TextView tv = new TextView(getActivity());
		tv.setText("MyFragment1111");
		Log.e("TAG", "onCreateView()");
		return tv;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.e("TAG", "onActivityCreated()");
	}
	
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onStart()");
		super.onStart();
	}
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onResume()");
		super.onResume();
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onPause()");
		super.onPause();
	}
	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onStop()");
		super.onStop();
	}
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onDestroyView()");
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onDestroy()");
		super.onDestroy();
	}
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		Log.e("TAG", "onDetach()");
		super.onDetach();
	}
	
	
	
	
	
}
