package com.example.demo.service;

import com.example.demo.entity.Movie;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.util.ArrayList;
import java.util.List;

public class MoviePipeline implements Pipeline {
    public static List<Movie> movies = new ArrayList<>();
    public void process(ResultItems resultItems,Task task){
//        movies = resultItems.get("movies");
    }
}
