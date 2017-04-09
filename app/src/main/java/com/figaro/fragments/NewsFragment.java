package com.figaro.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.figaro.R;
import com.figaro.activities.ArticleActivity;
import com.figaro.adapters.ArticlesAdapter;
import com.figaro.entities.Article;
import com.figaro.parser.Requester;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;




import java.io.IOException;
import java.io.StringReader;
import java.util.List;


public class NewsFragment extends Fragment {
    private String url="http://figaro.service.yagasp.com/article/header/QWN0dWFsaXTDqXNBY3R1YWxpdMOpcw==";
    private ListView listView;
    private List<Article> articlesList;
    private ArticlesAdapter articlesAdapter;
    private Context context;
    TextView textView;
    private String response;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        listView = (ListView) rootView.findViewById(R.id.articlesListView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        listView=(ListView) view.findViewById(R.id.articlesListView);
        context=this.getContext();
        textView=(TextView) view.findViewById(R.id.textView);
        switch (getArguments().getInt("position")) {
            case 0:
                url="http://figaro.service.yagasp.com/article/header/QWN0dWFsaXTDqXNBY3R1YWxpdMOpcw==";
                break;
            case 1:
                url="http://figaro.service.yagasp.com/article/header/Q3VsdHVyZUN1bHR1cmU=";
                break;
        }
        new RequestArticlesTask().execute();
    }

    private class RequestArticlesTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            Requester requester = new Requester(url);

            try {
                response=requester.doGetRequest();
            } catch (IOException e) {
                e.printStackTrace();
            }
            response=response.substring(response.indexOf(',')+1);
            Gson gson=new Gson();
            JsonReader reader = new JsonReader(new StringReader(response));
            reader.setLenient(true);

            articlesList = gson.fromJson(reader, new TypeToken<List<Article>>(){}.getType());
            return  null;
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            articlesAdapter=new ArticlesAdapter(getActivity(),articlesList);
            listView.setAdapter(articlesAdapter);
            listView.setClickable(true);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String articleId;
                    articleId=articlesList.get(position).getId();
                    Intent intent=new Intent(context,ArticleActivity.class);
                    intent.putExtra("articleId",articleId);
                    intent.putExtra("title",articlesList.get(position).getTitle());
                    intent.putExtra("link",articlesList.get(position).getThumb().getLink());
                    startActivity(intent);
                }
            });


        }

    }
}


