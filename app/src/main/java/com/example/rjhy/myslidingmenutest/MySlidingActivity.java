package com.example.rjhy.myslidingmenutest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;


public class MySlidingActivity extends SlidingActivity {
    private ListView listView;
    private TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        setBehindContentView(R.layout.activity_list);

        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setBehindWidth(400);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setFadeDegree(0.5f);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

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
                getSlidingMenu().toggle();
            }
        });
    }
}
