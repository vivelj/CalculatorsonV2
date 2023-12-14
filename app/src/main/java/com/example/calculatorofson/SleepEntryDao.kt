package com.example.calculatorofson

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SleepEntryDao {
    @Query("SELECT * FROM sleep_entries")
    fun getAllSleepEntries(): List<SleepEntry>

    @Insert
    fun insert(sleepEntry: SleepEntry)
}
