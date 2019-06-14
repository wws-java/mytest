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
//        movies = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        HashMap<String,List< Map<String,Object>>> map = new HashMap<>();
        try {
            map = objectMapper.readValue( page.getJson().toString(), map.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(map);
        List<Map<String,Object>> listMap = map.get("subjects");
        listMap.forEach(it -> {
//            Movie movie = new Movie();
//            movie.setId((int)Math.floor(Math.random()*10000));
            Spider.create(new MovieRepoPageProcessorDeep()).addUrl(it.get("url").toString()).addPipeline(new MoviePipeline()).runAsync();
//            movie.setScore(it.get("rate").toString());
//            movie.setName(it.get("title").toString());
//            movies.add(movie);
        });

    }
    @Override
    public Site getSite() {
        return Site.me().setTimeOut(3000).setRetryTimes(3);
    }
}
