package com.example.calculatorofson

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var buttonToEdit: Button
    private lateinit var buttonToState: Button
    private lateinit var buttonToFAQ: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToEdit = findViewById(R.id.buttonToEdit)
        buttonToEdit.setOnClickListener {
            val nextpage2 = Intent(this, MainActivity2::class.java)
            startActivity(nextpage2)
            finish()
        }
        buttonToState = findViewById(R.id.buttonToState)
        buttonToState.setOnClickListener {
            val nextpage3 = Intent(this, MainActivity3::class.java)
            startActivity(nextpage3)
            finish()
        }
        buttonToFAQ = findViewById(R.id.buttonToFAQ)
        buttonToFAQ.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            with(builder) {
                builder.setTitle("F.A.Q.")
                builder.setIcon(android.R.drawable.ic_dialog_alert)
                builder.setMessage(
                    "Ночной качественный сон необходим для здоровья человека." +
                            " Сон важен, поскольку организму нужно восстановливать ту энергию," +
                            " которую человек тратит на активную деятельность. Во время сна " +
                            " происходит сортировка информации, полученной в течение бодрствования." +
                            " Ненужная информация отсеивается, а нужная усваивается и попадает в " +
                            " долгую память. Полноценный сон дает возможность быть более продуктивным" +
                            " в течение дня. Длительные периоды недосыпа влияют негативно: человек" +
                            " становится более невнимательным, появляется разрдражительность."
                )
                builder.setPositiveButton("OK", null)
                builder.show()
            }

        }
    }
}