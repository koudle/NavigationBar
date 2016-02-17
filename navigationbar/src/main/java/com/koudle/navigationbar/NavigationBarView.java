package com.koudle.navigationbar;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

/**
 * Created by koudel on 16/2/17.
 */
public class NavigationBarView extends LinearLayout {
    public NavigationBarView(Context context) {
        super(context);
    }

    public NavigationBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NavigationBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void init(Activity activity,int id){
        this.setOrientation(LinearLayout.HORIZONTAL);

        //初始化
        NavigationItem.init(activity,id);

        // 获取屏幕的长度,计算每个菜单项的长度
        DisplayMetrics dm = this.getResources().getDisplayMetrics();
        int eachIndicatorWidth = dm.widthPixels/ NavigationItem.sItemList.size();


        //生成导航栏的每个item
        for(NavigationItem item: NavigationItem.sItemList){

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    eachIndicatorWidth, LinearLayout.LayoutParams.MATCH_PARENT);
            this.addView(item.getNavigationItemView(), layoutParams);

            if(item.getIsPressed()) item.getNavigationItemView().initStatus();
        }
    }
}
