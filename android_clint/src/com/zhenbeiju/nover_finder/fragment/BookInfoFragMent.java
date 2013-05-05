package com.zhenbeiju.nover_finder.fragment;

import com.zhenbeiju.nover_finder.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BookInfoFragMent extends Fragment {
    private ImageView mImageView;
    private TextView mBookTitle;
    private TextView mBookAuthor;
    private Button mIsRegistBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v = inflater.inflate(R.layout.book_index, container);
        mImageView = (ImageView) v.findViewById(R.id.bookindex_image);
        mBookTitle = (TextView) v.findViewById(R.id.bookindex_bookname);
        mBookAuthor = (TextView) v.findViewById(R.id.bookindex_author);
        mIsRegistBtn = (Button) v.findViewById(R.id.bookindex_regist);
        return v;
    }

    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

}
