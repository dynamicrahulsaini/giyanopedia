package com.example.giyanopedia;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {

    private final static String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {}

    public static List<Article> fetchArticleList() {
        Document document = null;
        try{
            document = Jsoup.connect("https://giyanopedia.in/").get();
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error while connecting to the server", e);
        }

        assert document != null;
        Elements headElements = document.select("h2");
        Elements imageElements = document.select("img");

        int count=0;
        Elements articleElements = new Elements();
        for (Element element: headElements) {
            if (!element.hasClass("post-content entry-title")) {
                count++;
                articleElements.add(element);
            }
        }

        List<Article> articles = new ArrayList<>();
        Element element;
        String url;
        for (int i=0; i<count; i++) {
            url = imageElements.get(i).attr("src");
            element = articleElements.get(i).select("a").first();
            assert element != null;
            articles.add(new Article(element.text(), element.attr("href"), getBitmapFromUrl(url)));
        }
        return articles;
    }

    public static ArticleBody fetchArticleBody(Article article) {
        Document document = null;
        try{
            document = Jsoup.connect(article.getArticleUrl()).get();
        } catch (IOException e) {
            System.out.print(e.toString());
        }

        assert document != null;
        Elements bodyContent = document.select("div");

        Element articleElement = null;
        for (Element element: bodyContent) {
            if (element.hasClass("entry-content")) {
                articleElement = element;
                break;
            }
        }

        ArticleBody articleBody = new ArticleBody(article);

        assert articleElement != null;
        Elements content = articleElement.select("p");
        articleBody.setBlockquote(articleElement.select("blockquote").text());

        for (Element element: content) {
            articleBody.articleBody.add(element.text());
        }

        return articleBody;
    }

    private static URL createURL(String s) {
        URL url = null;
        if (s == null) {
            return null;
        }

        try {
            url = new URL(s);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Error while creating URL", e);
        }
        return url;
    }

    private static Bitmap getBitmapFromUrl(String url) {
        URL posterUrl = createURL(url);
        Bitmap poster = null;
        try {
            InputStream stream = posterUrl.openStream();
            poster = BitmapFactory.decodeStream(stream);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error in getting poster", e);
        }
        return poster;
    }

}
