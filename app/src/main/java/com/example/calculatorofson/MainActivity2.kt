package com.example.calculatorofson

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.room.Room
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity2 : AppCompatActivity() {

    private lateinit var editTextHoursSlept: EditText
    private lateinit var editTextSleepQuality: EditText
    private lateinit var editTextComment: EditText
    private lateinit var editTextDate: EditText
    private lateinit var buttonAdd: Button
    private lateinit var sleepEntryDao: SleepEntryDao
    private lateinit var fromActivity2ToActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val db = Room.databaseBuilder(
            applicationContext,
            SleepDatabase::class.java, "sleep_entries.db"
        ).build()

        sleepEntryDao = db.sleepEntryDao()

        // Привязываем View к соответствующим переменным
        editTextHoursSlept = findViewById(R.id.editTextHoursSlept)
        editTextComment = findViewById(R.id.editTextComment)
        editTextSleepQuality = findViewById(R.id.editTextSleepQuality)
        editTextDate = findViewById(R.id.editTextDate)
        buttonAdd = findViewById(R.id.buttonAdd)
        fromActivity2ToActivity = findViewById(R.id.fromActivity2ToActivity)
        fromActivity2ToActivity.setOnClickListener {
            val nextpage2 = Intent(this, MainActivity::class.java)
            startActivity(nextpage2)
            finish()
        }

        // Устанавливаем обработчик нажатия на кнопку "Добавить"
        buttonAdd.setOnClickListener {
            addSleepEntryToDatabase()
        }
    }

    private fun addSleepEntryToDatabase() {
        val hoursSlept = editTextHoursSlept.text.toString()
        val comment = editTextComment.text.toString()
        val sleepQuality = editTextSleepQuality.text.toString().toFloat()
        val dateString = editTextDate.text.toString()
        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val date = dateFormat.parse(dateString)
        val sleepEntry = SleepEntry(hoursSlept, comment, sleepQuality, date)

        Thread {
            sleepEntryDao.insert(sleepEntry)
        }.start()

        Toast.makeText(this, "Запись о сне добавлена", Toast.LENGTH_SHORT).show()
    }

}