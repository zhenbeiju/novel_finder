package com.zhenbeiju.nover_finder.service;

import com.zhenbeiju.nover_finder.net.MyWebSocket;
import com.zhenbeiju.nover_finder.net.SocketIO;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    public static SocketIO mSocketIO;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        MyWebSocket mSocket = new MyWebSocket();
        mSocketIO = mSocket.connect();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        return super.onStartCommand(intent, flags, startId);
    }

}
