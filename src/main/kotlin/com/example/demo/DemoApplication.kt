package com.example.demo

import com.example.demo.service.BookPipeline
import com.example.demo.service.BookRepoPageProcessor
import com.example.demo.service.MusicPipeline
import com.example.demo.service.MusicRepoPageProcessor
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
    Spider.create(BookRepoPageProcessor()).addUrl("https://book.douban.com/latest?icn=index-latestbook-all").addPipeline(BookPipeline()).runAsync()
    Spider.create(MusicRepoPageProcessor()).addUrl("https://douban.fm/j/v2/songlist/explore?type=hot&genre=0&limit=20&sample_cnt=5").addPipeline(MusicPipeline()).runAsync()
    runApplication<DemoApplication>(*args)
}
