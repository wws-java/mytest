package com.example.demo.controller;


import com.example.demo.entity.Movie;
import com.example.demo.repository.MovieRepository;
import com.example.demo.service.MoviePipeline;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "获取豆瓣电影信息的Controller", tags = {"电影控制器"}, description = "处理http请求,获取爬取到的豆瓣电影信息的控制器")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(value = "/movie/hot")
    @ApiOperation(value = "获取豆瓣最新电影信息", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Movie> getMovies(){
        movieRepository.deleteAll();
        movieRepository.saveAll(MoviePipeline.movies);
        return MoviePipeline.movies;
    }
}
