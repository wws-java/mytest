package com.example.demo

import com.example.demo.service.BookPipeline
import com.example.demo.service.BookRepoPageProcessor
import com.example.demo.service.MoviePipeline
import com.example.demo.service.MovieRepoPageProcessor
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement
import springfox.documentation.swagger2.annotations.EnableSwagger2
import us.codecraft.webmagic.Spider

@SpringBootApplication
@EnableScheduling// 开启定时任务
@EnableTransactionManagement
class DemoApplication

fun main(args: Array<String>) {
    // 爬取豆瓣的最新书籍

//    Spider.create(BookRepoPageProcessor()).addUrl("https://book.douban.com/latest?icn=index-latestbook-all").addPipeline(BookPipeline()).runAsync()
//    runApplication<DemoApplication>(*args)
    Spider.create(MovieRepoPageProcessor()).addUrl("https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20&page_start=0").addPipeline(MoviePipeline()).runAsync()
    runApplication<DemoApplication>(*args)
}
