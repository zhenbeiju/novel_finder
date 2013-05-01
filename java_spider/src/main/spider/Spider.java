package main.spider;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.LogManager;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class Spider {

    public static String URL = "www.booksky.me";
    private boolean mCanRun = true;

    public void start() {
        mCanRun = true;
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (mCanRun) {
                    ScanBooks();
                    try {
                        Thread.sleep(60000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void ScanBooks() {
        try {
            Document doc = Jsoup.connect(URL).get();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void ScanChapter() {

    }

    public void stop() {
        // do smth .. exp. save values and so on
        mCanRun = false;

    }

}
