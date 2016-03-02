package com.koudle.navigationbarexample;

import android.content.Context;
import android.util.AttributeSet;

import com.koudle.navigationbar.TabBarView;
import com.koudle.navigationbar.TabItem;
import com.koudle.navigationbar.TabItemView;

import java.util.ArrayList;

/**
 * Created by koudel on 16/2/26.
 */
public class MyTabBarView extends TabBarView {


    public MyTabBarView(Context context) {
        super(context);
    }

    public MyTabBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTabBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public ArrayList<TabItem> getTabItemList() {
        TabItem item0 = new TabItem(0,true,null,
                new MyTabBarNormalData(R.string.homepage_content,R.color.navitem_content_default_color,R.drawable.ss_xp_icon_home_normal),
                new MyTabBarPressedData(R.color.navitem_content_pressed_color,R.drawable.ss_xp_icon_home_press));
        TabItem item1 = new TabItem(1,false,null,
                new MyTabBarNormalData(R.string.homepage_content,R.color.navitem_content_default_color,R.drawable.ss_xp_icon_home_normal),
                new MyTabBarPressedData(R.color.navitem_content_pressed_color,R.drawable.ss_xp_icon_home_press));
        TabItem item2 = new TabItem(2,false,null,
                new MyTabBarNormalData(R.string.homepage_content,R.color.navitem_content_default_color,R.drawable.ss_xp_icon_home_normal),
                new MyTabBarPressedData(R.color.navitem_content_pressed_color,R.drawable.ss_xp_icon_home_press));
        TabItem item3 = new TabItem(3,false,null,
                new MyTabBarNormalData(R.string.homepage_content,R.color.navitem_content_default_color,R.drawable.ss_xp_icon_home_normal),
                new MyTabBarPressedData(R.color.navitem_content_pressed_color,R.drawable.ss_xp_icon_home_press));

        ArrayList<TabItem> list = new ArrayList<>();
        list.add(item0);
        list.add(item1);
        list.add(item2);
        list.add(item3);

        return list;
    }

    @Override
    public TabItemView getTabItemView() {
        return new MyTabItemView(getContext());
    }

    @Override
    public void onItemClick(int lastIndex, int curIndex) {

    }
}
