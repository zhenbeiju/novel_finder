package com.zhenbeiju.nover_finder.fragment;

import java.util.ArrayList;
import java.util.List;

import com.zhenbeiju.nover_finder.R;
import com.zhenbeiju.nover_finder.util.BookInfo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ResponsFragment extends Fragment{
private ListView mListView;
private List<BookInfo> mbookInfos = new ArrayList<BookInfo>();

@Override
public void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    BookInfo bookInfo = new BookInfo();
    bookInfo.BookName = "jiangye";
    bookInfo.BookWriter = "maoni";
    bookInfo.CurrentChapter = "shenlaizhibi";
    mbookInfos.add(bookInfo);
    mbookInfos.add(bookInfo);
}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    View v = inflater.inflate(R.layout.book_layout, null);
    mListView = (ListView) v.findViewById(R.id.booklist);
    mListView.setAdapter(new myAdapter(getActivity()));
    mListView.setOnItemClickListener(new OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // TODO Auto-generated method stub

        }
    });
    return v;
}

@Override
public void onDestroy() {
    // TODO Auto-generated method stub
    super.onDestroy();
}

@Override
public void onResume() {
    // TODO Auto-generated method stub
    super.onResume();
}

private class ViewHolder {
    private TextView mTVTitle;
    private TextView mTVWiter;
    private TextView mTVChapter;
}

private class myAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    private myAdapter(Context context) {
        mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mbookInfos.size();
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
            _viewHolder.mTVWiter = (TextView) convertView.findViewById(R.id.book_writer_name);
            convertView.setTag(_viewHolder);
        } else {

            _viewHolder = (ViewHolder) convertView.getTag();
        }

        _viewHolder.mTVChapter.setText(mbookInfos.get(position).CurrentChapter);
        _viewHolder.mTVTitle.setText(mbookInfos.get(position).BookName);
        _viewHolder.mTVWiter.setText(mbookInfos.get(position).BookWriter);

        return convertView;
    }

}

}
