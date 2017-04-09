package com.figaro.parser;

import com.figaro.entities.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.List;

/**
 * Created by PC on 08.04.2017.
 */
// Going to be deleted
@Deprecated
public class Parser {
    String json;

    public Parser(String json){
        this.json=json;
    }

    public List<Article> parseJson() throws IOException {
        Gson gson=new Gson();
        List<Article> articles = gson.fromJson(json, new TypeToken<List<Article>>(){}.getType());
        return articles;
    }




}
