package jp.classmethod.android.sample.viewpager;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * ViewPager をコントロールする機能を追加するサンプル.
 */
public class PagerControlActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_pager_control);

        // カスタム PagerAdapter を生成
        CustomPagerAdapter adapter = new CustomPagerAdapter(this);
        adapter.add(Color.BLACK);
        adapter.add(Color.RED);
        adapter.add(Color.GREEN);
        adapter.add(Color.BLUE);
        adapter.add(Color.CYAN);
        adapter.add(Color.MAGENTA);
        adapter.add(Color.YELLOW);

        // ViewPager を生成
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        
        // 戻るボタン
        findViewById(R.id.preview_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
            }
        });
        // 進むボタン
        findViewById(R.id.next_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        // 追加ボタン
        findViewById(R.id.add_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
                CustomPagerAdapter adapter = (CustomPagerAdapter) viewPager.getAdapter();
                // ランダムに色を追加する
                int R = (int)( Math.random() * 256);
                int G = (int)( Math.random() * 256);
                int B = (int)( Math.random() * 256);
                adapter.add(Color.rgb(R, G, B));
            }
        });
        
    }

}
