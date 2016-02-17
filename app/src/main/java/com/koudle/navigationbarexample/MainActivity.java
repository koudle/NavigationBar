package com.koudle.navigationbarexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.koudle.navigationbar.NavigationBarView;
import com.koudle.navigationbar.NavigationItem;
import com.koudle.navigationbar.SampleFragment;


public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private NavigationBarView mNavigationBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void init(){

        Log.d(TAG, "init");

        NavigationItem homepageItem = new NavigationItem(0,true, com.koudle.navigationbar.R.string.homepage_content, com.koudle.navigationbar.R.color.navitem_content_default_color, com.koudle.navigationbar.R.color.navitem_content_pressed_color,
                com.koudle.navigationbar.R.drawable.ss_xp_icon_home_normal, com.koudle.navigationbar.R.drawable.ss_xp_icon_home_press,
                SampleFragment.TAG,SampleFragment.class);

        NavigationItem commodityItem = new NavigationItem(1,false, com.koudle.navigationbar.R.string.commodity_content, com.koudle.navigationbar.R.color.navitem_content_default_color, com.koudle.navigationbar.R.color.navitem_content_pressed_color,
                        com.koudle.navigationbar.R.drawable.ss_xp_icon_goods_normal, com.koudle.navigationbar.R.drawable.ss_xp_icon_goods_press,
                        SampleFragment.TAG,SampleFragment.class);

        NavigationItem orderItem = new NavigationItem(2,false, com.koudle.navigationbar.R.string.order_content, com.koudle.navigationbar.R.color.navitem_content_default_color, com.koudle.navigationbar.R.color.navitem_content_pressed_color,
                        com.koudle.navigationbar.R.drawable.ss_xp_icon_orders_normal, com.koudle.navigationbar.R.drawable.ss_xp_icon_orders_press,
                        SampleFragment.TAG,SampleFragment.class);

        NavigationItem messageItem = new NavigationItem(3,false, com.koudle.navigationbar.R.string.message_content, com.koudle.navigationbar.R.color.navitem_content_default_color, com.koudle.navigationbar.R.color.navitem_content_pressed_color,
                        com.koudle.navigationbar.R.drawable.ss_xp_icon_messages_normal, com.koudle.navigationbar.R.drawable.ss_xp_icon_messages_press,
                        SampleFragment.TAG,SampleFragment.class);

        NavigationItem.addItem(homepageItem);
        NavigationItem.addItem(commodityItem);
        NavigationItem.addItem(orderItem);
        NavigationItem.addItem(messageItem);

        mNavigationBarView = (NavigationBarView) findViewById(R.id.navigationBarView);
        mNavigationBarView.init(MainActivity.this,R.id.container);


    }

}
