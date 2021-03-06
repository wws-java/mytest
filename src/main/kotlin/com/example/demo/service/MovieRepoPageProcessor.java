package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Selectable;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieRepoPageProcessor implements PageProcessor {
//    public static List<Movie> movies = new ArrayList<>();
    @Override
    public void process(Page page) {

        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String,List< Map<String,Object>>> map = new HashMap<>();
        try {
            map = objectMapper.readValue( page.getJson().toString(), map.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Map<String,Object>> listMap = map.get("subjects");
        listMap.forEach(it -> {
            Spider.create(new MovieRepoPageProcessorDeep()).addUrl(it.get("url").toString()).addPipeline(new MoviePipeline()).runAsync();
        });

    }
    @Override
    public Site getSite() {
        return Site.me().setTimeOut(3000).setRetryTimes(3);
    }
}
