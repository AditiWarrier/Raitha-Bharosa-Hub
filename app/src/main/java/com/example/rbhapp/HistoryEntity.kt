package com.example.rbhapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_table")
data class HistoryEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val moisture: String,

    val nitrogen: String,

    val phosphorus: String,

    val potassium: String,

    val sowingIndex: String,

    val recommendation: String,

    val timestamp: Long
)