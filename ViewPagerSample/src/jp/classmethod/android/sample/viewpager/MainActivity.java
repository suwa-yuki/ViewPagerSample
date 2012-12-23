package jp.classmethod.android.sample.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_main);
        
        findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PagerActivity.class));
            }
        });
        
        findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PagerControlActivity.class));
            }
        });
        
        findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ImagePagerActivity.class));
            }
        });
    }

}
