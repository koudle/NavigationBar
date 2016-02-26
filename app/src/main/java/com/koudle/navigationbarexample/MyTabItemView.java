package com.koudle.navigationbarexample;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.koudle.navigationbar.TabItemView;

/**
 * Created by koudel on 16/2/26.
 */
public class MyTabItemView extends TabItemView {

    public ImageView mIconView;
    public TextView mTextView;
    public TextView mNotiTextView;


    public MyTabItemView(Context context) {
        super(context);
    }

    public MyTabItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTabItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void findView() {
        mIconView = (ImageView) findViewById(R.id.tabitem_icon);

        // 菜单项描述
        mTextView =  (TextView) findViewById(R.id.tabitem_text);

        //小红点
        mNotiTextView = (TextView) findViewById(R.id.tabitem_notification);

    }

    @Override
    public int getTabItemLayoutResource() {
        return R.layout.ss_navigationitemview;
    }

    @Override
    public void setPressedState() {
        mTextView.setTextColor(((MyTabBarPressedData)mItem.pressedData).contetnColorID);
        mIconView.setImageResource(((MyTabBarPressedData)mItem.pressedData).iconID);
    }

    @Override
    public void setNormalState() {
        mTextView.setText(((MyTabBarNormalData)mItem.normalData).contentID);
        mTextView.setTextColor(((MyTabBarNormalData)mItem.normalData).contetnColorID);
        mIconView.setImageResource(((MyTabBarNormalData)mItem.normalData).iconID);
    }

    @Override
    public void showNoytification(int count) {

    }

    @Override
    public void displayNotification() {

    }
}
