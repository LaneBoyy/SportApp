package ru.michaeldzuba.sportapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.cardview.widget.CardView

class ChooseTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_type)

        val w = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setClicks()
    }

    private fun setClicks() {
        clickOnArms()
        clickOnPress()
        clickOnLegs()
        clickOnBack()
    }

    private fun clickOnArms(){
        findViewById<CardView>(R.id.cvArms).setOnClickListener {
            val intent = Intent(this, ArmsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickOnPress(){
        findViewById<CardView>(R.id.cvPress).setOnClickListener {
            val intent = Intent(this, ArmsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickOnLegs(){
        findViewById<CardView>(R.id.cvLegs).setOnClickListener {
            val intent = Intent(this, ArmsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun clickOnBack(){
        findViewById<CardView>(R.id.cvBack).setOnClickListener {
            val intent = Intent(this, ArmsActivity::class.java)
            startActivity(intent)
        }
    }
}