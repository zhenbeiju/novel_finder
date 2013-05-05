package com.zhenbeiju.nover_finder;

import java.util.ArrayList;
import java.util.List;

import com.zhenbeiju.nover_finder.util.ChapterInfo;
import com.zhenbeiju.nover_finder.util.LogManager;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class ReadActivity extends Activity {

    private ViewPager mViewPager;
    public List<ChapterInfo> mChapterInfos = new ArrayList<ChapterInfo>();
    public View mChapterView;
    public View mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.read_layout);
        mViewPager = (ViewPager) findViewById(R.id.viewpager);

    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        // TODO Auto-generated method stub
        return super.onMenuItemSelected(featureId, item);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
        case android.R.id.home:
            finish();
            LogManager.e("Click back");
            break;
        default:
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    public class myAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            super.destroyItem(container, position, object);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

    }
}
