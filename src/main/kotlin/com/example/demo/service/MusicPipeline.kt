package com.example.demo.service

import com.example.demo.entity.Music
import us.codecraft.webmagic.ResultItems
import us.codecraft.webmagic.Task
import us.codecraft.webmagic.pipeline.Pipeline

class MusicPipeline : Pipeline {

    companion object {
        lateinit var musics: List<Music>
    }

    override fun process(resultItems: ResultItems, task: Task) {
        musics = resultItems.get<List<Music>>("musics")
    }

}