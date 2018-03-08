package com.gech.demo.Model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Article {

    private NewsSource newssource;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urltoImage;
    private String publishedAt;

    public Article() {
    }

    public NewsSource getNewssource() {
        return newssource;
    }

    public void setNewssource(NewsSource newssource) {
        this.newssource = newssource;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrltoImage() {
        return urltoImage;
    }

    public void setUrltoImage(String urltoImage) {
        this.urltoImage = urltoImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
