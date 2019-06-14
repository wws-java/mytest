package com.example.demo.repository

import com.example.demo.entity.Music
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicRepository: JpaRepository<Music, Int>