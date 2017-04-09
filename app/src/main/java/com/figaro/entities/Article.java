package com.figaro.entities;

/**
 * Created by PC on 08.04.2017.
 */

public class Article {
    private String id;
    private String inernalId;
    private String update;
    private String date;
    private int ranking;
    private String title;
    private String subtitle;
    private Thumb thumb;

    public class Thumb{
        private String link;
        private String md5;

        public Thumb(){

        }

        public String getMd5() {
            return md5;
        }

        public void setMd5(String md5) {
            this.md5 = md5;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }

    Article(){

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public int getRanking() {

        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public Thumb getThumb() {

        return thumb;
    }

    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    public String getInernalId() {

        return inernalId;
    }

    public void setInernalId(String inernalId) {
        this.inernalId = inernalId;
    }

    public String getSubtitle() {

        return subtitle;
    }

    public void setSubtitle(String subTitle) {

        this.subtitle = subTitle;
    }

    public String getId() {

        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
