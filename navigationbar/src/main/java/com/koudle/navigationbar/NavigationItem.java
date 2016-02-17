package com.koudle.navigationbar;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by koudel on 16/2/17.
 */
public class NavigationItem {

    private int which;
    private boolean isPressed;
    private int contentResID;
    private int contentDefaultColorResID;
    private int contentPressedColorResID;
    private int iconDefaultResID;
    private int iconPressedResID;
    private String itemTag;
    private Fragment theFragment;
    private NavigationItemView navigationItemView;
    public static int sCurTabIndex;
    public Class clazz;
    public static Activity sActivity;
    public static int sContainerid = -1;
    public static List<NavigationItem> sItemList = new ArrayList<>();

    public NavigationItem(int which, boolean isPressed, int contentResID, int contentDefaultColorResID, int ContentPressedColorResID,
                   int iconDefaultResID, int iconPressedResID,
                   String itemTag, Class clazz){
        this.which = which;
        this.isPressed = isPressed;
        this.contentResID = contentResID;
        this.contentDefaultColorResID = contentDefaultColorResID;
        this.contentPressedColorResID = contentDefaultColorResID;
        this.iconDefaultResID = iconDefaultResID;
        this.iconPressedResID = iconPressedResID;
        this.itemTag =itemTag;
        this.clazz = clazz;

        //
        //init(clazz);
    }

    public static void addItem(NavigationItem item){
        if(item != null){
            sItemList.add(item);
        }
    }

    public static NavigationItem getIndex(int index){
        if(index < NavigationItem.sItemList.size()){
            return NavigationItem.sItemList.get(index);
        }
        return null;
    }

    public static void init(Activity activity,int id){
        sActivity = activity;
        sContainerid = id;
        for( NavigationItem item:NavigationItem.sItemList){
            item.initFragment();
            item.initView(activity);
        }
    }

    public static void destroy(){
        for(NavigationItem item:NavigationItem.sItemList){
            item.destroyFragment();
            item.destroyView();
        }
    }

    public boolean getIsPressed(){
        return this.isPressed;
    }

    public void setPressedState(boolean state){
        isPressed = state;
        if(state){
            //上次的tab item 恢复状态
            getIndex(sCurTabIndex).getNavigationItemView().setNormalState();

            //本次的tabitem 按下状态
            sCurTabIndex = this.which;
            this.getNavigationItemView().setPressedState();

        }
    }

    public int getWhich(){
        return this.which;
    }

    public int getContentResID(){
        return this.contentResID;
    }

    public int getContentDefaultColorResID(){
        return this.contentDefaultColorResID;
    }

    public int getContentPressedColorResID(){
        return this.contentPressedColorResID;
    }

    public int getIconDefaultResID(){
        return this.iconDefaultResID;
    }

    public int getIconPressedResID(){
        return this.iconPressedResID;
    }

    public String getItemTag(){
        return this.itemTag;
    }

    public NavigationItemView getNavigationItemView(){
        return this.navigationItemView;
    }

    public Fragment getTheFragment(){
        return this.theFragment;
    }

    public void initFragment(){

        try {
            theFragment = (Fragment) clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if(isPressed){
            sCurTabIndex = this.which;
        }
    }

    public void destroyFragment(){
        theFragment = null;
    }

    public void destroyView(){
        navigationItemView = null;
    }

    public void initView(Context context){
        navigationItemView = new NavigationItemView(context,this);
    }

    public void switchTabFragment(int lastTabIndex, int curTabIndex) {

        if(sActivity == null || sContainerid == -1) return;
        NavigationItem last = NavigationItem.getIndex(lastTabIndex);
        NavigationItem current = NavigationItem.getIndex(curTabIndex);



        //如果 navigationitem 为null，退出
        if(last == null || current == null){
            return;
        }

        if (!current.getTheFragment().isAdded()) {
            sActivity.getFragmentManager().beginTransaction().replace(sContainerid, current.getTheFragment()).commit();
        } else {
            sActivity.getFragmentManager().beginTransaction().hide(last.getTheFragment()).
                    show(current.getTheFragment()).commit();
        }
    }
}
