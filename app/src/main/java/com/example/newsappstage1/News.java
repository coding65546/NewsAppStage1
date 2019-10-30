package com.example.newsappstage1;

public class News {

    /** Title of the article */
    private String mTitle;

    /** Date of the article */
    private String mDate;

    /** Article URL */
    private String mUrl;

    /** Author of the article */
    private String mAuthor;

    /** Constructs a new {@link News} object. */
    News(String titile, String date, String url, String author) {
        mDate = date;
        mTitle = titile;
        mUrl = url;
        mAuthor = author;
    }


    /**
     * Returns the title of the article.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the date of the article.
     */
    public String getDate() {
        return mDate;
    }

    /**
     * Returns the URL of the article.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the author of the article.
     */
    public String getAuthor() {
        return mAuthor;
    }

}