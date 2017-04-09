package com.figaro.entities;

public class ArticleContent {
    private String id;
    private String inernalId;
    private String categoryId;
    private String content;
    private int date;

    public ArticleContent(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInernalId() {
        return inernalId;
    }

    public void setInernalId(String inernalId) {
        this.inernalId = inernalId;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
