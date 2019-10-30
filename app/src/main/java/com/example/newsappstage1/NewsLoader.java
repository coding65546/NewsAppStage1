package com.example.newsappstage1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Tag for log messages.
     */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /**
     * Query URL.
     */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * Background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        List<News> articles = QueryUtils.fetchNewsData(mUrl);
        return articles;
    }

}
