package com.koudle.navigationbar;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by koudel on 16/2/17.
 */
public class NavigationItemView extends LinearLayout implements View.OnClickListener{

    public ImageView mIconView;
    public TextView mTextView;
    public TextView mNotiTextView;
    private NavigationItem mItem;

    public NavigationItemView(Context context,NavigationItem item) {
        super(context);
        this.mItem = item;

        init();
    }

    /**
     * 初始化tab item view操作
     */
    private void init(){
        this.setOrientation(LinearLayout.VERTICAL);
        this.setLayoutParams(new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1));
        this.setGravity(Gravity.CENTER_HORIZONTAL);
        View view = LayoutInflater.from(this.getContext()).inflate(R.layout.ss_navigationitemview,this);
        //绑定事件
        this.setOnClickListener(this);

        // 菜单图片
        mIconView = (ImageView) view.findViewById(R.id.tabitem_icon);
        mIconView.setTag(mItem.getItemTag());
        mIconView.setImageResource(mItem.getIconDefaultResID());

        // 菜单项描述
        mTextView = (TextView) view.findViewById(R.id.tabitem_text);
        mTextView.setTag(mItem.getItemTag());
        mTextView.setTextColor(this.getContext().getResources().getColor(R.color.navitem_content_default_color));
        mTextView.setText(mItem.getContentResID());

        //小红点
        mNotiTextView = (TextView) view.findViewById(R.id.tabitem_notification);



    }


    @Override
    public void onClick(View v) {
        if(NavigationItem.sCurTabIndex != mItem.getWhich()) {
            mItem.switchTabFragment(NavigationItem.sCurTabIndex, mItem.getWhich());

            //状态改变
            mItem.setPressedState(true);
        }
    }

    public void initStatus(){
        mItem.switchTabFragment(NavigationItem.sCurTabIndex, mItem.getWhich());

        //状态改变
        mItem.setPressedState(true);

    }

    /**
     * pressed state
     */
    public void setPressedState() {
        mIconView.setImageResource(mItem.getIconPressedResID());

        mTextView.setTextColor(this.getContext().getResources().getColor(R.color.navitem_content_pressed_color));
    }

    /**
     * normal state
     */
    public void setNormalState() {
        mIconView.setImageResource(mItem.getIconDefaultResID());

        mTextView.setTextColor(this.getContext().getResources().getColor(R.color.navitem_content_default_color));
    }


    public void showNoytification(int count){
        String str = String.valueOf(count);
        if(count>0) {
            if(count > 99)  str = "99+";
            mNotiTextView.setVisibility(View.VISIBLE);
            mNotiTextView.setText(str);
        }
    }

    private void displayNotification(){
        mNotiTextView.setVisibility(View.GONE);
    }

}
