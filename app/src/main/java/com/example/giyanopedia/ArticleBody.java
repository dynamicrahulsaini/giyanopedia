package com.example.giyanopedia;

import java.util.List;

public class ArticleBody extends Article {

    List<String> articleBody;
    String blockquote;

    public ArticleBody(Article article, List<String> body, String quote) {
        super(article);
        this.articleBody = body;
        this.blockquote = quote;
    }

    public ArticleBody(Article article) {
        super(article);
        this.articleBody = null;
        this.blockquote = null;
    }

    public List<String> getArticleBody() {
        return articleBody;
    }
    public String getBlockquote() {
        return blockquote;
    }

    public void setArticleBody(List<String> articleBody) {
        this.articleBody = articleBody;
    }
    public void setBlockquote(String blockquote) {
        this.blockquote = blockquote;
    }
}
