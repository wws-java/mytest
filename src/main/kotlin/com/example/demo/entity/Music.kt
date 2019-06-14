package com.example.demo.entity

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
@ApiModel("音乐实体类")
data class Music(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                @ApiModelProperty(value = "音乐ID")
                var id: Int? = null,
                @ApiModelProperty(value = "音乐名")
                var MusicName: String? = null,
                @ApiModelProperty(value = "曲目和收藏")
                var rating: String? = null,
                @ApiModelProperty(value = "音乐出版人")
                var info: String? = null,
                @ApiModelProperty(value = "音乐简介")
                var note: String? = null)