package com.gech.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
import java.util.HashSet;

@JsonIgnoreProperties(ignoreUnknown = true)

public class NewsApi {

     private String status;
     private String totalResults;
     private Collection<Article> article;

    public NewsApi() {
        this.article = new HashSet<>();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public Collection<Article> getArticle() {
        return article;
    }

    public void setArticle(Collection<Article> article) {
        this.article = article;
    }
}
