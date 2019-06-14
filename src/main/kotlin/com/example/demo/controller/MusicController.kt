package com.example.demo.controller

import com.example.demo.entity.Music
import com.example.demo.repository.MusicRepository
import com.example.demo.service.MusicPipeline
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
@Api("获取豆瓣书籍信息的Controller", tags = ["音乐控制器"], description = "处理http请求,获取爬取到的豆瓣音乐信息的控制器")
class MusicController {

    @Autowired
    private lateinit var musicRepository: MusicRepository

    @GetMapping("/musics/latest")
    @ApiOperation(value = "获取豆瓣最新音乐信息", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    fun getMusics(): List<Music> {
        musicRepository.deleteAll()
        musicRepository.saveAll(MusicPipeline.musics)
        return MusicPipeline.musics
    }
}