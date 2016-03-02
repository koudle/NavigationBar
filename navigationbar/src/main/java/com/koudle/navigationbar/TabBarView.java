package com.koudle.navigationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by koudel on 16/2/17.
 */
public abstract class TabBarView extends LinearLayout {

    public int mCurTabIndex = -1;
    public int mLastTabIndex = -1;
    private List<TabItemView> tabItemViews = new ArrayList<>();

    public TabBarView(Context context) {
        super(context, null);
        init();
    }

    public TabBarView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init();
    }

    public TabBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        EventBus.getDefault().register(this);

        ArrayList<TabItem> tabItems = getTabItemList();


        if(null == tabItems || tabItems.size() <=0 ) return;

        //生成导航栏的每个item
        for(TabItem item: tabItems){
            LayoutParams layoutParams = new LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT,1);

            TabItemView view = getTabItemView();
            view.init(item);
            tabItemViews.add(view);
            this.addView(view, layoutParams);

            if(item.isPressed){
                view.click();
            }
        }
    }

    public abstract ArrayList<TabItem> getTabItemList();


    public abstract TabItemView getTabItemView();

    @Subscribe(
        threadMode = ThreadMode.MAIN
    )
    public void onItemClick(TabItemClickEvent event){

        if(tabItemViews.size()<=0) return;

        if(mCurTabIndex != event.curIndex && tabItemViews.get(0).getClass().getSimpleName().equals(event.className)){
            if(mCurTabIndex >= 0) {
                tabItemViews.get(mCurTabIndex).setNormalState();
            }
            tabItemViews.get(event.curIndex).setPressedState();
            mLastTabIndex = mCurTabIndex;
            mCurTabIndex = event.curIndex;

            onItemClick(mLastTabIndex,mCurTabIndex);
        }
    }

    public abstract void onItemClick(int lastIndex,int curIndex);
}
