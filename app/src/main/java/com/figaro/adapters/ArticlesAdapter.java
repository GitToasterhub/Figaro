package com.figaro.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.figaro.R;
import com.figaro.entities.Article;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by PC on 08.04.2017.
 */

public class ArticlesAdapter extends BaseAdapter {
    List<Article> articlesList;
    LayoutInflater inflater;

    public ArticlesAdapter(Context context, List<Article> articlesList){
        this.articlesList=articlesList;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return articlesList.size();
    }

    @Override
    public Object getItem(int position) {
        return articlesList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            view=inflater.inflate(R.layout.articles_layout,parent,false);
        }
        Article article = articlesList.get(position);

        TextView titleView = (TextView) view.findViewById(R.id.titleTextView);
        titleView.setText(article.getTitle());

        TextView subTitleView = (TextView) view.findViewById(R.id.subTitleTextView);
        subTitleView.setText(article.getSubtitle());

        WebView webView = (WebView) view.findViewById(R.id.linkWebView);
        webView.loadData("<img src=\""+article.getThumb().getLink().replace("%dx%d","300x300")+"\" >","text/html",null);

        return view;
    }
}
