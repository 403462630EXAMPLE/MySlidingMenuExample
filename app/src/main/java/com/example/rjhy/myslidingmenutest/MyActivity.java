package com.example.rjhy.myslidingmenutest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class MyActivity extends Activity {
    private ListView listView;
    private TextView textView;
    private SlidingMenu slidingMenu;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my);
//        final SlidingMenu slidingMenu = new SlidingMenu(this);
//        slidingMenu.setBehindWidth(400);
//        slidingMenu.setMode(SlidingMenu.LEFT);
//        slidingMenu.setMenu(R.layout.activity_list);
//        slidingMenu.setFadeDegree(0.5f);
//        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
//        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        setContentView(R.layout.sliding_menu);
        slidingMenu = (SlidingMenu) findViewById(R.id.slidingmenulayout);

        textView = (TextView) findViewById(R.id.content);
        listView = (ListView) findViewById(R.id.list_view);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_item, R.id.text);
        for(int i=1; i<=5; i++){
            adapter.add("menu"+i);
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText("content"+(i+1));
                slidingMenu.toggle();
            }
        });
    }
}
