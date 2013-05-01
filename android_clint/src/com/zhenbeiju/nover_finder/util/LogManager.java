package com.zhenbeiju.nover_finder.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;

import android.os.Environment;
import android.util.Log;
import android.widget.ListView;

public class LogManager {
    private static final String TAG = "VoiceAssistant";
    private static final String TAG_CALLED = "has be called";
    private static final String TAG_EXCEPTION = "Exception==============";
    private static boolean mIsShowLog = true;
    private static boolean mIsOutToFile = true;
    private static String mPath = "/sdcard/tvboxlog.txt";
    private static String mOprate = "/sdcard/operate.txt";

    private static boolean checkSdCardVaild() {

        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);

    }

    public static void outputToFile(String log) {
        if (log == null || !mIsOutToFile) {
            return;
        }

        if (!checkSdCardVaild()) {
            Log.e(TAG, "No sdcard!");
            return;
        }

        File saveFile = new File(mPath);

        try {
            FileOutputStream outStream = new FileOutputStream(saveFile, true);
            outStream.write((log + "\n").getBytes());
            outStream.close();
        } catch (IOException e) {
            printStackTrace(e, "LogManager", "OutputToFile");
        }
    }

    public static void o(String code) {
        if (!checkSdCardVaild()) {
            Log.e(TAG, "No sdcard!");
            return;
        }

        File saveFile = new File(mOprate);

        try {
            FileOutputStream outStream = new FileOutputStream(saveFile, true);
            String date = new Date(System.currentTimeMillis()).toGMTString();
            LogManager.e(date);
            outStream.write((System.currentTimeMillis() + "\t" + date + "\t" + code + "\n").getBytes());
            outStream.close();
        } catch (IOException e) {
            printStackTrace(e, "LogManager", "OutputToFile");
        }
    }

    public static void outputToFile(Exception exc) {
        if (exc == null || !mIsOutToFile) {
            return;
        }
        // Environment.getExternalStorageDirectory();
        StackTraceElement[] stack = exc.getStackTrace();
        outputToFile(exc.toString());
        for (StackTraceElement item : stack) {
            outputToFile(item.toString());
        }
    }

    private static String bulidTag(String objectName, String methodName) {
        return "[" + objectName + "|" + methodName + "]";
    }

    public static void initLogManager(boolean isShowLog, boolean isOutToFile) {
        mIsShowLog = isShowLog;
        mIsOutToFile = isOutToFile;
    }

    public static int getLogFlag() {
        return mIsShowLog ? 1 : 0;
    }

    private static boolean getFlgFromString(String flg) {
        boolean ret = false;
        if (flg != null) {
            if (flg.equals("yes")) {
                ret = true;
            } else {
                ret = false;
            }
        }

        return ret;
    }

    public static void printStackTrace(Exception e, String objectName, String methodName) {

        e(objectName, methodName, TAG_EXCEPTION);
        e(objectName, methodName, e.toString());
        e.printStackTrace();
        outputToFile(e);

    }

    public static void e(String objectName, String methodName) {
        e(objectName, methodName, TAG_CALLED);

    }

    public static void w(String objectName, String methodName) {
        w(objectName, methodName, TAG_CALLED);

    }

    public static void d(String objectName, String methodName) {
        d(objectName, methodName, TAG_CALLED);

    }

    public static void v(String objectName, String methodName) {
        v(objectName, methodName, TAG_CALLED);

    }

    public static void i(String objectName, String methodName) {
        i(objectName, methodName, TAG_CALLED);
    }

    public static void e(String objectName, String methodName, String msg) {
        if (mIsShowLog) {
            String log = bulidTag(objectName, methodName) + msg;
            Log.e(TAG, log);
            outputToFile(log);
        }

    }

    public static void w(String objectName, String methodName, String msg) {
        if (mIsShowLog) {
            String log = bulidTag(objectName, methodName) + msg;
            Log.w(TAG, log);
            outputToFile(log);
        }

    }

    public static void d(String objectName, String methodName, String msg) {

        if (mIsShowLog) {
            String log = bulidTag(objectName, methodName) + msg;
            Log.d(TAG, log);
            outputToFile(log);
        }

    }

    public static void v(String objectName, String methodName, String msg) {
        if (mIsShowLog) {
            String log = bulidTag(objectName, methodName) + msg;
            Log.v(TAG, log);
            outputToFile(log);
        }

    }

    public static void i(String objectName, String methodName, String msg) {
        if (mIsShowLog) {
            String log = bulidTag(objectName, methodName) + msg;
            Log.i(TAG, log);
            outputToFile(log);
        }
    }

    // ID20120515002 liaoyixuan begin

    public static void printStackTrace(Exception e) {
        String objectName = Thread.currentThread().getStackTrace()[3].getFileName();
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();

        e(objectName, methodName, TAG_EXCEPTION);
        e(objectName, methodName, e.toString());
        e.printStackTrace();
        outputToFile(e);

    }

    public static String bulidTag(String msg) {
        String objectName = Thread.currentThread().getStackTrace()[4].getFileName();
        String methodName = Thread.currentThread().getStackTrace()[4].getMethodName();

        return bulidTag(objectName, methodName) + msg;
    }

    // ID20120515002 liaoyixuan end

    /**
     * @Title: e
     * @Description: Print error log information
     * @param: @param msg
     * @return: void
     * @Comment:
     */
    public static void e(String msg) {
        if (mIsShowLog) {
            // ID20120515002 liaoyixuan begin
            String log = bulidTag(msg);
            Log.e(TAG, log);
            outputToFile(log);
            // ID20120515002 liaoyixuan end
        }

    }

    /**
     * @Title: w
     * @Description: Print Warnning log information
     * @param: @param msg
     * @return: void
     * @Comment:
     */
    public static void w(String msg) {
        if (mIsShowLog) {
            // ID20120515002 liaoyixuan begin
            String log = bulidTag(msg);
            Log.w(TAG, log);
            outputToFile(log);
            // ID20120515002 liaoyixuan end
        }
    }

    /**
     * @Title: d
     * @Description: Print debug log information
     * @param: @param msg
     * @return: void
     * @Comment:
     */
    public static void d(String msg) {

        if (mIsShowLog) {
            // ID20120515002 liaoyixuan begin
            String log = bulidTag(msg);
            Log.d(TAG, log);
            outputToFile(log);
            // ID20120515002 liaoyixuan end
        }
    }

    /**
     * @Title: v
     * @Description: Print void log information
     * @param: @param msg
     * @return: void
     * @Comment:
     */
    public static void v(String msg) {
        if (mIsShowLog) {
            // ID20120515002 liaoyixuan begin
            String log = bulidTag(msg);
            Log.v(TAG, log);
            outputToFile(log);
            // ID20120515002 liaoyixuan end
        }
    }

    /**
     * @Title: i
     * @Description: Print info log information
     * @param: @param msg
     * @return: void
     * @Comment:
     */
    public static void i(String msg) {
        if (mIsShowLog) {
            // ID20120515002 liaoyixuan begin
            String log = bulidTag(msg);
            Log.i(TAG, log);
            outputToFile(log);
            // ID20120515002 liaoyixuan end
        }
    }
}
