package com.example.newsappstage1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class NewsAdapter extends ArrayAdapter<News> {

    /**
     * Constructs a new {@link NewsAdapter}.
     */
    public NewsAdapter(@NonNull Context context, @NonNull List<News> articles) {
        super(context, 0, articles);
    }

    // Return the formatted date string.
    private String formatDate(Date dateObject) {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Returns a list item view that displays news articles at the given position.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if there is an existing list item view (called convertView) that we can reuse.
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        News currentNews = getItem(position);

        String title = null;
        if (currentNews != null) {
            title = currentNews.getTitle();
        }
        TextView titleView = listItemView.findViewById(R.id.title);
        titleView.setText(title);

        // Format Date and return it.
        String dateString = null;
        if (currentNews != null) {
            dateString = currentNews.getDate();
        }
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(String.valueOf(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TextView dateView = listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(date);
        dateView.setText(formattedDate);

        String authorString = null;
        if (currentNews != null) {
            authorString = currentNews.getAuthor();
        }
        if (authorString != null) {
            TextView authorView = listItemView.findViewById(R.id.author);
            authorView.setText(authorString);
        }

        return listItemView;
    }
}
