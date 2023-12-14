package com.example.calculatorofson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity3 : AppCompatActivity() {

    private lateinit var adapter: Adapter
    private lateinit var fromActivity3ToActivity: Button
    private lateinit var tableList: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //tableList = findViewById(R.id.tableList)
        fromActivity3ToActivity = findViewById(R.id.fromActivity3ToActivity)
        fromActivity3ToActivity.setOnClickListener {
            val nextpage2 = Intent(this, MainActivity::class.java)
            startActivity(nextpage2)
            finish()
        }


        fetchDataFromDatabase()

    }

    private fun fetchDataFromDatabase() {
        GlobalScope.launch(Dispatchers.IO) {
            val database = Room.databaseBuilder(applicationContext, SleepDatabase::class.java, "sleep_entries.db").build()

            val sleepEntryDao = database.sleepEntryDao() // Получаем DAO из вашей базы данных Room
            val allSleepEntry = sleepEntryDao.getAllSleepEntries()
            adapter = Adapter(allSleepEntry.map {"Hours Slept: ${it.hoursSlept} Comment: ${it.comment} Sleep Quality: ${it.sleepQuality}\n\n"}.toTypedArray())
            findViewById<RecyclerView>(R.id.resys).adapter = adapter

            /*
            val combinedData = buildString {
                allSleepEntry.forEach {
                    append("Hours Slept: ${it.hoursSlept} Comment: ${it.comment} Sleep Quality: ${it.sleepQuality}\n\n")
                }
            }

            withContext(Dispatchers.Main) {
                tableList.text = combinedData
            }

             */
        }
    }
}