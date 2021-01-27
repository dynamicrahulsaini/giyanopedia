package com.example.giyanopedia;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.zip.Inflater;

public class ArticleAdapter extends ArrayAdapter<Article> {
    public ArticleAdapter(@NonNull Context context, int resource, @NonNull List<Article> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemListView = convertView;
        if (itemListView == null) {
            itemListView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Article article = getItem(position);
        TextView textView = itemListView.findViewById(R.id.head_text_view);
        ImageView imageView = itemListView.findViewById(R.id.list_image_view);

        textView.setText(article.getArticleName());
        imageView.setImageBitmap(article.getArticleHeadImage());
        return itemListView;
    }
}
