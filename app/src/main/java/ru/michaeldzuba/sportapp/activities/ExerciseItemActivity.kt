package ru.michaeldzuba.sportapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.michaeldzuba.sportapp.ExerciseItem
import ru.michaeldzuba.sportapp.R

class ExerciseItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_item)

        Toast.makeText(this, intent.getStringExtra(ExercisesActivity.INTENT_KEY), Toast.LENGTH_SHORT).show()
    }
}