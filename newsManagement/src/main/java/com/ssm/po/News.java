package com.ssm.po;

import java.util.Date;

public class News {
    private Integer newsId;
    private String title;
    private String contentTitle;
    private String titlePicUrl;
    private String content;
    private String contentAbstract;
    private String keywords;
    private String author;
    private Date publishTime;
    private Integer clicks;
    private String pusblishStatus;
    private Integer categoryId;
    private Integer userId;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    public String getTitlePicUrl() {
        return titlePicUrl;
    }

    public void setTitlePicUrl(String titlePicUrl) {
        this.titlePicUrl = titlePicUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentAbstract() {
        return contentAbstract;
    }

    public void setContentAbstract(String contentAbstract) {
        this.contentAbstract = contentAbstract;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public String getPusblishStatus() {
        return pusblishStatus;
    }

    public void setPusblishStatus(String pusblishStatus) {
        this.pusblishStatus = pusblishStatus;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", contentTitle='" + contentTitle + '\'' +
                ", titlePicUrl='" + titlePicUrl + '\'' +
                ", content='" + content + '\'' +
                ", contentAbstract='" + contentAbstract + '\'' +
                ", keywords='" + keywords + '\'' +
                ", author='" + author + '\'' +
                ", publishTime=" + publishTime +
                ", clicks=" + clicks +
                ", pusblishStatus='" + pusblishStatus + '\'' +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                '}';
    }
}
