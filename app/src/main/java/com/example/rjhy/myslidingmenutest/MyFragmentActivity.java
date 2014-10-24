package com.example.rjhy.myslidingmenutest;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;


public class MyFragmentActivity extends SlidingFragmentActivity {
    private ListView listView;
    private FrameLayout frameLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_fragment);
        setBehindContentView(R.layout.activity_list);

        frameLayout = (FrameLayout) findViewById(R.id.content_fragment);

        SlidingMenu slidingMenu = getSlidingMenu();
        slidingMenu.setBehindWidth(400);
        slidingMenu.setMode(SlidingMenu.LEFT);
        slidingMenu.setBehindScrollScale(0.8f);
        slidingMenu.setFadeDegree(0.5f);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        slidingMenu.setFadeEnabled(false);
        setSlidingActionBarEnabled(false);
//        slidingMenu.setBehindCanvasTransformer(new SlidingMenu.CanvasTransformer() {
//            @Override
//            public void transformCanvas(Canvas canvas, float percentOpen) {
//
////                float scale = (float) (percentOpen*0.25 + 0.75);
////                Log.i("MyFragmentActivity", "percentOpen="+percentOpen+";scale="+scale);
////                canvas.scale(scale, scale, canvas.getWidth()/2, canvas.getHeight()/2);
//                frameLayout.animate().alpha(1-percentOpen*(float)0.7).setDuration(0);
//            }
//        });

        listView = (ListView) findViewById(R.id.list_view);
        frameLayout = (FrameLayout) findViewById(R.id.content_fragment);

        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_item, R.id.text);
        for(int i=1; i<=5; i++){
            adapter.add("menu"+i);
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                getSupportFragmentManager().beginTransaction().replace(R.id.content_fragment, new SampleListFragment(i+1)).commit();
                getSlidingMenu().toggle();
            }
        });
    }
}
