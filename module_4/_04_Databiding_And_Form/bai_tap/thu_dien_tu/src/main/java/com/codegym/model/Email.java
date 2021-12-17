package com.codegym.model;

public class Email {

    private String language;
    private String paperSize;
    private boolean spamFilter;
//    private String spamFilter;
    private String signature;

    public Email() {
    }

//    public Email(String language, String paperSize, String spamFilter, String signature) {
//        this.language = language;
//        this.paperSize = paperSize;
//        this.spamFilter = spamFilter;
//        this.signature = signature;
//    }


    public Email(String language, String paperSize, boolean spamFilter, String signature) {
        this.language = language;
        this.paperSize = paperSize;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(String paperSize) {
        this.paperSize = paperSize;
    }

//    public String getSpamFilter() {
//        return spamFilter;
//    }
//
//    public void setSpamFilter(String spamFilter) {
//        this.spamFilter = spamFilter;
//    }


    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
