package ru.michaeldzuba.sportapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import ru.michaeldzuba.sportapp.R

class ChooseTypeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_type)

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
            val intent = Intent(this, ExercisesActivity::class.java)
            intent.putExtra("EX", findViewById<TextView>(R.id.tvArms).text)
            startActivity(intent)
        }
    }

    private fun clickOnPress(){
        findViewById<CardView>(R.id.cvPress).setOnClickListener {
            val intent = Intent(this, ExercisesActivity::class.java)
            intent.putExtra("EX", findViewById<TextView>(R.id.tvPress).text)
            startActivity(intent)
        }
    }

    private fun clickOnLegs(){
        findViewById<CardView>(R.id.cvLegs).setOnClickListener {
            val intent = Intent(this, ExercisesActivity::class.java)
            intent.putExtra("EX", findViewById<TextView>(R.id.tvLegs).text)
            startActivity(intent)
        }
    }

    private fun clickOnBack(){
        findViewById<CardView>(R.id.cvBack).setOnClickListener {
            val intent = Intent(this, ExercisesActivity::class.java)
            intent.putExtra("EX", findViewById<TextView>(R.id.tvBack).text)
            startActivity(intent)
        }
    }
}