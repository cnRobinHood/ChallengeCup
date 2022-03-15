package com.example.challengecup;

public class AskHelpItem {
    private String context;
    private int sourceImg;

    public AskHelpItem(String context, int sourceImg) {
        this.context = context;
        this.sourceImg = sourceImg;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getSourceImg() {
        return sourceImg;
    }

    public void setSourceImg(int sourceImg) {
        this.sourceImg = sourceImg;
    }
}
