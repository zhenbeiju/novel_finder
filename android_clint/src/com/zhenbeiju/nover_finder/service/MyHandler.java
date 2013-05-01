package com.zhenbeiju.nover_finder.service;

import java.util.HashMap;

import android.os.Handler;
import android.os.Message;

public class MyHandler extends Handler {
    private static HashMap<Integer, OnGetValue> mHashMap = new HashMap<Integer, OnGetValue>();

    public static void register(int key, OnGetValue getvalue) {
        mHashMap.put(key, getvalue);
    }

    @Override
    public void dispatchMessage(Message msg) {
        // TODO Auto-generated method stub
        super.dispatchMessage(msg);
        switch (msg.what) {
        case 0:
            OnGetValue getValue = mHashMap.get(msg.what);
            if (getValue != null) {
                getValue.onGetValue(0);
            }
            break;

        default:
            break;
        }
    }
}
