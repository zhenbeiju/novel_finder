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
import android.widget.TextView;

public class BookIndexActivity extends Activity {
    private ViewPager mViewPager;
    public List<ChapterInfo> mChapterInfos = new ArrayList<ChapterInfo>();
    public View mChapterView;
    public View mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_page);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

    }

}
