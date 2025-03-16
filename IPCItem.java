package com.pandeyrahul.lawleaks.DATA;

import org.json.JSONException;
import org.json.JSONObject;

public class IPCItem {
    private int chapter;
    private String chapterTitle;
    private String section; // Changed to String
    private String sectionTitle;
    private String sectionDesc;

    public IPCItem(int chapter, String chapterTitle, String section, String sectionTitle, String sectionDesc) {
        this.chapter = chapter;
        this.chapterTitle = chapterTitle;
        this.section = section;
        this.sectionTitle = sectionTitle;
        this.sectionDesc = sectionDesc;
    }

    public int getChapter() { return chapter; }
    public String getChapterTitle() { return chapterTitle; }
    public String getSection() { return section; }
    public String getSectionTitle() { return sectionTitle; }
    public String getSectionDesc() { return sectionDesc; }

    public static IPCItem fromJson(JSONObject jsonObject) throws JSONException {
        int chapter = jsonObject.getInt("chapter");
        String chapterTitle = jsonObject.getString("chapter_title");

        // Get section as a String (handles numbers and text)
        String section = jsonObject.getString("Section");
        String sectionTitle = jsonObject.getString("section_title");
        String sectionDesc = jsonObject.getString("section_desc");

        return new IPCItem(chapter, chapterTitle, section, sectionTitle, sectionDesc);
    }
}