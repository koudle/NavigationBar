package com.koudle.navigationbar;


/**
 * Created by koudel on 16/2/17.
 */
public class TabItem {

    public int which;
    public boolean isPressed;
    public String itemTag;
    public Object normalData;
    public Object pressedData;

    public TabItem(int which, boolean isPressed, String itemTag,Object normal,Object pressed){
        this.which = which;
        this.isPressed = isPressed;
        this.itemTag =itemTag;
        this.normalData = normal;
        this.pressedData = pressed;
    }

}
