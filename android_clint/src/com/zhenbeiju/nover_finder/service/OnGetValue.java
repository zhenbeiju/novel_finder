package com.zhenbeiju.nover_finder.service;

public interface OnGetValue {
    public static final int SUCESS = 0;
    public static final int FAIL = -1;
    public static final int PROCESSING = 1;

    public void onGetValue(int status);
}
