package com.zhenbeiju.nover_finder.util;

public class ChapterInfo {
    public ChapterInfo() {

    }

    public ChapterInfo(String cname, String lupdate, String textnnumber, String chaptercontent) {
        ChapterName = cname;
        LastUpDate = lupdate;
        TextNumber = textnnumber;
        ChapterContent = chaptercontent;
    }

    public String ChapterName;
    public String LastUpDate;
    public String TextNumber;
    public String ChapterContent;
}
