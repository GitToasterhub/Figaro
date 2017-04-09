package com.figaro.parser;

/**
 * Created by PC on 08.04.2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester {
    private String url;

    public Requester(){ //By default we request Actualities articles
        url="http://figaro.service.yagasp.com/article/header/QWN0dWFsaXTDqXNBY3R1YWxpdMOpcw==";
    }

    public Requester(String url){
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String doGetRequest() throws IOException {
        StringBuilder response = new StringBuilder();
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine())!= null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }




}