package com.koudle.navigationbar;

/**
 * Created by koudel on 16/2/26.
 */
public class TabItemClickEvent {

    public int curIndex;
    public String className;

    public TabItemClickEvent(int curIndex,String name){
        this.curIndex = curIndex;
        this.className = name;
    }
}
