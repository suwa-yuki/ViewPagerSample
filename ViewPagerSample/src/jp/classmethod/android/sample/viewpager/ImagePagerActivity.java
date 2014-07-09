package jp.classmethod.android.sample.viewpager;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;

/**
 * 画像を使った ViewPager のサンプル.
 */
public class ImagePagerActivity extends FragmentActivity {
    
    /** ViewPager. */
    private ViewPager mPager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // ViewPager をレイアウトにセット
        mPager = new ViewPager(this);
        setContentView(mPager);
        // CursorLoader を呼び出す
        getSupportLoaderManager().initLoader(0, null, callbacks);
    }
    
    /** CursorLoader のコールバック. */
    private LoaderCallbacks<Cursor> callbacks = new LoaderCallbacks<Cursor>() {
        
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            return new CursorLoader(getApplicationContext(), uri, null, null, null, null);
        }
        
        @Override
        public void onLoaderReset(Loader<Cursor> loader) {
        }
        
        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor c) {
            // Cursor から id を取得して PagerAdapter に入れる
            ImagePagerAdapter adapter = new ImagePagerAdapter(ImagePagerActivity.this);
            c.moveToFirst();
            do {
                long id = c.getLong(c.getColumnIndexOrThrow(MediaStore.Images.ImageColumns._ID));
                adapter.add(id);
            } while (c.moveToNext());
            // ViewPager にセット
            mPager.setAdapter(adapter);
        }
        
    };

}
