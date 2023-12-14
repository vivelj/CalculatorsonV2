package com.example.calculatorofson

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "sleep_entries")
data class SleepEntry(
    val hoursSlept: String,
    val comment: String,
    val sleepQuality: Float,
    val date: Date,
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0
)