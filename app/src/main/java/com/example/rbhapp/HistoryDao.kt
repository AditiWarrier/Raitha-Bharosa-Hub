package com.example.rbhapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {

    @Insert
    suspend fun insertHistory(
        historyEntity: HistoryEntity
    )

    @Query(
        "SELECT * FROM history_table ORDER BY id DESC"
    )
    suspend fun getAllHistory():
            List<HistoryEntity>
}