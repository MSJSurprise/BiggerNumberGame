package com.example.biggernumbergame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLeft: Button = findViewById(R.id.btn_left)
        val btnRight: Button = findViewById(R.id.btn_right)
        btnRight.text = Random().nextInt(10).toString()
        btnLeft.text = Random().nextInt(10).toString()

        while (btnLeft.text.toString().toInt() == btnRight.text.toString().toInt()) {
            btnRight.text = Random().nextInt(10).toString()
            btnLeft.text = Random().nextInt(10).toString()
        }

        btnLeft.setOnClickListener {
            checkNum("left") // true
        }
        btnRight.setOnClickListener {
            checkNum() // false
        }
    }


private fun checkNum(name: String? = null) {
    val btnRight: Button = findViewById(R.id.btn_right)
    val btnLeft: Button = findViewById(R.id.btn_left)

    if (name == "left") {
        if (btnLeft.text.toString().toInt() > btnRight.text.toString().toInt())
            Toast.makeText(this, "You're Right", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "You're Wrong", Toast.LENGTH_SHORT).show()
    } else /*if (name == "Right") */ {
        if (btnRight.text.toString().toInt() > btnLeft.text.toString().toInt())
            Toast.makeText(this, "You're Right again", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "You're Wrong again", Toast.LENGTH_SHORT).show()
    }

    btnLeft.text = Random().nextInt(10).toString()
    btnRight . text = Random ().nextInt(10).toString()

    while (btnLeft.text.toString().toInt() == btnRight.text.toString().toInt()) {
        btnLeft.text = Random().nextInt(10).toString()
        btnRight.text = Random().nextInt(10).toString()            }
        }

}