package com.zhenbeiju.nover_finder.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;

public class RunContext {
    private Context mContext;
    private SharedPreferences mPrefs;
    private Editor mEditor;

    // private static String mVersion;
    // private static boolean isEnableUmeng = true;

    public void onDestory() {
        mContext = null;
        mPrefs = null;
        mEditor = null;

    }

    public static String getUtfString(String src) {
        String ret = src;
        if (src != null && !src.equals("")) {
            try {
                ret = URLEncoder.encode(src, "utf-8");
            } catch (UnsupportedEncodingException e) {
                LogManager.printStackTrace(e);
            }
        }
        return ret;
    }

    public RunContext(RunContext base) {
        this(base.getContext());
    }

    public RunContext(Context context) {
        mContext = context;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPrefs.edit();

    }

    protected PackageManager getPackageManager() {
        // TODO Auto-generated method stub
        return mContext.getPackageManager();
    }

    public Object getSystemService(String name) {
        return mContext.getSystemService(name);
    }

    public void sendBroadcast(Intent intent) {
        mContext.sendBroadcast(intent);

    }

    public void sendOrderedBroadcast(Intent intent) {
        mContext.sendOrderedBroadcast(intent, null);
    }

    public String[] getStringArray(int resId) {
        return mContext.getResources().getStringArray(resId);
    }

    public String getString(int resId) {
        return mContext.getString(resId);
    }

    public Drawable getDrawable(int resId) {
        return mContext.getResources().getDrawable(resId);
    }

    public Context getContext() {
        return mContext;
    }

    // public DataHolder getApplicationContext() {
    // return (DataHolder) mContext.getApplicationContext();
    // }

    public boolean getPrefBoolean(String key) {
        return mPrefs.getBoolean(key, false);
    }

    public boolean getPrefBoolean(String key, boolean defVal) {
        if (mPrefs != null) {
            return mPrefs.getBoolean(key, defVal);
        } else {
            return false;
        }

    }

    public void setPrefBoolean(String key, boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public String getPrefString(String key) {
        return mPrefs.getString(key, null);
    }

    public String getPrefString(String key, String defVal) {
        return mPrefs.getString(key, defVal);
    }

    public void setPrefInteger(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public int getPrefInteger(String key) {
        return mPrefs.getInt(key, 0);
    }

    public int getPrefInteger(String key, int defVal) {
        return mPrefs.getInt(key, defVal);
    }

    public void setPrefString(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public long getPrefLong(String key) {
        return mPrefs.getLong(key, 0L);
    }

    public long getPrefLong(String key, long defVal) {
        return mPrefs.getLong(key, defVal);
    }

    public void setPrefLong(String key, long value) {
        mEditor.putLong(key, value);
        mEditor.commit();
    }

    public float getPrefFloat(String key) {
        return mPrefs.getFloat(key, 0.0F);
    }

    public float getPrefFloat(String key, float defVal) {
        return mPrefs.getFloat(key, defVal);
    }

    public void setPrefFloat(String key, float value) {
        mEditor.putFloat(key, value);
        mEditor.commit();
    }

    public void setGlobalBoolean(String key, boolean value) {
        DataHolder.setGlobalBoolean(key, value);
    }

    public void setGlobalString(String key, String value) {
        DataHolder.setGlobalString(key, value);
    }

    public void setGlobalInteger(String key, Integer value) {
        DataHolder.setGlobalInteger(key, value);
    }

    public void setGlobalLong(String key, Long value) {
        DataHolder.setGlobalLong(key, value);
    }

    public void setGlobalObject(String key, Object value) {
        DataHolder.setGlobalObject(key, value);
    }

    public boolean getGlobalBoolean(String key, boolean defVal) {
        return DataHolder.getGlobalBoolean(key, defVal);
    }

    public String getGlobalString(String key, String defVal) {
        return DataHolder.getGlobalString(key, defVal);
    }

    public int getGlobalInteger(String key, Integer defVal) {
        return DataHolder.getGlobalInteger(key, defVal);
    }

    public long getGlobalLong(String key, Long defVal) {
        return DataHolder.getGlobalLong(key, defVal);
    }

    public Object getGlobalObject(String key, Object defVal) {
        return DataHolder.getGlobalObject(key, defVal);
    }

    public boolean getGlobalBoolean(String key) {
        return DataHolder.getGlobalBoolean(key);
    }

    public String getGlobalString(String key) {
        return DataHolder.getGlobalString(key);
    }

    public int getGlobalInteger(String key) {
        return DataHolder.getGlobalInteger(key);
    }

    public long getGlobalLong(String key) {
        return DataHolder.getGlobalLong(key);
    }

    public Object getGlobalObject(String key) {
        return DataHolder.getGlobalObject(key);
    }
}
