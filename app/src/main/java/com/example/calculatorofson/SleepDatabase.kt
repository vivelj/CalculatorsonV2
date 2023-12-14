package com.example.calculatorofson

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [SleepEntry::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class SleepDatabase : RoomDatabase() {
    abstract fun sleepEntryDao(): SleepEntryDao
}