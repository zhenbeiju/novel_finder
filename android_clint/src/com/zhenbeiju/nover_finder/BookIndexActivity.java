package com.zhenbeiju.nover_finder;

import com.zhenbeiju.nover_finder.util.LogManager;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

public class BookIndexActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_index);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        
        Intent i = this.getIntent();
        String id = i.getStringExtra("bookid");
        
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
}
