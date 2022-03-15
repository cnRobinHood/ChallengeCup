package com.example.challengecup;

public class StudyAndEducationItem {
    private String title;
    private String content;
    private int imgSource;

    public StudyAndEducationItem(String title, String content, int imgSource) {
        this.title = title;
        this.content = content;
        this.imgSource = imgSource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImgSource() {
        return imgSource;
    }

    public void setImgSource(int imgSource) {
        this.imgSource = imgSource;
    }
}
