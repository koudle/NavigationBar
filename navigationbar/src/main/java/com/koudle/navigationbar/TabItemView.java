package com.koudle.navigationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by koudel on 16/2/17.
 */
public abstract class TabItemView extends LinearLayout{


    protected TabItem mItem;

    public TabItemView(Context context) {
        super(context,null);
    }

    public TabItemView(Context context, AttributeSet attrs) {
        super(context, attrs,0);
    }

    public TabItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(TabItem item){
        if(null == item) return;

        this.mItem = item;
        initView();
    }


    /**
     * 初始化tab item view操作
     */
    private void initView(){
        this.setOrientation(LinearLayout.VERTICAL);
        this.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1));
        this.setGravity(Gravity.CENTER_HORIZONTAL);

        try {
            LayoutInflater.from(this.getContext()).inflate(getTabItemLayoutResource(),this);
        }catch (Exception e){
            e.printStackTrace();
        }
        //绑定事件
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });

        findView();

        setNormalState();

    }


    public abstract void findView();

    public void click(){
        EventBus.getDefault().post(new TabItemClickEvent(mItem.which));
    }

    public abstract int getTabItemLayoutResource();

    /**
     * pressed state
     */
    public abstract void setPressedState();

    /**
     * normal state
     */
    public abstract void setNormalState();


    public abstract void showNoytification(int count);

    public abstract void displayNotification();

}
