package com.example.biggernumbergame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addRandomNum()
        val btnLeft: Button = findViewById(R.id.btn_left)
        val btnRight: Button = findViewById(R.id.btn_right)
        btnLeft.setOnClickListener {
            checkNum("left") // true
        }
        btnRight.setOnClickListener {
            checkNum() // false
        }
    }

    private fun addRandomNum() {
        val r = Random()
        val leftbtn = r.nextInt(10)
        var rightbtn = leftbtn
        while (leftbtn == rightbtn) {
            rightbtn = r.nextInt(10)
        }

        val btnLeft: Button = findViewById(R.id.btn_left)
        val btnRight: Button = findViewById(R.id.btn_right)
        btnLeft.text = leftbtn.toString()
        btnRight.text = rightbtn.toString()

    }

    private fun checkNum(name: String? = null) {
        val btnRight: Button = findViewById(R.id.btn_right)
        val btnLeft: Button = findViewById(R.id.btn_left)
        val backgroundView: ConstraintLayout = findViewById(R.id.backgroundView)

        if (name == "left") {
            if (btnLeft.text.toString().toInt() > btnRight.text.toString().toInt()) {
                backgroundView.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "You're Right", Toast.LENGTH_SHORT).show()
            }else {
                backgroundView.setBackgroundColor(Color.RED)
                Toast.makeText(this, "You're Wrong", Toast.LENGTH_SHORT).show()}
        } else /*if (name == "Right") */ {
            if (btnRight.text.toString().toInt() > btnLeft.text.toString().toInt()) {
                backgroundView.setBackgroundColor(Color.GREEN)
                Toast.makeText(this, "You're Right again", Toast.LENGTH_SHORT).show()
            }else
                backgroundView.setBackgroundColor(Color.RED)
                Toast.makeText(this, "You're Wrong again", Toast.LENGTH_SHORT).show()
        }

        addRandomNum()
    }
}