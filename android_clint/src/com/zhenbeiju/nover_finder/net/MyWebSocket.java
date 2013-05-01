package com.zhenbeiju.nover_finder.net;

import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;

import com.zhenbeiju.nover_finder.net.help.JsonParseHelp;
import com.zhenbeiju.nover_finder.service.MyHandler;
import com.zhenbeiju.nover_finder.util.LogManager;

public class MyWebSocket {
    private SocketIO socket = null;
    private MyHandler myHandler;

    public SocketIO connect() {
        LogManager.e("connect");
        try {
            socket = new SocketIO("http://192.168.1.191:18080");

        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        LogManager.e("start connect");
        IOCallback mio = new IOCallback() {
            @Override
            public void onMessage(JSONObject json, IOAcknowledge ack) {
                try {
                    LogManager.e(json.toString());
                    System.out.println(json.toString(2));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMessage(String data, IOAcknowledge ack) {

                // LogManager.e(data);
                // System.out.println("Server said: " + data);
            }

            @Override
            public void onError(SocketIOException socketIOException) {
                System.out.println("an Error occured");
                socketIOException.printStackTrace();
            }

            @Override
            public void onDisconnect() {
                System.out.println("Connection terminated.");
            }

            @Override
            public void onConnect() {
                System.out.println("Connection established");

            }

            @Override
            public void on(String event, IOAcknowledge ack, Object... args) {
                System.out.println("Server triggered event '" + event + "'");
                if (event.equals("message")) {
                    socket.emit("index");
                }

                for (Object o : args) {
                    String value = o.toString();
                    JsonParseHelp.parserBookInfo(value);
                    if (myHandler != null) {
                        myHandler.sendEmptyMessage(0);
                    }

                }

                LogManager.e(event);

            }
        };
        socket.connect(mio);
        IOConnection mcon = IOConnection.register("http://192.168.1.191:18080", socket);
        return socket;
    }

    public void setHandler(MyHandler handler) {

    }

}
