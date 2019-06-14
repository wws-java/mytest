package com.example.demo.service;

import com.example.demo.entity.Music;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import org.apache.commons.io.FileUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Json;
import us.codecraft.webmagic.selector.Selectable;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MusicRepoPageProcessor implements PageProcessor {


    @Override
    public void process(Page page) {
            List<Music> musics = new ArrayList<>();

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<>();
        try {
            List<Selectable> musicList =  page.getJson().jsonPath("$[*]").nodes();
            musicList.forEach( it -> {
                Map<String, Object> jsonMap = null;
                try {
                     jsonMap = objectMapper.readValue(it.toString(), map.getClass());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Music music=new Music();
                music.setId((int)Math.floor(Math.random()*10000));
                music.setMusicName(jsonMap.get("title").toString());
                Object[] artists = ((List<Map<String, Object>>)jsonMap.get("sample_songs")).stream().map(a -> a.get("artist")).toArray();
                music.setRating("曲目:"+jsonMap.get("songs_count")+ "收藏:"+jsonMap.get("collected_count"));
                music.setNote(Arrays.toString(artists));
                music.setInfo(((Map<String, Object>)jsonMap.get("creator")).get("name").toString());
                musics.add(music);
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        page.putField("musics", musics);
    }
    @Override
    public Site getSite() {
        return Site.me();
    }
}
