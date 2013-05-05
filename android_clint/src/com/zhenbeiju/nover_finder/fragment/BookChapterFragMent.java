package com.zhenbeiju.nover_finder.fragment;

import java.util.ArrayList;
import java.util.List;

import com.zhenbeiju.nover_finder.BookIndexActivity;
import com.zhenbeiju.nover_finder.R;
import com.zhenbeiju.nover_finder.ReadActivity;
import com.zhenbeiju.nover_finder.util.ChapterInfo;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BookChapterFragMent extends Fragment {
    private ListView mListView;
    private ChapterAdapter mAdapter;
    private List<ChapterInfo> mChapterInfos = new ArrayList<ChapterInfo>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        mChapterInfos.add(new ChapterInfo("123123", "123123", "12312421", "123234545"));
        mChapterInfos.add(new ChapterInfo("123123", "123123", "12312421", "123234545"));
        mChapterInfos.add(new ChapterInfo("123123", "123123", "12312421", "123234545"));
        mChapterInfos.add(new ChapterInfo("123123", "123123", "12312421", "123234545"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View v = inflater.inflate(R.layout.book_layout, null);
        mListView = (ListView) v.findViewById(R.id.booklist);
        mAdapter = new ChapterAdapter(getActivity());
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub
                Intent i = new Intent();
                i.setClass(BookChapterFragMent.this.getActivity(), ReadActivity.class);
                startActivity(i);
            }
        });
        return v;
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    private class ViewHolder {
        private TextView mTVTitle;
        private TextView mTVauthor;
        private TextView mTVChapter;
    }

    private class ChapterAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater mLayoutInflater;

        private ChapterAdapter(Context context) {
            mContext = context;
            mLayoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return mChapterInfos.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            ViewHolder _viewHolder = null;
            if (convertView == null) {
                _viewHolder = new ViewHolder();
                convertView = mLayoutInflater.inflate(R.layout.book_listitem, null);
                _viewHolder.mTVChapter = (TextView) convertView.findViewById(R.id.book_chaptername);
                _viewHolder.mTVTitle = (TextView) convertView.findViewById(R.id.book_name);
                _viewHolder.mTVauthor = (TextView) convertView.findViewById(R.id.book_writer_name);
                convertView.setTag(_viewHolder);
            } else {
                _viewHolder = (ViewHolder) convertView.getTag();
            }

            _viewHolder.mTVChapter.setText(mChapterInfos.get(position).LastUpDate);
            _viewHolder.mTVTitle.setText(mChapterInfos.get(position).ChapterName);
            _viewHolder.mTVauthor.setText(mChapterInfos.get(position).TextNumber);

            return convertView;
        }
    }
}
