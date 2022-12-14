 package ru.michaeldzuba.sportapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import ru.michaeldzuba.sportapp.R

 class TutorialScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_screen)
        clickOnButtonStart()
    }

    private fun clickOnButtonStart() {
        findViewById<AppCompatButton>(R.id.btnStart).setOnClickListener {
            val intent = Intent(this, ChooseTypeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}