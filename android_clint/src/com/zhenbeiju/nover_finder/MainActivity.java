package com.zhenbeiju.nover_finder;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.zhenbeiju.nover_finder.fragment.BookChapterFragMent;
import com.zhenbeiju.nover_finder.fragment.BooksFragment;
import com.zhenbeiju.nover_finder.fragment.ResponsFragment;
import com.zhenbeiju.nover_finder.fragment.UnReadFragment;
import com.zhenbeiju.nover_finder.service.MyService;
import com.zhenbeiju.nover_finder.util.TabListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startService();
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.setTitle("追小说");
        Tab tab1 = actionBar.newTab().setText("订阅")
                .setTabListener(new TabListener<ResponsFragment>(this, "", ResponsFragment.class));
        Tab tab2 = actionBar.newTab().setText("排行")
                .setTabListener(new TabListener<BooksFragment>(this, "", BooksFragment.class));
        Tab tab3 = actionBar.newTab().setText("未读")
                .setTabListener(new TabListener<BookChapterFragMent>(this, "", BookChapterFragMent.class));
        actionBar.addTab(tab3);
        actionBar.addTab(tab2);
        actionBar.addTab(tab1);

    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void startService() {
        Intent i = new Intent();
        i.setClass(this, MyService.class);
        startService(i);
    }

}
