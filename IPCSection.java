package com.pandeyrahul.lawleaks.DATA;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class IPCSection {
    private int chapter;
    private String chapterTitle;
    private List<IPCItem> sections;

    public IPCSection(int chapter, String chapterTitle, List<IPCItem> sections) {
        this.chapter = chapter;
        this.chapterTitle = chapterTitle;
        this.sections = sections;
    }

    public int getChapter() {
        return chapter;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public List<IPCItem> getSections() {
        return sections;
    }

    // ✅ Handles missing "sections" safely
    public static IPCSection fromJson(JSONObject jsonObject) throws JSONException {
        int chapter = jsonObject.has("chapter") ? jsonObject.getInt("chapter") : 0;
        String chapterTitle = jsonObject.has("chapter_title") ? jsonObject.getString("chapter_title") : "Untitled Chapter";

        List<IPCItem> sectionList = new ArrayList<>();



        return new IPCSection(chapter, chapterTitle, sectionList);
    }
}
