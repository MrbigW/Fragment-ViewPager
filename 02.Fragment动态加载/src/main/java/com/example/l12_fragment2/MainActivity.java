package com.example.l12_fragment2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
/**
 * @author shkstart
 * 测试使用Fragment(动态使用)
 * 1. 使用FragmentManager和FragmentTransaction动态使用一个Fragment
 * 2. 方式:
 * 		add(viewId, fragment): 将fragment的视图添加为指定视图的子视图(加在原有子视图的后面)
 * 		replace(viewId, fragment): 将fragment的视图添加为指定视图的子视图(先remove原有的子视图)
 *      remove(fragment) : 将fragment的视图移除
 * 
 */
public class MainActivity extends FragmentActivity {

	public MainActivity() {
		Log.e("TAG", "MainActivity()..");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e("TAG", "MainActivity onCreate()..");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//创建一个Fragment的对象
		MyFragment1 myFragment1 = new MyFragment1();
		
		//动态的加载MyFragment1
		//得到FragmentManager
		FragmentManager fragmentManager = this.getSupportFragmentManager();
		//得到FragmentTransaction
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		//添加操作
		transaction.add(R.id.ll_main, myFragment1);
		//提交
		transaction.commit();
	}
	private MyFragment2 myFragment2;
	//使用MyFragment2替换现有的MyFragment1
	public void showFragment2(View v) {
	//	if(myFragment2 == null){
			//创建MyFragment2的对象
		myFragment2 = new MyFragment2();
		
		FragmentManager fragmentManager = this.getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		transaction.addToBackStack(null);//将当前的Fragment添加到返回栈中
		
		//替换为某个指定的Fragment
		transaction.replace(R.id.ll_main, myFragment2).commit();//方法链的调用
			
	//	}
		
	}
	//删除现有的Fragment
	public void deleteFragment2(View v) {
		if(myFragment2 != null){
			FragmentManager fragmentManager = this.getSupportFragmentManager();
			FragmentTransaction transaction = fragmentManager.beginTransaction();
			//删除指定的某一个Fragment对象
			transaction.remove(myFragment2).commit();
			
		}
	}
}
