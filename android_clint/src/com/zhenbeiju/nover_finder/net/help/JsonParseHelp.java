package com.zhenbeiju.nover_finder.net.help;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.zhenbeiju.nover_finder.util.BookInfo;
import com.zhenbeiju.nover_finder.util.LogManager;

public class JsonParseHelp {

    public static void parserBookInfo(String info) {
        try {
            JSONObject jos = new JSONObject(info);
            JSONArray jsonObjs = jos.getJSONArray("data");
            
            for (int i = 0; i < jsonObjs.length(); i++) {
                JSONObject json = (JSONObject) jsonObjs.opt(i);
                
                LogManager.e(json.getString("key"));
                JSONObject keyjson = json.getJSONObject("value");
                LogManager.e(keyjson.getString("id"));
                LogManager.e(keyjson.getString("count"));

                BookInfo bookInfo = new BookInfo();
                bookInfo.BookName = json.getString("key");
                bookInfo.BookId = keyjson.getString("id");
                bookInfo.CurrentChapter = keyjson.getString("count");
                bookInfo.BookWriter = "暂无";
                ValueList.allBookInfos.add(bookInfo);
                
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
