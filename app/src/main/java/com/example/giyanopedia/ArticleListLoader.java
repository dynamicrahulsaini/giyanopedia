package com.example.giyanopedia;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class ArticleListLoader extends AsyncTaskLoader<List<Article>> {


    public ArticleListLoader(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<Article> loadInBackground() {
        return QueryUtils.fetchArticleList();
    }
}
