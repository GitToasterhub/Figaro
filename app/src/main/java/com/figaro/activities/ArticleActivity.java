package com.figaro.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;

import android.webkit.WebView;
import android.widget.TextView;

import com.figaro.R;
import com.figaro.adapters.ArticlesAdapter;
import com.figaro.entities.Article;
import com.figaro.entities.ArticleContent;
import com.figaro.parser.Requester;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class ArticleActivity extends Activity {
    private String articleUrl="http://figaro.service.yagasp.com/article/";
    private TextView titleView;
    private WebView contentView;
    private ArticleContent articleContent;
    private String link;
    private String title;
    private String articleId;
    private String response=null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        contentView=(WebView) findViewById(R.id.contentWebView);
        titleView=(TextView) findViewById(R.id.titleArticleView);

        articleId=getIntent().getStringExtra("articleId");
        title=getIntent().getStringExtra("title");
        link=getIntent().getStringExtra("link");

        titleView.setText(title);
        articleUrl+=articleId;

        new RequestArticleTask().execute();
    }

    private class RequestArticleTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            Requester requester=new Requester(articleUrl);
            try {
                response = requester.doGetRequest();
            } catch (IOException e) {
                e.printStackTrace();
            }
            response=response.substring(0,response.indexOf("lireAussi")-2);
            response+="}";
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new StringReader(response));
            reader.setLenient(true);
            articleContent = gson.fromJson(response,ArticleContent.class);
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            String content = "<img src=\"" + link.replace("%dx%d","800x600") + "\"><br>" + articleContent.getContent();
            contentView.loadData(content,"text/html",null);
        }

    }

}
