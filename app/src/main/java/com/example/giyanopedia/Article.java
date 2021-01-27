package com.example.giyanopedia;

import android.graphics.Bitmap;

public class Article {

    private String articleName;
    private String articleUrl;
    private Bitmap articleHeadImage;

    public Article(String name, String url,Bitmap image) {
        this.articleName = name;
        this.articleUrl = url;
        this.articleHeadImage = image;
    }

    public Article(Article article) {
        this.articleName = article.articleName;
        this.articleUrl = article.articleUrl;
        this.articleHeadImage = article.articleHeadImage;
    }

    public String getArticleUrl() {
        return articleUrl;
    }
    public String getArticleName() {
        return articleName;
    }
    public Bitmap getArticleHeadImage() {
        return articleHeadImage;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }
    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }
    public void setArticleHeadImage(Bitmap articleHeadImage) {
        this.articleHeadImage = articleHeadImage;
    }
}
