package com.example.demo.service;


import com.example.demo.entity.Movie;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.ArrayList;
import java.util.List;

public class MovieRepoPageProcessorDeep implements PageProcessor {

    @Override
    public void process(Page page) {

        Movie movie = new Movie();
        movie.setId((int)Math.floor(Math.random()*10000));
        movie.setName(page.getHtml().xpath("//*[@id=\"content\"]/h1/span[1]/text()").toString());
        movie.setScore(page.getHtml().xpath("//*[@id=\"interest_sectl\"]/div[1]/div[2]/strong/text()").toString());
        movie.setJian(page.getHtml().xpath("//*[@id=\"link-report\"]/span[1]/text()").toString());
        MoviePipeline.movies.add(movie);
    }

    @Override
    public Site getSite() {
        return Site.me().setTimeOut(5000).setRetryTimes(5);
    }
}
