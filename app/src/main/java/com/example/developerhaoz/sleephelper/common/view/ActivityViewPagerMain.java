package com.example.developerhaoz.sleephelper.common.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.developerhaoz.sleephelper.R;

/**
 * Created by Administrator on 2017/10/23.
 */

public class ActivityViewPagerMain extends Activity {


    ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_main);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter());

    }

    /**
     * 自定义类实现PagerAdapter，填充显示数据
     */
    class MyAdapter extends PagerAdapter {

        // 显示多少个页面
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        // 初始化显示的条目对象
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // return super.instantiateItem(container, position);
            // 准备显示的数据，一个简单的TextView
            TextView tv = new TextView(ActivityViewPagerMain.this);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(20);
            tv.setText("我是天才" + position + "号");

            // 添加到ViewPager容器
            container.addView(tv);

            // 返回填充的View对象
            return tv;
        }

        // 销毁条目对象
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
    }

}
